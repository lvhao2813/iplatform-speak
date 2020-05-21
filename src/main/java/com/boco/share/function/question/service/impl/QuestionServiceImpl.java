/**
 * 
 */
package com.boco.share.function.question.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.StringUtils;
import com.boco.share.framework.common.DateUtils;
import com.boco.share.framework.common.FileUtils;
import com.boco.share.framework.common.PinYinUtil;
import com.boco.share.framework.common.UuidUtil;
import com.boco.share.function.common.bean.Attachment;
import com.boco.share.function.common.bean.AttachmentUnit;
import com.boco.share.function.common.bean.Sort;
import com.boco.share.function.question.bean.ApiChineseDetail;
import com.boco.share.function.question.bean.ApiQuestion;
import com.boco.share.function.question.bean.Chinese;
import com.boco.share.function.question.bean.ChineseUnit;
import com.boco.share.function.question.bean.Question;
import com.boco.share.function.question.bean.QuestionDetail;
import com.boco.share.function.question.dao.QuestionMapper;
import com.boco.share.function.question.service.inter.QuestionService;

/**
 * @author LOVE
 *
 */
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionMapper mapper;

	@Override
	public List<Sort> queryQuestionSorts() {
		return mapper.queryQuestionSorts();
	}

	@Override
	public List<Question> loadQuestions(Map<String, String> formMap) {
		List<Question> questions = mapper.loadQuestions(formMap);
		return questions;
	}

	@Override
	@Transactional
	public void genQuestion(Map<String, String> formMap, MultipartFile file) throws Exception {
		// 保存题目对象
		Question question = new Question();
		question.setId(UuidUtil.genUUID());
		question.setName(formMap.get("name"));
		question.setSortId(formMap.get("type"));
		if (file != null) {
			question.setAttachmentUnitId(uploadFile(file));
		}
		mapper.saveQuestion(question);
		// 保存题目分组明细
		String type = formMap.get("type");
		switch (type) {
		case "1":
			saveSingleDetail(question.getId(), formMap.get("details"));
			break;
		case "2":
			saveMultiWrodDetail(question.getId(), formMap.get("details"));
			break;
		case "3":
			saveSentenceDetail(question.getId(), formMap.get("details"));
			break;
		default:
			break;
		}
	}

	@Override
	@Transactional
	public void deleteQuestion(String deleteId) {
		Question question = mapper.queryQuestionById(deleteId);
		if ("mingtilianxi".equals(question.getSortCode())) {
			mapper.deleteQuestionById(deleteId);
			//为了删除文件，需要查询数据库获得附件路径
			String unitId = question.getAttachmentUnitId();
			Attachment attach = mapper.queryAttachByUnitId(unitId);
			String path = attach.getPath();
			File file = new File(path);
			file.delete();
			//删除两个表记录和 路径对应文件
			mapper.deleteAttachByUnitId(unitId);
			mapper.deleteAttachUnitById(unitId);
		} else {
			// 删除三个表
			// question表 通过 deleteId
			// question_detail 表 通过 其 question_id 为 deleteId
			// chinese_unit 表 通过 查表 question_detail 得到 所有要删除的 question_detail_id

			// 得到要删除 chinese_unit表中 的所有 question_detail_id
			List<String> deleteDetailIds = mapper.queryDetialIdByQuestId(deleteId);

			// 删除的时候最好从底层表 向 上层表删
			mapper.deleteUnitByDetailId(deleteDetailIds);
			mapper.deleteDetailByQuetionId(deleteId);
			mapper.deleteQuestionById(deleteId);
		}
	}

	@Override
	public void batchDeleteQuestions(String[] deleteIds) {
		// 因为逻辑和单个删除几乎一样,就直接用 单个删除了
		for (String deleteId : deleteIds) {
			deleteQuestion(deleteId);
		}
	}

	@Override
	public ApiQuestion info(Map<String, String> formMap) {
		Question question = mapper.queryQuestionById(formMap.get("questionId"));
		return converterToApiQuestion(question);
	}

	@Override
	public List<String> getAllChooseFromChinese(Map<String, String> formMap) {
		char[] chars = formMap.get("CHINESE").toCharArray();
		String[] PinYins = PinYinUtil.getPinyinBySingWord(chars[0]);
		List<String> resultList = new ArrayList<>();
		for (String s : PinYins) {
			resultList.add(s);
		}
		return resultList;
	}

	@Override
	public void changePinYin(Map<String, String> formMap) {
		String chineseId = getOneChineseId(formMap.get("CHINESE"), formMap.get("PINYIN"));
		formMap.put("chineseId", chineseId);
		mapper.updateChineseUnit(formMap);
	}

	@Override
	public void addSingleAttach(Map<String, String> formMap, MultipartFile file) throws Exception {
		String unitId = null;
		if (file != null) {
			unitId = uploadFile(file);
		}
		formMap.put("unitId", unitId);
		mapper.addChineseAttUnitId(formMap);
	}

	/**
	 * 上传附件，返回附件包
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private String uploadFile(MultipartFile file) throws IOException {
		// 保存文件到本地磁盘,同时生成对象，保存路径方便后续取
		byte[] bytes = file.getBytes();
		String resourceBasePath = FileUtils.getResourceBasePath() + "/static/mp3";
		File fileDir = new File(resourceBasePath);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		String fileName = DateUtils.getNowDateNum() + "_" + file.getOriginalFilename();
		Path path = Paths.get(resourceBasePath + fileName);
		Files.write(path, bytes);
		// 保存对应的附件对象
		AttachmentUnit unit = new AttachmentUnit();
		String unitId = UuidUtil.genUUID();
		unit.setId(unitId);
		// save
		mapper.saveAttachmentUnit(unit);
		Attachment attachment = new Attachment();
		attachment.setId(UuidUtil.genUUID());
		attachment.setName(fileName);
		attachment.setPath(resourceBasePath + fileName);
		attachment.setAttachmentUnitId(unitId);
		// save
		mapper.saveAttachment(attachment);
		return unitId;
	}

	/**
	 * 将question数据库对象，转换成前台展示对象
	 * 
	 * @param question
	 * @return
	 */
	private ApiQuestion converterToApiQuestion(Question question) {
		ApiQuestion result = new ApiQuestion();
		result.setId(question.getId());
		result.setCreateDate(question.getCreateDate());
		result.setName(question.getName());
		result.setSortName(question.getSortName());
		result.setAttachmentName(question.getAttachmentName());
		result.setPath(question.getPath());
		// 构建题目全内容
		StringBuffer conent = new StringBuffer();
		// 构建汉字包
		List<ApiChineseDetail> details = new ArrayList<ApiChineseDetail>();

		if (!question.getDetails().isEmpty()) {
			int i = 0;
			for (QuestionDetail queDetail : question.getDetails()) {
				// 词语练习添加逗号
				if ("2".equals(question.getSortId())) {
					conent.append(i > 0 ? "，" : "").append(queDetail.getWord());
				} else {
					conent.append(queDetail.getWord());
				}
				i++;
				if (!queDetail.getDetails().isEmpty()) {
					for (ChineseUnit unit : queDetail.getDetails()) {
						if (unit.getChinese() == null) {
							continue;
						} else {
							ApiChineseDetail c = new ApiChineseDetail();
							c.setChineseId(unit.getChinese().getId());
							c.setChineseUnitId(unit.getId());
							c.setChinese(unit.getChinese().getChinese());
							c.setPinyin(unit.getChinese().getPinyin());
							c.setAttachmentName(unit.getChinese().getAttachmentName());
							c.setPath(unit.getChinese().getPath());
							details.add(c);
						}
					}
				}
			}
		}

		result.setContent(conent.toString());
		result.setDetails(details);
		return result;
	}

	/**
	 * 保存短文题目
	 * 
	 * @param questionId 问题对象id
	 * @param content    题目内容
	 */
	private void saveSentenceDetail(String questionId, String content) {
		/*
		 * 短文按段落在 detail表里排序，一段相当于词组练习的一个词，以便后期取用有序。
		 */
		// 将传来的content字符串分割为单个词语
		String[] paragraphs = content.split("\r\n");

		// 题目内容分类明细
		List<QuestionDetail> details = new ArrayList<QuestionDetail>();
		// 明细对应的汉字包
		List<ChineseUnit> units = new ArrayList<ChineseUnit>();

		for (int i = 0; i < paragraphs.length; ++i) {
			String paragraph = paragraphs[i]; // 拿到一段话
			String[] paragraphPinyin = PinYinUtil.getPinyinByWord(paragraph);

			// detail表里 是按 "我们" "世界" 存的
			QuestionDetail detail = new QuestionDetail();
			String detailId = UuidUtil.genUUID();
			detail.setId(detailId);
			detail.setQuestionId(questionId);
			detail.setWord(paragraph);
			detail.setOrd(i + 1);
			details.add(detail);
			char[] singleWords = paragraph.toCharArray(); // 最后ChineseUnit 和 Chinese 表还存的是单个的字
			for (int j = 0; j < singleWords.length; ++j) {
				String singleWord = String.valueOf(singleWords[j]);
				// 对应单字，一个detail是多个字，这里拆开，对应的汉字包是一个
				ChineseUnit unit = new ChineseUnit();
				unit.setId(UuidUtil.genUUID());
				unit.setQuestionsDetailId(detailId);
				unit.setOrd(j + 1);
				unit.setChineseId(getOneChineseId(singleWord, paragraphPinyin[j]));
				units.add(unit);
			}
		}
		mapper.saveQuestionDetails(details);
		mapper.saveChineseUnits(units);
	}

	/**
	 * 保存词语题目
	 * 
	 * @param questionId 问题对象id
	 * @param content    题目内容
	 */
	private void saveMultiWrodDetail(String questionId, String content) {
		// 将传来的content字符串分割为单个词语
		String[] multiWords = content.split("，");

		// 题目内容分类明细
		List<QuestionDetail> details = new ArrayList<QuestionDetail>();
		// 明细对应的汉字包
		List<ChineseUnit> units = new ArrayList<ChineseUnit>();

		for (int i = 0; i < multiWords.length; ++i) {
			String multiWord = multiWords[i]; // 拿到要存的那个词 "我的"
			String[] multiPinyin = PinYinUtil.getPinyinByWord(multiWord);

			// detail表里 是按 "我们" "世界" 存的
			QuestionDetail detail = new QuestionDetail();
			String detailId = UuidUtil.genUUID();
			detail.setId(detailId);
			detail.setQuestionId(questionId);
			detail.setWord(multiWord);
			detail.setOrd(i + 1);
			details.add(detail);
			char[] singleWords = multiWord.toCharArray(); // 最后ChineseUnit 和 Chinese 表还存的是单个的字
			for (int j = 0; j < singleWords.length; ++j) {
				String singleWord = String.valueOf(singleWords[j]);
				// 对应单字，一个detail是多个字，这里拆开，对应的汉字包是一个
				ChineseUnit unit = new ChineseUnit();
				unit.setId(UuidUtil.genUUID());
				unit.setQuestionsDetailId(detailId);
				unit.setOrd(j + 1);
				unit.setChineseId(getOneChineseId(singleWord, multiPinyin[j]));
				units.add(unit);
			}
		}
		mapper.saveQuestionDetails(details);
		mapper.saveChineseUnits(units);
	}

	/**
	 * 保存单字题目
	 * 
	 * @param questionId 问题对象id
	 * @param content    题目内容
	 */
	private void saveSingleDetail(String questionId, String content) {
		// 题目分隔单个中文
		char[] contents = content.toCharArray();
		String[] chinesePinyin = PinYinUtil.getPinyinByWord(content);
		// 题目内容分类明细
		List<QuestionDetail> details = new ArrayList<QuestionDetail>();
		// 明细对应的汉字包
		List<ChineseUnit> units = new ArrayList<ChineseUnit>();
		for (int i = 0; i < contents.length; i++) {
			String word = String.valueOf(contents[i]);

			QuestionDetail detail = new QuestionDetail();
			String detailId = UuidUtil.genUUID();
			detail.setId(detailId);
			detail.setQuestionId(questionId);
			detail.setWord(word);
			detail.setOrd(i + 1);

			// 对应单字，一个detail就是一个字，对应的汉字包也是一个
			ChineseUnit unit = new ChineseUnit();
			unit.setId(UuidUtil.genUUID());
			unit.setQuestionsDetailId(detailId);
			unit.setOrd(1);
			unit.setChineseId(getOneChineseId(word, chinesePinyin[i]));
			units.add(unit);
			details.add(detail);
		}
		mapper.saveQuestionDetails(details);
		mapper.saveChineseUnits(units);
	}

	/**
	 * 获取单个汉字的id
	 * 
	 * @param hanziAndPy 汉字 拼音
	 * @return chinese对象id
	 */
	private String getOneChineseId(String hanzi, String pinyin) {
		String hzAndPy = hanzi + "_" + pinyin;
		String chineseId = mapper.getOneChineseId(hzAndPy);
		if (!StringUtils.isEmpty(chineseId)) {
			return chineseId;
		} else {
			chineseId = UuidUtil.genUUID();
			Chinese chinese = new Chinese();
			chinese.setId(chineseId);
			chinese.setChinese(hanzi);
			chinese.setPinyin(pinyin);
			chinese.setHzAndpy(hzAndPy);
			mapper.saveChines(chinese);

			return chineseId;
		}
	}
	

}

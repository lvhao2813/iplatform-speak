/**
 * 
 */
package com.boco.share.function.question.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.function.question.bean.ApiChineseDetail;
import com.boco.share.function.question.bean.Chinese;
import com.boco.share.function.question.bean.ChineseUnit;
import com.boco.share.function.question.bean.Question;
import com.boco.share.function.question.bean.QuestionDetail;
import com.boco.share.function.question.bean.exam.ApiExamQuestion;
import com.boco.share.function.question.bean.exam.ApiExamQuestionDetail;
import com.boco.share.function.question.dao.QuestionMapper;
import com.boco.share.function.question.service.inter.OnlineExamService;

/**
 * @author LOVE
 *
 */
@Service
public class OnlineExamServiceImpl implements OnlineExamService {

	@Autowired
	private QuestionMapper mapper;
	
	@Override
	public ApiExamQuestion info(Map<String, String> formMap) {
		Question question = mapper.queryQuestionById(formMap.get("questionId"));
		return converterToApiExamQuestion(question);
	}
	
	/**
	 * 将question数据库对象，转换成前台展示对象
	 * 
	 * @param question
	 * @return
	 */
	private ApiExamQuestion converterToApiExamQuestion(Question question) {
		ApiExamQuestion result = new ApiExamQuestion();
		result.setPath(question.getPath());
		
		// 构建词语分类
		List<ApiExamQuestionDetail> details = new ArrayList<ApiExamQuestionDetail>();

		if (!question.getDetails().isEmpty()) {
			Map<String,Chinese> chineseMap = listToMap(question);
			for (QuestionDetail queDetail : question.getDetails()) {
				ApiExamQuestionDetail apiDetail = new ApiExamQuestionDetail();
				if (!queDetail.getDetails().isEmpty()) {
					// 构建对应分类的汉字包
					List<ApiChineseDetail> chineses = new ArrayList<ApiChineseDetail>();					
					for (ChineseUnit unit : queDetail.getDetails()) {
						Chinese singleChinese = chineseMap.get(unit.getChineseId());
						if (singleChinese != null) {	
							ApiChineseDetail c = new ApiChineseDetail();
							c.setChineseId(singleChinese.getId());
							c.setChineseUnitId(unit.getId());
							c.setChinese(singleChinese.getChinese());
							c.setPinyin(singleChinese.getPinyin());
							c.setAttachmentName(singleChinese.getAttachmentName());
							c.setPath(singleChinese.getPath());
							chineses.add(c);
						}
					}
					//for循环遍历分类对应的各个汉字结束后, add到分类list
					apiDetail.setChinese(chineses);
				}
				details.add(apiDetail);
			}
		}
		result.setDetails(details);
		return result;
	}
	
	private Map<String,Chinese> listToMap(Question question ){
		List<String> chineseIds =new ArrayList<>();

		for (QuestionDetail detail : question.getDetails()) {
			for(ChineseUnit unit : detail.getDetails()) {
				if(unit!=null) {
					chineseIds.add(unit.getChineseId());	
				}
			}
		}
		List<Chinese> chinesesList = mapper.queryChineseListByIds(chineseIds);
		Map<String,Chinese> chineseMap = new HashMap<String, Chinese>();
		for(Chinese chinese :chinesesList) {
			chineseMap.put(chinese.getId(), chinese);
		}
		return chineseMap;
	}

}

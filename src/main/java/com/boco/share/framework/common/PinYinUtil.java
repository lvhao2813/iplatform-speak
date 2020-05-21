package com.boco.share.framework.common;
/**
 * 生成汉字对应拼音的工具类
 * @author xp
 *
 */

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

public class PinYinUtil {

	/**
	 * 根据输入的 单字转成相应的拼音
	 * 
	 * @param sInput
	 * @return
	 */
	public static String[] getPinyinBySingWord(char c) {
		/**
		 * 获取某个中文字符可能的发音，如 为可以有两种发音[wèi, wéi]
		 */
		if(!String.valueOf(c).matches("[\u4e00-\u9fa5]")) {
			return new String[] {String.valueOf(c)};
		}
		return PinyinHelper.convertToPinyinArray(c);
		// [wèi, wéi]
		// System.out.println(Arrays.toString(weiArray));

	}

	/**
	 * 根据输入的中文字符串 转出相应的拼音
	 * 
	 * @param sInput
	 * @return
	 */
	@SuppressWarnings("finally")
	public static String[] getPinyinByWord(String sInput) {
		if (sInput == null) {
			return null;
		}
		String[] pinyins = null;
		try {
			String pinyinString = PinyinHelper.convertToPinyinString(sInput, "-", PinyinFormat.WITH_TONE_MARK);
			pinyins = pinyinString.split("-");
			System.out.println(pinyinString);
		} catch (PinyinException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return pinyins;
		}
	}
}

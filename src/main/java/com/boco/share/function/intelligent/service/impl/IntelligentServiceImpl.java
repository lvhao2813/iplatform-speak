package com.boco.share.function.intelligent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.boco.share.function.intelligent.dao.IntelligentMapper;
import com.boco.share.function.intelligent.service.inter.IntelligentService;

public class IntelligentServiceImpl implements IntelligentService {

	@Autowired
	private IntelligentMapper intelligentMapper;

	@Override
	public void saveQuestion(String question) {
		intelligentMapper.saveQuestion(question);
	}

}

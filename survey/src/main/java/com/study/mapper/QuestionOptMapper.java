package com.study.mapper;

import com.study.entity.QuestionOpt;

import java.util.List;
import java.util.Map;

public interface QuestionOptMapper {
	public int create(QuestionOpt pi);
	public int delete(Map<String, Object> paramMap);
	public int update(Map<String, Object> paramMap);
	public List<QuestionOpt> query(Map<String, Object> paramMap);
	public QuestionOpt detail(Map<String, Object> paramMap);
	public int count(Map<String, Object> paramMap);
}
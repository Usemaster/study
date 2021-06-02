package com.study.mapper;

import com.study.entity.AnswerOpt;

import java.util.List;
import java.util.Map;

public interface AnswerOptMapper {
	public int create(AnswerOpt pi);
	public int delete(Map<String, Object> paramMap);
	public int update(Map<String, Object> paramMap);
	public List<AnswerOpt> query(Map<String, Object> paramMap);
	public AnswerOpt detail(Map<String, Object> paramMap);
	public int count(Map<String, Object> paramMap);
}
package com.study.mapper;

import com.study.entity.Question;

import java.util.List;
import java.util.Map;

public interface QuestionMapper {
	public int create(Question pi);
	public int delete(Map<String, Object> paramMap);
	public int update(Map<String, Object> paramMap);
	public List<Question> query(Map<String, Object> paramMap);
	public Question detail(Map<String, Object> paramMap);
	public int count(Map<String, Object> paramMap);
}
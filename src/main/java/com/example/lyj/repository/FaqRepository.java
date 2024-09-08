package com.example.lyj.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.lyj.vo.FAQ;

@Mapper
public interface FaqRepository {
	
	@Select("SELECT * FROM faq WHERE question LIKE #{faqKeyword} ORDER BY id DESC")
	public List<FAQ> getFaqs(String faqKeyword);
}

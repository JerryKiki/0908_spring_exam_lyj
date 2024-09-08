package com.example.lyj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lyj.repository.FaqRepository;
import com.example.lyj.vo.FAQ;

@Service
public class FaqService {
	
	@Autowired
	private FaqRepository faqRepository;

	public List<FAQ> getFaqs(String faqKeyword) {
		
		faqKeyword = "%" + faqKeyword + "%";
		
		return faqRepository.getFaqs(faqKeyword);
	}

}

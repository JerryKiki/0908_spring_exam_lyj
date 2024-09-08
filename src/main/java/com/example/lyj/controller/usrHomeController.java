package com.example.lyj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lyj.service.FaqService;
import com.example.lyj.vo.FAQ;

@Controller
public class usrHomeController {
	
	@Autowired
	FaqService faqService;
	
	@RequestMapping("usr/home/main")
	public String showMain() {
		return "/usr/home/main";
	}
	
	@RequestMapping("/")
	public String showRoot() {
		return "redirect:/usr/home/main";
	}
	
	@RequestMapping("usr/home/faqSearch")
	public String faqSearch() {
		return "usr/home/FAQSearch";
	}
	
	@RequestMapping("usr/home/getFAQs")
	public String getFAQs(Model model, String FAQKeyword) {
		
		List<FAQ> faqs = faqService.getFaqs(FAQKeyword);
		
		if (faqs.isEmpty()) { 
			model.addAttribute("noneAnswers", true);
			return "/usr/home/FAQAnswer";
		}
		
		model.addAttribute("faqs", faqs);
		model.addAttribute("totalCount", faqs.size());
		
		return "usr/home/FAQAnswer";
	}
}

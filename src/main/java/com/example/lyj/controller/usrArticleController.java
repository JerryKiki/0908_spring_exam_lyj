package com.example.lyj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lyj.service.ArticleService;
import com.example.lyj.vo.Article;

@Controller
public class usrArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping("/usr/article/getArticle")
	public String getArticle(int id, Model model) {

		boolean noArticle = false;

		Article article = articleService.getArticleById(id);

		if (article == null) {
			noArticle = true;
			model.addAttribute("noArticle", noArticle);
			return "/usr/alert";
		}

		model.addAttribute("article", article);
		return "/usr/article/detail";
	}

	@RequestMapping("/usr/article/doModify")
	public String showModify(Model model, int id, String title, String body) {

		boolean noArticle = false;
		boolean articleModified = false;

		if (title == null && body == null) {

			Article Oldarticle = articleService.getArticleById(id);

			if (Oldarticle == null) {
				noArticle = true;
				model.addAttribute("noArticle", noArticle);
				// model.addAttribute("id", id);
				return "/usr/alert";
			}

			model.addAttribute("Oldarticle", Oldarticle);
			return "/usr/article/modify";

		} else {

			articleService.doModify(id, title, body);

			articleModified = true;
			model.addAttribute("articleModified", articleModified);
			return "/usr/alert";
		}
	}

	@RequestMapping("/usr/article/doDelete")
	public String doDelete(Model model, int id) {

		boolean noArticle = false;
		boolean articleDeleted = false;

		Article article = articleService.getArticleById(id);

		if (article == null) {
			noArticle = true;
			model.addAttribute("noArticle", noArticle);
			// model.addAttribute("id", id);
			return "/usr/alert";
		}

		articleService.doDelete(id);

		articleDeleted = true;
		model.addAttribute("articleDeleted", articleDeleted);
		return "/usr/alert";
	}

	@RequestMapping("usr/article/doWrite")
	public String doWrite(Model model, String title, String body) {

		boolean writeSuccess = false;

		if (title == null || body == null) {
			return "/usr/article/write";
		}

		int lastInsertedId = articleService.dowrite(title, body);

		Article article = articleService.getArticleById(lastInsertedId);

		writeSuccess = true;
		model.addAttribute("writeSuccess", writeSuccess);
		model.addAttribute("lastInsertedId", lastInsertedId);
		return "/usr/alert";
	}

	@RequestMapping("/usr/article/getArticles")
	public String getArticles(Model model, String boardId, String page, String searchItem,
			String searchKeyword) {

		// 페이지네이션
		int pageNum = 1;
		if (page != null) {
			pageNum = Integer.parseInt(page);
		}

		int itemsInPage = 10;
		int limitFrom = (pageNum - 1) * itemsInPage;
		int limitTake = itemsInPage;

		// 아티클 불러오기
		List<Article> articles = articleService.getArticles();

		// 아티클 존재 여부 검사
		if (articles.isEmpty()) { 
			model.addAttribute("noneArticle", true);
			return "/usr/article/list";
		}

		// 아티클이 있다면 페이지수도 구해서 넘어감...
		// 최대 페이지수 구하기
		int totalCount = articles.size();
		int maxPage = (int) Math.ceil(totalCount / (double) itemsInPage);

		// 실제로 표시될 페이지 가져오기
		List<Article> displayArticles = articleService.getArticlesByPage(limitFrom, limitTake);


		// 표시될 페이지 넘버들
		int startNum = 1;
		int endNum = pageNum + 9 <= maxPage ? 10 : maxPage;

		if (pageNum > 4 && maxPage > 10) {
			startNum = pageNum - 4;
			if (startNum + 9 <= maxPage) {
				endNum = startNum + 9;
			} else {
				endNum = maxPage;
			}
		}

		model.addAttribute("articles", displayArticles);
		model.addAttribute("noneArticle", false);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("startNum", startNum);
		model.addAttribute("endNum", endNum);
		return "/usr/article/list";
	}
}

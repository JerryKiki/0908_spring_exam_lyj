package com.example.lyj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lyj.repository.ArticleRepository;
import com.example.lyj.vo.Article;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	public int dowrite(String title, String body) {
		articleRepository.writeArticle(title, body);

		return articleRepository.getLastInsertId();
	}

	public int doDelete(int id) {
		return articleRepository.deleteArticle(id);
	}

	public int doModify(int id, String title, String body) {
		
		if(title.isEmpty()) {
			return articleRepository.modifyArticleBody(id, body);
		} else if(body.isEmpty()) {
			return articleRepository.modifyArticleTitle(id, body);
		} else {
			return articleRepository.modifyArticle(id, title, body);
		}
	}

	public Article getArticleById(int id) {
		return articleRepository.getArticleById(id);
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}
	
	public List<Article> getArticlesByPage(int limitFrom, int limitTake) {
		return articleRepository.getArticlesByPage(limitFrom, limitTake);
	}

}

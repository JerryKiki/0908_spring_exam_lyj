package com.example.lyj.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.lyj.vo.Article;

@Mapper
public interface ArticleRepository {
	
	@Insert("INSERT INTO article SET regDate = NOW(), updateDate = NOW(), title = #{title}, `body` = #{body}")
	public void writeArticle(String title, String body);

	@Delete("DELETE FROM article WHERE id = #{id}")
	public int deleteArticle(int id);

	@Update("UPDATE article SET updateDate = NOW(), title = #{title}, `body` = #{body} WHERE id = #{id}")
	public int modifyArticle(int id, String title, String body);
	
	@Update("UPDATE article SET updateDate = NOW(), `body` = #{body} WHERE id = #{id}")
	public int modifyArticleBody(int id, String body);

	@Update("UPDATE article SET updateDate = NOW(), title = #{title} WHERE id = #{id}")
	public int modifyArticleTitle(int id, String body);

	@Select("SELECT * FROM article WHERE id = #{id}")
	public Article getArticleById(int id);

	@Select("SELECT * FROM article ORDER BY id DESC")
	public List<Article> getArticles();

	@Select("SELECT LAST_INSERT_ID();")
	public int getLastInsertId();

	@Select("SELECT * FROM article ORDER BY id DESC LIMIT ${limitFrom}, ${limitTake}")
	public List<Article> getArticlesByPage(int limitFrom, int limitTake);

}
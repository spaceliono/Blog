package com.space.myblog.Mapper;

import com.space.myblog.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Delete("delete from articles where article_id=#{article_id}")
    public void delete(int article_id);

    @Select("select article_id,article_title,create_date from articles")
    public List<Article> findAll();

    @Select("select * from articles where article_id=#{article_id}")
    public Article get(int article_id);

    @Select("select article_id,article_title from articles where article_id>#{article_id}  order by article_id asc limit 1")
    public Article getnext(int article_id);

    @Select("select article_id,article_title from articles where article_id<#{article_id}  order by article_id desc limit 1")
    public Article getprev(int article_id);

    @Update("update articles set article_title=#{article_title}, markdown = #{markdown} where article_id = #{article_id}")
    public void updateArt(Article article);

    @Insert("insert into articles(article_title,create_date,markdown) VALUES(#{article_title},CURRENT_DATE,#{markdown})")
    @Options(useGeneratedKeys=true,keyProperty="article_id",keyColumn="article_id")
    public int InsertArt(Article article);
}

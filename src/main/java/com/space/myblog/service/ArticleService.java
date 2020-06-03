package com.space.myblog.service;

import com.space.myblog.Mapper.ArticleMapper;
import com.space.myblog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "Article")
@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Cacheable(key = "'rowall'")
    public List<Article> findAll(){
        return articleMapper.findAll();
    }
    @Cacheable(key = "#id")
    public Article get(int id){
        return articleMapper.get(id);
    }
    @CachePut(key = "#article.article_id")
    public Article updateArt(Article article){
        articleMapper.updateArt(article);
        return articleMapper.get(article.getArticle_id());
    }
    @CacheEvict(key = "'rowall'")
    public void delete(int id){
        articleMapper.delete(id);
    }
    @CacheEvict(key = "'rowall'")
    public int InsertArt(Article article){
        return articleMapper.InsertArt(article);
    }

}

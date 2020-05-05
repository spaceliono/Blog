package com.space.myblog.controller;

import com.space.myblog.Mapper.ArticleMapper;
import com.space.myblog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminCtrl {
    @Autowired
    ArticleMapper articleMapper;
    @RequestMapping("/admin")
    public String admin(ModelMap m) {
        List<Article> articles = articleMapper.findAll();
        m.addAttribute("articles",articles);
        return "admin/admin";
    }

    @RequestMapping("/admin/article_delete/{id}")
    @ResponseBody
    public String articleDelete(@PathVariable("id") int id) {
        articleMapper.delete(id);
        return "success";
    }
    @RequestMapping("/admin/editarticle/{id}")
    public String articleEdit(@PathVariable("id") int id,ModelMap m){
        Article article = articleMapper.get(id);
        m.addAttribute("article",article);
        return "admin/editarticle";
    }
    @RequestMapping("/admin/editarticle")
    public String articleAdd(){
        return "admin/editarticle";
    }
    @RequestMapping("/admin/saveArticle")
    @ResponseBody
    public String saveArticle(Article article){
        int Article_id;
        if ( article.getArticle_id() != 0){
            articleMapper.updateArt(article);
            return "/article/"+ article.getArticle_id();
        }else {
            Article_id = articleMapper.InsertArt(article);
            System.out.println(article.getArticle_id());
            return "/article/"+ article.getArticle_id();
        }
    }
    @GetMapping("/login")
    public String login() {

        return "login";
    }
    @RequestMapping("/403")
    public String toError403() {
        return "/403";
    }
}

package com.space.myblog.controller;

import com.space.myblog.Mapper.ArticleMapper;
import com.space.myblog.pojo.Article;
import com.space.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminCtrl {

    @Autowired
    ArticleService articleService;
    @RequestMapping("/admin")
    public String admin(ModelMap m) {
        List<Article> articles = articleService.findAll();
        m.addAttribute("articles",articles);
        return "admin/admin";
    }

    @RequestMapping("/admin/article_delete/{id}")
    @ResponseBody
    public String articleDelete(@PathVariable("id") int id) {
        articleService.delete(id);
        return "success";
    }
    @RequestMapping("/admin/editarticle/{id}")
    public String articleEdit(@PathVariable("id") int id,ModelMap m){
        Article article = articleService.get(id);
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
            articleService.updateArt(article);
            return "/article/"+ article.getArticle_id();
        }else {
            Article_id = articleService.InsertArt(article);
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

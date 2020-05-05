package com.space.myblog.controller;

import com.space.myblog.Mapper.ArticleMapper;
import com.space.myblog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainCtrl {

    @Autowired
    ArticleMapper articleMapper;
    @RequestMapping("/")
    public String index(ModelMap m) {
        List<Article> articles = articleMapper.findAll();
        m.addAttribute("articles",articles);
        return "home";
    }
    @RequestMapping("/article/{id}")
    public String edit(@PathVariable("id") int id, ModelMap m) {
        Article article = articleMapper.get(id);
        Article next =articleMapper.getnext(id);
        Article prev =articleMapper.getprev(id);
        m.addAttribute("article",article);
        m.addAttribute("next",next);
        m.addAttribute("prev",prev);
        return "article";
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
}

package com.space.myblog.controller;

import com.space.myblog.Mapper.ArticleMapper;
import com.space.myblog.pojo.Article;
import com.space.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainCtrl {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleService articleService;
    @RequestMapping("/")
    public String index(ModelMap m) {
        List<Article> articles = articleService.findAll();
        m.addAttribute("articles",articles);
        return "home";
    }
    @RequestMapping("/article/{id}")
    public String getArticle(@PathVariable("id") int id, ModelMap m, HttpServletRequest request) {
        Article article = articleService.get(id);
        if (article==null){
            request.setAttribute("javax.servlet.error.status_code",404);
            return "forword:/error";
        }else {
            Article next = articleMapper.getnext(id);
            Article prev = articleMapper.getprev(id);
            m.addAttribute("article", article);
            m.addAttribute("next", next);
            m.addAttribute("prev", prev);
            return "article";
        }
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }


}

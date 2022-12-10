package com.example.mvcProject.controller;

import com.example.mvcProject.dto.ArticleForm;
import com.example.mvcProject.entity.Article;
import com.example.mvcProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class ArticlesController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(Model model) {

        model.addAttribute("moveUrl","/bye");
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm) {
        log.info(articleForm.toString());

        Article article = articleForm.toEntity();
        log.info(article.toString());

        Article saved = articleRepository.save(article);
        String moveUrl = "/articles/" + saved.getId();
        log.info("ID : ",saved.getId());

        log.info(saved.toString());

        return moveUrl;
    }

    @GetMapping("/articles/{id}")
    public String inquiryArticle(@PathVariable Long id, Model model) {

        log.info("ID : ",id);

        Article articleEntity = articleRepository.findById(id).orElse(null);

        model.addAttribute("article",articleEntity);
        model.addAttribute("moveUrl","/articles/new");

        return "/articles/list";
    }
}

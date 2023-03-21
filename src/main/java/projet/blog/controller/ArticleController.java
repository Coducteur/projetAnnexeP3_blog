package projet.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projet.blog.entity.Article;
import projet.blog.repository.ArticleRepository;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles")
    public List<Article> getListOfAllArticles(){
        return articleRepository.findAll();
    }

    @GetMapping("/articles/{id}")
    public Article showArticle(@PathVariable int id){
        return articleRepository.findById(id).get();
    }

    @PostMapping("/articles")
    public Article createNewArticle(@RequestBody Article newArticle){
        return articleRepository.save(newArticle);
    }

    @PutMapping("/articles/{id}")
    public Article update(@PathVariable int id,@RequestBody Article article){
        Article articleToUpdate = articleRepository.findById(id).get();
        articleToUpdate.setTitle(article.getTitle());
        articleToUpdate.setContent(article.getContent());
        articleToUpdate.setSlug(article.getSlug());
        return articleRepository.save(articleToUpdate);
    }

    @DeleteMapping("/articles/{id}")
    public boolean delete(@PathVariable int id){
        articleRepository.deleteById(id);
        return true;
    }
}

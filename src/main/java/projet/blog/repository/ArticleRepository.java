package projet.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.blog.entity.Article;

import java.util.Map;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
 }

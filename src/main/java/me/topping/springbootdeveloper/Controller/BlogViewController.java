package me.topping.springbootdeveloper.Controller;

import lombok.RequiredArgsConstructor;
import me.topping.springbootdeveloper.DTO.ArticleListViewResponse;
import me.topping.springbootdeveloper.DTO.ArticleViewResponse;
import me.topping.springbootdeveloper.Service.BlogService;
import me.topping.springbootdeveloper.domain.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        // addAttribute() 메서드로 모델에 값 저장, articles 키에 블로그 글 리스트 저장
        model.addAttribute("articles", articles); // 블로그 글 리스트 저장

        return "articleList"; // articleList.html 뷰 조회
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) { // 인자 id에 URL로 넘어온 값을 받아

        Article article = blogService.findById(id); // findById() 메서드로 넘겨 글 조회
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article"; // 템플릿 이름 반환
    }
}

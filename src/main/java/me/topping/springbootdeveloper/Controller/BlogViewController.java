package me.topping.springbootdeveloper.Controller;

import lombok.RequiredArgsConstructor;
import me.topping.springbootdeveloper.DTO.ArticleListViewResponse;
import me.topping.springbootdeveloper.Service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}

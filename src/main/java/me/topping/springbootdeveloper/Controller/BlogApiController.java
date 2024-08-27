package me.topping.springbootdeveloper.Controller;

import lombok.RequiredArgsConstructor;
import me.topping.springbootdeveloper.DTO.AddArticleRequest;
import me.topping.springbootdeveloper.DTO.ArticleResponse;
import me.topping.springbootdeveloper.DTO.UpdateArticleRequest;
import me.topping.springbootdeveloper.Service.BlogService;
import me.topping.springbootdeveloper.domain.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiController {

    private final BlogService blogService;

    // Create
    @PostMapping("/api/articles") //  HTTP 메서드가 POST일 때 전달받은 URL과 동일하면 해당 메서드로 매핑
    // @RequestBody로 요청 본문 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        // 요청한 자원이 성공적으로 생성되었으며
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle); // 저장된 블로그 글 정보를 응답 객체에 담아 전송
    }

    // Read All
    @GetMapping("/api/articles") // GET 요청이 들어오면
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll() // 글 전체를 조회하는 findAll() 메서드를 호출해 응답용 객체 ArticleResponse로 파싱하고
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles); // body에 담아 클라이언트에게 전송
    }

    // Read One
    @GetMapping("/api/articles/{id}") // URL에서 {id}에 해당하는 값이 id로 들어옴
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    // Delete
    @DeleteMapping("/api/articles/{id}") // URL에서 {id}에 해당하는 값이 id로 들어옴
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok().build();
    }

    // Update
    @PutMapping("/api/articles/{id}") // URL에서 PUT요청이 들어오면
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) { // Request Body 정보가 reqeust로 넘어옴
        Article updatedArticle = blogService.update(id, request); // Service 클래스의 update() 메서드에 id와 request를 넘겨

        return ResponseEntity.ok().body(updatedArticle); // 응답 값을 body에 담아 전송
    }
}

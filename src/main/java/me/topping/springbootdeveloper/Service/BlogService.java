package me.topping.springbootdeveloper.Service;

import lombok.RequiredArgsConstructor;
import me.topping.springbootdeveloper.DTO.AddArticleRequest;
import me.topping.springbootdeveloper.Repository.BlogRepository;
import me.topping.springbootdeveloper.domain.Article;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final이나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) { // AddArticleRequest 클래스에 저장된 값들을 article DB에 저장
        return blogRepository.save(request.toEntity());
    }
}

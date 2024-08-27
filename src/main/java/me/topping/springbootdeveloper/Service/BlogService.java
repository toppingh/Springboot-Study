package me.topping.springbootdeveloper.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.topping.springbootdeveloper.DTO.AddArticleRequest;
import me.topping.springbootdeveloper.DTO.UpdateArticleRequest;
import me.topping.springbootdeveloper.Repository.BlogRepository;
import me.topping.springbootdeveloper.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) { // AddArticleRequest 클래스에 저장된 값들을 article DB에 저장
        return blogRepository.save(request.toEntity());
    }

    // 블로그 글 전체 조회 메서드
    public List<Article> findAll() { // article 테이블에 저장되어 있는 모든 데이터 조회
        return blogRepository.findAll();
    }

    // 블로그 글 하나 조회 메서드
    public Article findById(long id) {
        return blogRepository.findById(id) // Id를 받아 Entity 조회
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id)); // 없으면 IllegalArgumentException 예외 발생
    }

    // 블로그 글 삭제 메서드
    public void delete(long id) {
        blogRepository.deleteById(id); // id를 받아 데이터 삭제
    }

    // 블로그 글 수정 메서드
    @Transactional // 트랜잭션 메서드 : 매칭한 메서드를 하나의 트랜잭션(DB에서 데이터를 바꾸기 위한 작업 단위)으로 묶는 역할
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}

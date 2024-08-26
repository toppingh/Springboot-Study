package me.topping.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // title 이라는 not null 컬럼과 매핑
    private String title;

    @Column(name = "content", nullable = false) // content라는 not null 컬럼과 매핑
    private String content;

    @Builder // 빌더 패턴으로 객체 생성 : 어느 필드에 어떤 값이 들어가는지 명시적으로 파악 가능
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 빌더 패턴 사용 x시
//    new Article("abc", "def"); 어느 필드에 들어가는 값인지 파악하기 어려움!

//    Getter 애너테이션, NoArgsConstructor 애너테이션으로 대체
//    protected Article() {
//        // 기본 생성자
//    }

    // 게터
//    public Long getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getContent() {
//        return content;
//    }
}

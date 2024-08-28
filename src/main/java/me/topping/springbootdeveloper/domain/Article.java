package me.topping.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class) // Entity 생성 및 수정 시간 자동 감시, 기록
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

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Entity에 생성, 수정 시간 추가
    @CreatedDate // Entity가 생성될 때 생성 시간을
    @Column(name = "created_at") // created_at 컬럼에 저장
    private LocalDateTime createdAt;

    @LastModifiedDate // Entity가 수정될 때 수정 시간을
    @Column(name = "updated_at") // updated_at 컬럼에 저장
    private LocalDateTime updatedAt;

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

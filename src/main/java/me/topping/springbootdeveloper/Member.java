package me.topping.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자
@AllArgsConstructor
@Getter
@Entity // Entity로 지정
public class Member {

    @Id //  id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue : 기본키 생성 방식 -> 자동으로 1씩 증가하도록
    // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id; // DB 테이블의 id 컬럼과 매칭

    @Column(name = "name", nullable = false) // name이라는 not null 컬럼과 매핑
    private String name; // DB 테이블의 name 컬럼과 매칭

    public void changeName(String name) {
        this.name = name;
    }
}

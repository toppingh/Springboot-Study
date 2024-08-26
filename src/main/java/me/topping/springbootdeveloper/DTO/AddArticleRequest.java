// DTO : 단순히 데이터를 옮기는 전달자 역할을 하는 객체로 별도의 비즈니스 로직을 포함하지 않음
// DAO : DB와 연결되고 데이터를 조회, 수정하는데 사용하는 객체 => 데이터 수정과 관련된 로직 포함

package me.topping.springbootdeveloper.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.topping.springbootdeveloper.domain.Article;

@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {

    private String title;

    private String content;

    public Article toEntity() { // 빌더 패턴을 사용해 DTO를 Entity로 만들어주는 메서드 -> 추후에 블로그 글을 추가할 때 저장할 Entity로 변환하는 용도로 사용함
        // 생성자로 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}

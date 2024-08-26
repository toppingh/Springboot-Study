package me.topping.springbootdeveloper;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// 컨트롤러를 테스트할 때 사용되는 클래스로 요청 및 전송, 응답 기능 제공하는 유틸리티 클래스
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc; // MockMvc는 애플리케이션을 서버에 배포하지 않고 테스트용 MVC 환경을 만드는 기능 제공
import org.springframework.boot.test.context.SpringBootTest; // @SpringBootApplication이 있는 클래스를 찾고 그 클래스에 포함되어있는 빈을 찾아 테스트용 애플리케이션에 컨텍스트를 만듦
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // 테스트용 애플리케이션 컨텍스트 생성
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class TestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach // 테스트 실행 전 실행하는 메서드
    public void mockMvcSetup() { // MockMvcSetUp() 메서드를 실행해 MockMvc 설정
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach // 테스트 실행 후 실행하는 메서드
    public void cleanUp() { // cleanUp() 메서드를 실행해 member 테이블에 있는 데이터들을 모두 삭제함
        memberRepository.deleteAll();
    }

    @DisplayName("getAllMembers : 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception {
        // given : 멤버 저장
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));

        // when : 멤버 리스트를 조회하는 API 호출
        final ResultActions result = mockMvc.perform(get(url) // perform() : 요청을 전송하는 역할, 결과로 ResultActions객체를 받아 이 객체는 반환값 검증, 확인하는 andExpect() 메서드 제공
                .accept(MediaType.APPLICATION_JSON)); // accept() : 요청을 보낼 때 무슨 타입으로 응답을 받을지 결정. 여기서는 JSON 이용

        // then : 응답 코드가 200이고 반환값 중 0번째 요소의 id와 name이 저장된 값과 같은지 확인
        result.andExpect(status().isOk()) // andExpect() : 응답 검증. TestController에서 만든 API는 응답으로 Ok(200)을 반환하므로 해당하는 메서드 isOk로 응답코드가 Ok(200)인지 확인
                // jsonPath("$[0].${필드명}") : JSON 응답값의 값을 가져오는 역할. 0번째 배열에 들어있는 객체의 id, name값을 가져오고, 저장된 값과 같은지 확인
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}
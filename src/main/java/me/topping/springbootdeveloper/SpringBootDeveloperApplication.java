package me.topping.springbootdeveloper;

// main() 메서드와 같은 역할을 하는 클래스 => 여기서 스프링 부트 시작
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 어노테이션 추가 시 스프링 부트 사용에 필요한 기본 설정을 해준다.
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        // SpringApplication.run() : 애플리케이션 실행 첫 번째 인수 : 메인 클래스로 사용할 클래스, 두 번째 인수 : 커맨드 라인의 인수들 전달
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}

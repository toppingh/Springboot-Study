package me.topping.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Router 역할 어노테이션, (HTTP 요청과 메서드를 연결하는 장치)
public class TestController {
//    @GetMapping("/test") // GET 요청이 오면 test() 메서드 실행
//    public String test() {
//        return "Hello World";
//    }

    @Autowired // TestService 빈 주입
    TestService testService;

    @GetMapping("/test")
    public List<Member> getAllMembers() {
        List<Member> members = testService.getAllMembers();
        return members;
    }
}

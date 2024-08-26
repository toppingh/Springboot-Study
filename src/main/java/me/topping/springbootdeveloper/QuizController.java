package me.topping.springbootdeveloper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {

    @GetMapping("/quiz") // 1. quiz 패스로 GET요청이 오면 quiz() 메서드 요청 처리
    public ResponseEntity<String> quiz(@RequestParam("code") int code) { // 요청 파라미터의 키가 "code"이면 int 자료형의 code 변수와 매핑
        switch (code) { // code 값에 따라 다른 응답을 보냄
            case 1: // 응답 코드가 201이면 Created!
                return ResponseEntity.created(null).body("Created!");
            case 2: // 응답 코드가 400이면 Bad Request!
                return ResponseEntity.badRequest().body("Bad Request!");
            default: // 그 외일 경우 200, OK!
                return ResponseEntity.ok().body("OK!");
        }
    }

    @PostMapping("/quiz") // 2. quiz 패스로 POST 요청이 오면 quiz2() 메서드 요청 처리
    public ResponseEntity<String> quiz2(@RequestBody Code code) { // 요청 값을 Code라는 객체로 매핑한 후
        switch (code.value()) { // value 값에 따라 다른 응답 보냄
            case 1: // 응답코드가 403이면 Forbidden!
                return ResponseEntity.status(403).body("Forbidden!");
            default: // 그외이면 200, OK!
                return ResponseEntity.ok().body("OK!");
        }
    }
}

record Code(int value) {} // 3. POST 요청시 매핑할 객체로 사용하기 위해 선언한 레코드.
// 데이터 전달을 목적으로 하는 객체를 더 빠르고 간편하게 만들기 위한 기능으로, 레코드를 사용하면 필드, 생성자, 게터, equals(), hashCode(), toString() 메서드 등을 자동으로 생성함

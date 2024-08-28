package me.topping.springbootdeveloper.Controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller // 컨트롤러라는 것을 명시적으로 표시
public class ExampleController {

    @GetMapping("/thymeleaf/example")
    public String tymeleafExample (Model model) { // model : 뷰, HTML 쪽으로 값을 넘겨주는 객체
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("황고명");
        examplePerson.setAge(5);
        examplePerson.setHobbies(List.of("산책", "간식 먹기"));

        model.addAttribute("person", examplePerson); // Person 객체 저장
        model.addAttribute("today", LocalDate.now());

        return "example"; // example.html라는 뷰 조회
    }

    @Setter
    @Getter
    class Person {
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}

package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");

        return "hello";
    }

    @GetMapping("/hello-mvc")
    // get 방식의 요청 파라미터를 String name 에 저장 후 사용할 수 있음
    public String helloMvc(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // api 방식으로 데이터 전송 (객체를 반환하면 json 데이터 포맷으로 변환시켜서 화면에 출력해준다.)
    @GetMapping("/hello-string")
    @ResponseBody // http body 부분에 return 값을 바로 넣어주겠다는 뜻
    public String helloString(@RequestParam String name) {
        return "hello " + name;
    }

    @GetMapping("/hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam String name, @RequestParam String age) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setAge(age);
        return hello;
    }

    static class Hello {
        private String name;
        private String age;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

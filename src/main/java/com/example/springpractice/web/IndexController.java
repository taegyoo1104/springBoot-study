package com.example.springpractice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//페이지와 관련된 컨트롤러는 모두 IndexController
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";                //    --> src/main/resources/templates/index.mustache로 View Resolver가 처리
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}

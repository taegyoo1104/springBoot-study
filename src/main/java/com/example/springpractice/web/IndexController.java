package com.example.springpractice.web;

import com.example.springpractice.config.auth.dto.SessionUser;
import com.example.springpractice.service.PostsService;
import com.example.springpractice.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

//페이지와 관련된 컨트롤러는 모두 IndexController
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpService;

    @GetMapping("/")
    public String index(Model model) {       //서버 템플릿 엔진에서 사용할 수 있는 객체를 저장한다.
        model.addAttribute("posts", postsService.findAllDesc());

        SessionUser user = (SessionUser)httpService.getAttribute("user");
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";                //    --> src/main/resources/templates/index.mustache로 View Resolver가 처리
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}

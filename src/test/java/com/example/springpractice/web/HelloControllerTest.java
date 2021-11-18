package com.example.springpractice.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //스프링 부트 테스트와 junit 사이의 연결
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired //빈 주입
    private MockMvc mvc; //웹 api를 테스트할 때 사용

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))               //MockMvc를 통해 /hello주소로 HTTP GET요청
                .andExpect(status().isOk())                //결과 검증 --> OK 즉, 200인지 아닌지
                .andExpect(content().string(hello));       //결과 검증 --> "hello"가 맞는지
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))  //param --> API테스트 할 때 사용될 요청 파라미터 설정
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));       //jsonPath --> JSON응답값을 필드별로 검증할 수 있는 메소드
    }
}

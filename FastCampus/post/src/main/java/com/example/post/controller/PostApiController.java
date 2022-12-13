package com.example.post.controller;

import com.example.post.dto.PostRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody PostRequestDTO requestData){
        System.out.println(requestData);
    }
}

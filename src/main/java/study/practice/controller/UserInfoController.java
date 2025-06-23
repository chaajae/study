package study.practice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.practice.service.UserInfoService;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserInfoController {
    private final UserInfoService userInfoService;

    @PostMapping("/get")
    public void getUserInfoList(){
        System.out.println(userInfoService.getUserInfoList());;
    }

    @PostMapping("/set")
    public void setUserInfoList(){
        userInfoService.setUserInfoList();
    }
}

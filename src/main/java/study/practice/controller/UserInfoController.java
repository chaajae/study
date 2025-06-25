package study.practice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.practice.domain.UserInfoEntity;
import study.practice.domain.repo.dto.Response;
import study.practice.service.UserInfoService;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserInfoController {
    private final UserInfoService userInfoService;

    @PostMapping("/get")
    public void printUserInfo(){
        System.out.println(userInfoService.getUserInfoList());
    }

    @PostMapping("/set")
    public void setUserInfoList(@RequestBody List<UserInfoEntity> param){
        userInfoService.setUserInfoList(param);
    }

    @PostMapping("/list")
    public Response getUserInfoList(){
        Response response = new Response();
        response.setData(Map.of("datas",userInfoService.getUserInfoList()));
        return response;
    }
}

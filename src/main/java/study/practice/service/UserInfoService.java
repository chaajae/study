package study.practice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.practice.domain.UserInfoEntity;
import study.practice.domain.repo.UserInfoRepo;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepo userInfoRepo;

    public List<UserInfoEntity> getUserInfoList() {
        return userInfoRepo.findAll();
    }

    public void setUserInfoList(List<UserInfoEntity> param) {
        userInfoRepo.saveAll(param);
    }

}

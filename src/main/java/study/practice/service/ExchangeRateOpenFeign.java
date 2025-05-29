package study.practice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import study.practice.domain.Response;

import java.util.Map;

@FeignClient(name = "ExchangeRateOpenFeign" , url = "localhost:30001/api/v1")
public interface ExchangeRateOpenFeign {
    @PostMapping("/common/test/{uid}")
    Response put(@RequestHeader String authorization, @PathVariable("uid") String uid, @RequestBody Map<String,Object> param);
}

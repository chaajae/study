package study.practice.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.practice.domain.repo.dto.DmsDto;
import study.practice.domain.repo.dto.Response;
import study.practice.etc.function.Functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class DummyService {

    private Integer count = 0;

    public Response openFeignTest(String token, String uid){
        Map<String,Object> param = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            param.put("data" + count , "데이터" + count++);
        }
        return new Response();
    }

    public void convert(){
        Gson gson = new Gson();

        try {

            DmsDto dto = new DmsDto();
            List<DmsDto.Role> roles = new ArrayList<>();
            roles.add(DmsDto.Role.builder().roleName("System Admin").roleId("11").build());
            roles.add(DmsDto.Role.builder().roleName("System Admin2").roleId("22").build());

            dto.setRoles(roles);

            String json = gson.toJson(dto.getRoles());
            List<Map<String,Object>> list = Functions.typeConvert(json, List.class);
            DmsDto.Role role2 = null;
            for (Map<String, Object> role : list) {
                if("System Admin".equals(role.get("roleName"))){
                    role2 = Functions.typeConvert(role, DmsDto.Role.class);
                }
            }
            System.out.println(role2);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}

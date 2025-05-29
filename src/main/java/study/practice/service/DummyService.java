package study.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import study.practice.domain.ActionCard;
import study.practice.domain.Response;
import study.practice.domain.repo.ActionCardRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DummyService {

    private final ActionCardRepo actionCardRepo;
    private final ExchangeRateOpenFeign exchangeRateOpenFeign;
    private Integer count = 0;
    @Transactional
    public Integer test() {

        Integer num = 1209;
        try {
            List<ActionCard> list = new ArrayList<>();
            ActionCard card = new ActionCard();
            card.setAction_no("no");
            list.add(card);
            actionCardRepo.saveAll(list);

            for (int i = 0; i < 5; i++) {
                System.out.println(list.get(i));
            }

            num = 1201;
        }catch (Exception e){
            System.out.println(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }

    public Response openFeignTest(String token, String uid){
        Map<String,Object> param = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            param.put("data" + count , "데이터" + count++);
        }
        return exchangeRateOpenFeign.put(token,uid,param);
    }
}

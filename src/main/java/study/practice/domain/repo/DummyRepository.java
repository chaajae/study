package study.practice.domain.repo;

import org.springframework.stereotype.Component;
import study.practice.domain.repo.dto.Dummy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DummyRepository {

    private List<Dummy> datas = new ArrayList<>();
    private Integer idx = 1;

    public void set() throws Exception {
        try {
            for (int i = 1; i <= 1000000; i++) {
                String data = String.format("%d / %d / %d", idx, idx, idx);
                Dummy dummy = Dummy.builder()
                        .name("name/" + idx)
                        .idx(data)
                        .data(Map.of("data", idx++)).build();
                datas.add(dummy);
                //System.out.println(dummy);
            }
            System.out.println("INDEX : " + idx);
            System.out.println("Done!");
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }catch (Exception e){
            throw new Exception();
        }
    }

    public void get(){
        try {
            System.out.println(datas);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void just() {
        System.out.println("돌고있나?");
    }


}

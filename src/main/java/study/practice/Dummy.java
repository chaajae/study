package study.practice;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class Dummy {
    private String name;
    private String idx;
    private Map<String,Object> data;

    @Builder
    public Dummy(String name, String idx, Map<String, Object> data) {
        this.name = name;
        this.idx = idx;
        this.data = data;
    }
}

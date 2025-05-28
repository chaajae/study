package study.practice.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Response {

    private Map<String, Object> data;
}

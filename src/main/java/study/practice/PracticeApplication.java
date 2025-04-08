package study.practice;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import study.practice.controller.RunController;
import study.practice.designPattern.strategy.Card;

import java.util.Collections;

@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        //SpringApplication.run(PracticeApplication.class, args);
        new RunController().runDynamicFactory();
    }

}

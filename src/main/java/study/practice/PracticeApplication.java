package study.practice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import study.practice.controller.RunController;

@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        //SpringApplication.run(PracticeApplication.class, args);
        new RunController().runInheritance();
    }

}

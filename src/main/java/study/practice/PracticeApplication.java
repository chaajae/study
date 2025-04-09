package study.practice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import study.practice.algorithm.Algorithm;

@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        //SpringApplication.run(PracticeApplication.class, args);
        //new RunController().runAlgorithm();
        Algorithm.HASHTABLE.run();
    }

}

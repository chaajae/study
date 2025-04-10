package study.practice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import study.practice.algorithm.ProblemRunner;

@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        //SpringApplication.run(PracticeApplication.class, args);
        //new RunController().runGrade();
        ProblemRunner.BAEKJOON_2667.run();
        // Algorithm.BFS.run();

    }

}

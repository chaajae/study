package study.practice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import study.practice.dataStructure.trie.Trie;

@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        //SpringApplication.run(PracticeApplication.class, args);
        //new RunController().runGrade();
        ProblemRunner.BAEKJOON_5052.run();
        // Algorithm.BFS.run();
        //foo();
    }

    public static void foo(){
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("april");
        trie.insert("bus");
        trie.insert("busy");
        trie.insert("beer");
        trie.insert("best");

        System.out.println("찾았나 ? : " + trie.search("cursor"));


    }

}

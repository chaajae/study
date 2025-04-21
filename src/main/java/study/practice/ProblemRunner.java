package study.practice;

import study.practice.algorithm.search.problem.Baekjoon1260;
import study.practice.algorithm.search.problem.Baekjoon2606;
import study.practice.algorithm.search.problem.Baekjoon2667;
import study.practice.dataStructure.trie.problem.Baekjoon5052;

public enum ProblemRunner {
    BAEKJOON_2606{
        @Override
        void test() {
            Baekjoon2606.run();
        }
    },

    BAEKJOON_1260{
        @Override
        void test() {
            Baekjoon1260.run();
        }
    },

    BAEKJOON_2667{
        @Override
        void test() {
            Baekjoon2667.run();
        }
    },

    BAEKJOON_5052{
        @Override
        void test() {
            Baekjoon5052.run();
        }
    };

    public void run(){
        test();
    }

    abstract void test();
}

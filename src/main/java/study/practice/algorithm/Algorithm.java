package study.practice.algorithm;

import study.practice.algorithm.search.BinarySearch;
import study.practice.algorithm.search.BreadthFirstSearch;
import study.practice.algorithm.search.DepthFirstSearch;
import study.practice.algorithm.search.HashTable;
import study.practice.algorithm.sort.*;

public enum Algorithm {
    BUBBLE_SORT{
        @Override
        public void implement(){
            BubbleSort.run();
        }
    },

    SELECTION_SORT{
        @Override
        void implement() {
            SelectionSort.run();
        }
    },

    INSERTION_SORT{
        @Override
        void implement() {
            InsertionSort.run();
        }
    },

    QUICK_SORT{
        @Override
        void implement() {
            QuickSort.run();
        }
    },

    MERGE_SORT{
        @Override
        void implement() {
            MergeSort.run();
        }
    },

    HEAP_SORT{
        @Override
        void implement() {
            HeapSort.run();
        }
    },

    RADIX_SORT{
        @Override
        void implement() {
            RadixSort.run();
        }
    },

    COUNTING_SORT{
        @Override
        void implement() {
            CountingSort.run();
        }
    },

    BINARY_SEARCH{
        @Override
        void implement() {
            BinarySearch.run();
        }
    },

    HASHTABLE{
        @Override
        void implement() {
            HashTable.run();
        }
    },

    DFS{
        @Override
        void implement() {
            DepthFirstSearch.run();
        }
    },

    BFS{
        @Override
        void implement() {
            BreadthFirstSearch.run();
        }
    };


    public void run(){
        long start = System.currentTimeMillis();
        implement();
        long end = System.currentTimeMillis();
        System.out.printf("TIME : %s 초" , ((double) end - (double) start) / 1000 );
    }

    abstract void implement();
}

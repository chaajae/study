package study.practice.algorithm;

import study.practice.algorithm.sort.*;

public enum Algorithm {
    BUBBLE_SORT{
        @Override
        public void implement(){
            BubbleSort.sort();
        }
    },

    SELECTION_SORT{
        @Override
        void implement() {
            SelectionSort.sort();
        }
    },

    INSERTION_SORT{
        @Override
        void implement() {
            InsertionSort.sort();
        }
    },

    QUICK_SORT{
        @Override
        void implement() {
            QuickSort.sort();
        }
    },

    MERGE_SORT{
        @Override
        void implement() {
            MergeSort.sort();
        }
    },

    HEAP_SORT{
        @Override
        void implement() {
            HeapSort.sort();
        }
    },

    RADIX_SORT{
        @Override
        void implement() {
            RadixSort.sort();
        }
    },

    COUNTING_SORT{
        @Override
        void implement() {
            CountingSort.sort();
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
    };


    public void run(){
        long start = System.currentTimeMillis();
        implement();
        long end = System.currentTimeMillis();
        System.out.printf("TIME : %s 초" , ((double) end - (double) start) / 1000 );
    }

    abstract void implement();
}

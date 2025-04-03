package study.practice.designPattern.adaptor;

public class SortingMachine {
    ISortEngine engine;

    public void setEngine(ISortEngine engine){
        this.engine = engine;
    }

    public void sortingRun(){
        engine.setList();
        engine.sort();
        engine.printSortListPretty();
        engine.reverseSort();
        engine.printSortListPretty();
    }
}

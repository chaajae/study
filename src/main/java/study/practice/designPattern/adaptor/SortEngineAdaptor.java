package study.practice.designPattern.adaptor;

public class SortEngineAdaptor implements ISortEngine{

    private A_SortEngine a_engine;
    private B_SortEngine b_engine;

    public SortEngineAdaptor(A_SortEngine a_engine, B_SortEngine b_engine) {
        this.a_engine = a_engine;
        this.b_engine = b_engine;
    }

    @Override
    public void setList() {
        b_engine.setList();
    }

    @Override
    public void sort() {
        b_engine.sorting(false);
    }

    @Override
    public void reverseSort() {
        b_engine.sorting(true);
    }

    @Override
    public void printSortListPretty() {
        a_engine.printSortListPretty();
    }
}

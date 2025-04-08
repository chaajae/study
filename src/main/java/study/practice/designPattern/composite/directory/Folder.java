package study.practice.designPattern.composite.directory;

import java.util.ArrayList;

public class Folder implements Node{
    private String name;
    private ArrayList<Node> list;

    public Folder(String name) {
        this.name = name;
        list = new ArrayList<>();
    }

    public void add(Node node){
        list.add(node);
    }

    @Override
    public void print() {
        this.print("");
    }

    @Override
    public void print(String str) {
        int size = getSize();
        System.out.println(str + "\uD83D\uDCC2" + name + " (" + size + "kb)");

        for (Node node : list) {
            node.print(str + "    ");
        }
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (Node node : list) {
            sum += node.getSize();
        }
        return sum;
    }
}

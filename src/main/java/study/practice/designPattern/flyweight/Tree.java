package study.practice.designPattern.flyweight;

public class Tree {
    public long objSize = 10;
    public double position_x;
    public double position_y;

    public TreeModel model;

    public Tree(TreeModel model, double position_x, double position_y) {
        this.model = model;
        this.position_x = position_x;
        this.position_y = position_y;

        Memory.size += this.objSize;
    }
}

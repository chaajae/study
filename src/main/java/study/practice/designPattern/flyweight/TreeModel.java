package study.practice.designPattern.flyweight;

public final class TreeModel {
    public long objSize = 90;
    public String type;
    public Object mesh;
    public Object texture;

    public TreeModel(String type, Object mesh, Object texture) {
        this.type = type;
        this.mesh = mesh;
        this.texture = texture;
        Memory.size += this.objSize;
    }
}

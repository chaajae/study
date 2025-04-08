package study.practice.designPattern.composite.directory;

public class File implements Node{
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void print() {
        this.print("");
    }

    @Override
    public void print(String str) {
        System.out.println(str + "\uD83D\uDCDC" + name + " (" + size + "kb)");
    }

    @Override
    public int getSize() {
        return size;
    }
}

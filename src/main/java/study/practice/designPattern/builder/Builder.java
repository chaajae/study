package study.practice.designPattern.builder;


public abstract class Builder {
    protected Datas datas;

    public Builder(Datas datas) {
        this.datas = datas;
    }

    public abstract String head();
    public abstract String body();
    public abstract String foot();
}


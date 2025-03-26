package study.practice.designPattern.builder;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public String build(){
        return new StringBuilder()
                    .append(builder.head())
                    .append(builder.body())
                    .append(builder.foot())
                    .toString();
    }
}

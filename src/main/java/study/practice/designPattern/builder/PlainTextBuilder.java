package study.practice.designPattern.builder;

public class PlainTextBuilder extends Builder{
    public PlainTextBuilder(Datas datas) {
        super(datas);
    }

    @Override
    public String head() {
        return "";
    }

    @Override
    public String body() {
        return new StringBuilder()
                .append("Name : ")
                .append(datas.getName())
                .append(", Address : ")
                .append(datas.getAddress())
                .toString();
    }

    @Override
    public String foot() {
        return "\n";
    }
}

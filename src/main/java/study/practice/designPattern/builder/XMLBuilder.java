package study.practice.designPattern.builder;

public class XMLBuilder extends Builder{
    public XMLBuilder(Datas datas) {
        super(datas);
    }

    @Override
    public String head() {
        return new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n")
                .append("<DATA>\n")
                .toString();
    }

    @Override
    public String body() {
        return new StringBuilder()
                .append("\t<NAME>")
                .append(datas.getName())
                .append("<NAME>")
                .append("\n\t<ADDRESS>")
                .append(datas.getAddress())
                .append("<ADDRESS>")
                .toString();

    }

    @Override
    public String foot() {
        return "\n</DATA>\n";
    }
}

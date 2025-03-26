package study.practice.designPattern.builder;

public class JSONBuilder extends Builder{

    public JSONBuilder(Datas datas) {
        super(datas);
    }

    @Override
    public String head() {
        return "{\n";
    }

    @Override
    public String body() {
        return new StringBuilder()
                .append("\t\"Name\" : ")
                .append("\"" + datas.getName() + "\",\n")
                .append("\t\"Address\" : ")
                .append("\"" + datas.getAddress() + "\"")
                .toString();
    }

    @Override
    public String foot() {
        return "\n}\n";
    }
}

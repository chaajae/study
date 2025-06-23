package study.practice.enums;

public enum FeeType implements EnumMapperType{
    PERCENT("정율제"),
    MONEY("정액제");

    private String title;

    FeeType(String title) {
        this.title = title;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }
}

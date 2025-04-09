package study.practice.designPattern.staticFactoryMethod;

public class Book {
    private String title;

    private Book(String title){
        this.title = title;
    }

    public static Book titleOf(String title){
        return new Book(title);
    }
}

package study.practice.designPattern.iterator.board;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class Post {
    public String title;
    public LocalDate date;

    @Builder
    public Post(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }
}

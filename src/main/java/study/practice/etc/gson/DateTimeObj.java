package study.practice.etc.gson;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DateTimeObj {
    public String title;
    public LocalDate date;
    public LocalDateTime time;

    @Builder
    public DateTimeObj(String title, LocalDate date, LocalDateTime time) {
        this.title = title;
        this.date = date;
        this.time = time;
    }
}

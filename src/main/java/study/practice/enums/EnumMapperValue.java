package study.practice.enums;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnumMapperValue {
    private String code;
    private String title;

    public EnumMapperValue(EnumMapperType type) {
        this.code = type.getCode();
        this.title = type.getTitle();
    }
}

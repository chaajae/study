package study.practice.designPattern.staticFactoryMethod.grade;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(staticName = "of")
@ToString
public class MemberGrade {
    private Long id;
    private String name;
}

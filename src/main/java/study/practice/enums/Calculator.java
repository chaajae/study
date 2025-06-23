package study.practice.enums;

import java.util.function.Function;

public enum Calculator {
    CAL_A(v -> v),
    CAL_B(v -> v * 10),
    CAL_C(v -> v * 3);

    private Function<Long, Long> expression;

    Calculator(Function<Long, Long> expression) {
        this.expression = expression;
    }

    public long calculate(long value){
        return expression.apply(value);
    }
}

package study.practice.controller;

import study.practice.designPattern.builder.Datas;
import study.practice.designPattern.builder.Director;
import study.practice.designPattern.builder.JSONBuilder;
import study.practice.designPattern.inheritance.Child;
import study.practice.designPattern.strategy.*;
import study.practice.designPattern.builder.*;
import study.practice.designPattern.templateMethod.MultiplyFileProcessor;
import study.practice.designPattern.templateMethod.PlusFileProcessor;

import java.util.Arrays;

public class RunController {

    public void runBuilderPattern(){
        Datas datas = new Datas("홍길동", "영등포");

        Builder plain = new PlainTextBuilder(datas);
        Builder json = new JSONBuilder(datas);
        Builder xml = new XMLBuilder(datas);

        String plainValue = new Director(plain).build();
        String jsonValue = new Director(json).build();
        String xmlValue = new Director(xml).build();

        System.out.println(plainValue);
        System.out.println(jsonValue);
        System.out.println(xmlValue);
    }

    public void runStrategyPattern(){
        Cafe americano = Cafe.builder()
                .menu(new Americano("콜드브루", "아이스"))
                .payments(new Card("현대카드", "일시불"))
                .build();

        Cafe latte = Cafe.builder()
                .menu(new Latte("핸드 드립", "뜨거운"))
                .payments(new Cash())
                .build();

        Cafe mileTea = Cafe.builder()
                .menu(new MilkTea("아이스"))
                .payments(new Crypto("업비트"))
                .build();

        americano.order(); // 주문하신 콜드브루 아이스 아메리카노 나왔습니다.
        // 현대카드로 일시불 결제가 완료되었습니다.

        latte.order();     // 주문하신 핸드 드립 뜨거운 라떼 나왔습니다.
        // 현금 결제가 완료되었습니다.

        mileTea.order();   // 주문하신 아이스 밀크티 나왔습니다.
        // 업비트 거래소에서 암호화페 결제가 완료되었습니다.
    }

    public void runTemplateMethodPattern(){
        String path = "calculate.txt";
        System.out.println("PATH : " + path);
        PlusFileProcessor plusProcessor = new PlusFileProcessor(path);
        System.out.println("PLUS RESULT : " + plusProcessor.process());

        MultiplyFileProcessor multiplyProcessor = new MultiplyFileProcessor(path);
        System.out.println("MULTIPLY RESULT : " + multiplyProcessor.process());
    }

    public void runInheritance() {
        Child child = new Child();
        child.addAll(Arrays.asList("가","나","다","라","마"));
        child.add("바");
        System.out.println(child.getCount());
    }


}

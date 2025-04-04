package study.practice.controller;

import study.practice.designPattern.adaptor.*;
import study.practice.designPattern.builder.*;
import study.practice.designPattern.decorator.practical.*;
import study.practice.designPattern.decorator.weapon.*;
import study.practice.designPattern.inheritance.*;
import study.practice.designPattern.iterator.ConcreteAggregate;
import study.practice.designPattern.iterator.Iterator;
import study.practice.designPattern.iterator.board.Board;
import study.practice.designPattern.iterator.board.Post;
import study.practice.designPattern.observer.*;
import study.practice.designPattern.observer.weather.*;
import study.practice.designPattern.proxy.*;
import study.practice.designPattern.proxy.ISubject;
import study.practice.designPattern.proxy.Protection.ProtectionProxy;
import study.practice.designPattern.proxy.Protection.implement.*;
import study.practice.designPattern.proxy.dynamic.*;
import study.practice.designPattern.proxy.logging.LoggingProxy;
import study.practice.designPattern.proxy.normal.NormalProxy;
import study.practice.designPattern.proxy.virtual.implement.*;
import study.practice.designPattern.proxy.virtual.VirtualProxy;
import study.practice.designPattern.strategy.*;
import study.practice.designPattern.templateMethod.*;
import study.practice.etc.gson.DateTimeObj;
import study.practice.etc.function.Functions;

import java.lang.reflect.Proxy;
import java.time.LocalDate;
import java.util.*;

public class RunController {

    public void runBuilderPattern(){
        Datas datas = new Datas("홍길동", "영등포");

        Builder plainText = new PlainTextBuilder(datas);
        Builder json = new JSONBuilder(datas);
        Builder xml = new XMLBuilder(datas);

        String plainTextValue = new Director(plainText).build();
        String jsonValue = new Director(json).build();
        String xmlValue = new Director(xml).build();

        System.out.println(plainTextValue);
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

        Cafe milkTea = Cafe.builder()
                .menu(new MilkTea("아이스"))
                .payments(new Crypto("업비트"))
                .build();

        americano.order(); // 주문하신 콜드브루 아이스 아메리카노 나왔습니다.
        // 현대카드로 일시불 결제가 완료되었습니다.

        latte.order();     // 주문하신 핸드 드립 뜨거운 라떼 나왔습니다.
        // 현금 결제가 완료되었습니다.

        milkTea.order();   // 주문하신 아이스 밀크티 나왔습니다.
        // 업비트 거래소에서 암호화페 결제가 완료되었습니다.
    }

    public void runTemplateMethodPattern(){
        String path = "calculate.txt";
        System.out.println("PATH : " + path);
        FileProcessor plusProcessor = new PlusFileProcessor(path);
        System.out.println("PLUS RESULT : " + plusProcessor.process());

        FileProcessor multiplyProcessor = new MultiplyFileProcessor(path);
        System.out.println("MULTIPLY RESULT : " + multiplyProcessor.process());
    }

    public void runInheritance() {
        Parent p = new Child();
        p.add("A");
        System.out.println(p.getCount());
    }

    public void runNormalProxy(){
        ISubject sub = new NormalProxy(new RealSubject());
        sub.action();
    }

    public void runVirtualProxy(){
        ISubject sub = new VirtualProxy();
        sub.action();
    }

    public void runProtectionProxy() {
        ISubject sub = new ProtectionProxy(new RealSubject(), true);
        sub.action();
    }

    public void runLoggingProxy() {
        ISubject sub = new LoggingProxy(new RealSubject());
        sub.action();
    }

    public void runLoadImage() {
        HighResolutionImage image1 = new HighResolutionImage("./img/고해상도 이미지1");
        HighResolutionImage image2 = new HighResolutionImage("./img/고해상도 이미지2");
        HighResolutionImage image3 = new HighResolutionImage("./img/고해상도 이미지3");
        image2.showImage();
    }

    public void runLoadImageByVirtualProxy() {
        IImage imageProxy1 = new ImageProxy("./img/고해상도 이미지1");
        IImage imageProxy2 = new ImageProxy("./img/고해상도 이미지2");
        IImage imageProxy3 = new ImageProxy("./img/고해상도 이미지3");
        imageProxy2.showImage();
    }

    public void runPrintEmployees() {
        Employee CTO = new Employee("Dragon Jung", RESPONSIBILITY.DIRECTOR);
        Employee devManager = new Employee("Cats Chang", RESPONSIBILITY.MANAGER);
        Employee financeManager = new Employee("Dell Choi", RESPONSIBILITY.MANAGER);
        Employee devStaff = new Employee("Dark Kim", RESPONSIBILITY.STAFF);
        Employee financeStaff = new Employee("Pal Yoo", RESPONSIBILITY.STAFF);

        List<Employee> employees = Arrays.asList(CTO, devManager, financeManager, devStaff, financeStaff);

        List<IEmployee> protectedEmployees = new ArrayList<>();
        for (Employee e : employees) {
            protectedEmployees.add(new ProtectedEmployee((IEmployee) e));
        }

        Employee me = new Employee("me", RESPONSIBILITY.STAFF);
        System.out.println("\n================================================================");
        System.out.println("시나리오1. 일개 사원인 내가 회사 인원 인사 정보 조회");
        System.out.println("================================================================");
        PrintEmployeeInfo view = new PrintEmployeeInfo(me);
        view.printAllInfo(protectedEmployees);

        System.out.println("\n================================================================");
        System.out.println("시나리오2. 과장이 회사 인원 인사 정보 조회");
        System.out.println("================================================================");
        PrintEmployeeInfo view2 = new PrintEmployeeInfo(devManager);
        view2.printAllInfo(protectedEmployees);

        System.out.println("\n================================================================");
        System.out.println("시나리오3. 상무가 회사 인원 인사 정보 조회");
        System.out.println("================================================================");
        PrintEmployeeInfo view3 = new PrintEmployeeInfo(CTO);
        view3.printAllInfo(protectedEmployees);
    }

    public void runDynamicProxy(){
        Animal tiger = (Animal) Proxy.newProxyInstance(
                Animal.class.getClassLoader(),
                new Class[]{Animal.class},
                (proxy, method, args) -> {
                    Object target = new Tiger();
                    System.out.println("eat 메소드 호출 전");
                    Object result = method.invoke(target, args);
                    System.out.println("eat 메소드 호출 후");
                    return result;
                }
        );
        tiger.eat();
    }

    public void runAdaptor(){
        ISortEngine adaptor = new SortEngineAdaptor(new A_SortEngine(), new B_SortEngine());
        SortingMachine machine = new SortingMachine();
        machine.setEngine(adaptor);
        machine.sortingRun();
    }

    public void runDecorator(){
        System.out.println("====== 유탄 발사기 =======");
        Weapon generade_rifle = new Grenade(new BaseWeapon());
        generade_rifle.aim_and_fire();

        System.out.println("\n====== 개머리판 장착, 스코프 장착 =======");
        Weapon buttstock_scoped_rifle = new Buttstock(new Scoped(new BaseWeapon()));
        buttstock_scoped_rifle.aim_and_fire();

        System.out.println("\n====== 유탄 발사기 + 개머리판 + 스코프 장착 =======");
        Weapon buttstock_scoped_generade_rifle = new Buttstock(new Scoped(new Grenade(new BaseWeapon())));
        buttstock_scoped_generade_rifle.aim_and_fire();
    }

    public void runPracticalDecorator(){
        IData data = new MyData();
        IData data1 = new TimerMeasureDecorator(data);
        data1.setData(1);

        IData data2 = new SynchronizedDecorator(new TimerMeasureDecorator(data));
        data2.setData(1);

        IData data3 = new TimerMeasureDecorator(new SynchronizedDecorator(data));
        data3.setData(1);
    }

    public void runObserver(){
        study.practice.designPattern.observer.ISubject publisher = new ConcreteSubject();

        IObserver o1 = new ObserverA();
        IObserver o2 = new ObserverB();

        publisher.registerObserver(o1);
        publisher.registerObserver(o2);

        publisher.notifyObserver();

        publisher.removeObserver(o2);

        publisher.notifyObserver();
    }

    public void runWeatherByObserver(){
        WeatherAPI api = new WeatherAPI();
        WeatherObserver user1 = new KoreanUser("홍길동");
        WeatherObserver user2 = new KoreanUser("이순신");
        WeatherObserver monitor = new Monitoring("기상청");
        WeatherObserver naver = new CompanyAPI("네이버");

        api.registerObserver(user1);
        api.registerObserver(user2);
        api.registerObserver(monitor);
        api.registerObserver(naver);
        api.removeObserver(user1);

        api.measurementsChanged();
        api.measurementsChanged();
    }

    public void runIterator(){
        ConcreteAggregate aggregate = new ConcreteAggregate(5);

        aggregate.add(1);
        aggregate.add(2);
        aggregate.add(3);
        aggregate.add(4);
        aggregate.add(5);

        Iterator iter = aggregate.iterator();
        while (iter.hasNext()){
            System.out.printf("%s -> ", iter.next());
        }

    }

    public void runBoardByIterator(){
        Board board = new Board();

        board.addPost("디자인 패턴 강의 리뷰", LocalDate.of(2024, 8, 30));
        board.addPost("Iterator 패턴 잘 아시는분", LocalDate.of(2024, 11, 20));
        board.addPost("에러 로그 분석좀 부탁드립니다.", LocalDate.of(2023, 5, 16));

        print(board.getListPostIterator());
        print(board.getDatePostIterator());
    }

    public void print(java.util.Iterator<Post> iterator){
        java.util.Iterator<Post> iter = iterator;
        while (iter.hasNext()){
            Post post = iter.next();
            System.out.println(post.title + " / " + post.date);
        }
    }

    public void runTypeConvert(){
        String str = "{\"date\": \"2025-01-01\" ,\"time\": \"2025-03-12 11:23:00\"}";
        DateTimeObj obj = Functions.typeConvert(str, DateTimeObj.class);
        System.out.println(obj);
    }


}

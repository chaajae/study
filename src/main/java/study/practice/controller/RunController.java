package study.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.practice.dataStructure.CircularDoublyLinkedList.CircularDoublyLinkedList;
import study.practice.dataStructure.doublyLinkedList.DoublyLinkedList;
import study.practice.dataStructure.stack.MyStack;
import study.practice.designPattern.adaptor.*;
import study.practice.designPattern.builder.*;
import study.practice.designPattern.chainOfResponsibility.login.*;
import study.practice.designPattern.chainOfResponsibility.urlParser.*;
import study.practice.designPattern.composite.Composite;
import study.practice.designPattern.composite.Leaf;
import study.practice.designPattern.composite.directory.File;
import study.practice.designPattern.composite.directory.Folder;
import study.practice.designPattern.composite.practical.Bag;
import study.practice.designPattern.composite.practical.Item;
import study.practice.designPattern.composite.practical.ItemComponent;
import study.practice.designPattern.decorator.practical.*;
import study.practice.designPattern.decorator.weapon.*;
import study.practice.designPattern.dynamicFactory.DShape;
import study.practice.designPattern.dynamicFactory.DTriangle;
import study.practice.designPattern.dynamicFactory.DynamicShapeFactory;
import study.practice.designPattern.enumFactoryMethod.EnumShapeFactory;
import study.practice.designPattern.enumFactoryMethod.Shape;
import study.practice.designPattern.facade.*;
import study.practice.designPattern.flyweight.Memory;
import study.practice.designPattern.flyweight.Terrain;
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
import study.practice.designPattern.staticFactoryMethod.Book;
import study.practice.designPattern.staticFactoryMethod.Car;
import study.practice.designPattern.staticFactoryMethod.SmartPhone;
import study.practice.designPattern.staticFactoryMethod.grade.GradeCalculator;
import study.practice.designPattern.staticFactoryMethod.grade.MemberGrade;
import study.practice.designPattern.strategy.*;
import study.practice.designPattern.templateCallback.TestTemplate;
import study.practice.designPattern.templateCallback.practical.OperationTemplate;
import study.practice.designPattern.templateCallback.strategy.*;
import study.practice.designPattern.templateMethod.*;
import study.practice.domain.Response;
import study.practice.domain.repo.DummyRepository;
import study.practice.etc.gson.DateTimeObj;
import study.practice.etc.function.Functions;
import study.practice.service.DummyService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Proxy;
import java.time.LocalDate;
import java.util.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class RunController {

    private final DummyRepository dummyRepository;
    private final DummyService dummyService;


    public void runBuilderPattern() {
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

    public void runStrategyPattern() {
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

    public void runTemplateMethodPattern() {
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

    public void runNormalProxy() {
        ISubject sub = new NormalProxy(new RealSubject());
        sub.action();
    }

    public void runVirtualProxy() {
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

    public void runDynamicProxy() {
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

    public void runAdaptor() {
        ISortEngine adaptor = new SortEngineAdaptor(new A_SortEngine(), new B_SortEngine());
        SortingMachine machine = new SortingMachine();
        machine.setEngine(adaptor);
        machine.sortingRun();
    }

    public void runDecorator() {
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

    public void runPracticalDecorator() {
        IData data = new MyData();
        IData data1 = new TimerMeasureDecorator(data);
        data1.setData(1);

        IData data2 = new SynchronizedDecorator(new TimerMeasureDecorator(data));
        data2.setData(1);

        IData data3 = new TimerMeasureDecorator(new SynchronizedDecorator(data));
        data3.setData(1);
    }

    public void runObserver() {
        study.practice.designPattern.observer.ISubject publisher = new ConcreteSubject();

        IObserver o1 = new ObserverA();
        IObserver o2 = new ObserverB();

        publisher.registerObserver(o1);
        publisher.registerObserver(o2);

        publisher.notifyObserver();

        publisher.removeObserver(o2);

        publisher.notifyObserver();
    }

    public void runWeatherByObserver() {
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

    public void runIterator() {
        ConcreteAggregate aggregate = new ConcreteAggregate(5);

        aggregate.add(1);
        aggregate.add(2);
        aggregate.add(3);
        aggregate.add(4);
        aggregate.add(5);

        Iterator iter = aggregate.iterator();
        while (iter.hasNext()) {
            System.out.printf("%s -> ", iter.next());
        }

    }

    public void runBoardByIterator() {
        Board board = new Board();

        board.addPost("디자인 패턴 강의 리뷰", LocalDate.of(2024, 8, 30));
        board.addPost("Iterator 패턴 잘 아시는분", LocalDate.of(2024, 11, 20));
        board.addPost("에러 로그 분석좀 부탁드립니다.", LocalDate.of(2023, 5, 16));

        print(board.getListPostIterator());
        print(board.getDatePostIterator());
    }

    public void print(java.util.Iterator<Post> iterator) {
        java.util.Iterator<Post> iter = iterator;
        while (iter.hasNext()) {
            Post post = iter.next();
            System.out.println(post.title + " / " + post.date);
        }
    }

    public void runTypeConvert() {
        String str = "{\"date\": \"2025-01-01\" ,\"time\": \"2025-03-12 11:23:00\"}";
        DateTimeObj obj = Functions.typeConvert(str, DateTimeObj.class);
        System.out.println(obj);
    }

    public void runFacadePrevious() {
        DBMS dbms = new DBMS();
        dbms.put("홍길동", new Row("홍길동", "1890-02-14", "honggildong@naver.com"));
        dbms.put("임꺽정", new Row("임꺽정", "1820-11-02", "imgguckjong@naver.com"));
        dbms.put("주몽", new Row("주몽", "710-08-27", "jumong@naver.com"));

        Cashe cashe = new Cashe();

        String name = "홍길동";
        Row row = cashe.get(name);

        if (row == null) {
            row = dbms.query(name);
            if (row != null) {
                cashe.put(row);
            }
        }

        if (row != null) {
            Message message = new Message(row);
            System.out.println(message.makeName());
            System.out.println(message.makeBirthday());
            System.out.println(message.makeEmail());
        } else {
            System.out.println(name + "가 데이터베이스에 존재하지 않습니다.");
        }
    }

    public void runFacade() {
        Facade facade = new Facade();
        facade.insert();

        String name = "홍길동";
        facade.run(name);
    }

    public void runFlyweight() {
        Terrain terrain = new Terrain();

        for (int i = 0; i < 5; i++) {
            terrain.render(
                    "Oak",
                    Math.random() * Terrain.CANVAS_SIZE,
                    Math.random() * Terrain.CANVAS_SIZE
            );
        }
        for (int i = 0; i < 5; i++) {
            terrain.render(
                    "Acacia",
                    Math.random() * Terrain.CANVAS_SIZE,
                    Math.random() * Terrain.CANVAS_SIZE
            );
        }

        for (int i = 0; i < 5; i++) {
            terrain.render(
                    "Jungle",
                    Math.random() * Terrain.CANVAS_SIZE,
                    Math.random() * Terrain.CANVAS_SIZE
            );
        }

        Memory.print();
    }

    public void runComposite() {
        Composite composite1 = new Composite();

        Leaf leaf1 = new Leaf();
        Composite composite2 = new Composite();

        composite1.add(leaf1);
        composite1.add(composite2);

        Leaf leaf2 = new Leaf();
        Leaf leaf3 = new Leaf();
        Leaf leaf4 = new Leaf();

        composite2.add(leaf2);
        composite2.add(leaf3);
        composite2.add(leaf4);

        composite1.operation();
    }

    public void runPracticalComposite() {
        Bag bag_main = new Bag("메인 가방");

        Item armor = new Item("갑옷", 250);
        Item sword = new Item("장검", 500);

        bag_main.add(armor);
        bag_main.add(sword);

        Bag bag_food = new Bag("음식 가방");

        Item apple = new Item("사과", 400);
        Item banana = new Item("바나나", 130);

        bag_food.add(apple);
        bag_food.add(banana);

        bag_main.add(bag_food);

        printPrice(bag_main);
        printPrice(bag_food);
    }

    public void printPrice(ItemComponent bag) {
        int result = bag.getPrice();
        System.out.println(bag.getName() + "의 아이템 총합 : " + result + " 골드");
    }

    public void runDirectoryComposite() {
        Folder root = new Folder("root");

        File file1 = new File("file1", 10);
        Folder sub1 = new Folder("sub1");
        Folder sub2 = new Folder("sub2");

        root.add(sub1);
        root.add(file1);
        root.add(sub2);

        File file11 = new File("file11", 10);
        File file12 = new File("file12", 10);

        sub1.add(file11);
        sub1.add(file12);

        File file21 = new File("file21", 10);
        sub2.add(file21);

        root.print();
    }

    public void runUrlInfo() {
        String url1 = "http://www.youtube.com:80";
        System.out.println("INPUT: " + url1);
        UrlParser.run(url1);

        String url2 = "https://www.naver.com:443";
        System.out.println("INPUT: " + url2);
        UrlParser.run(url2);

        String url3 = "http://localhost:8080";
        System.out.println("INPUT: " + url3);
        UrlParser.run(url3);
    }

    public void runUrlParserUseCOR() {
        Handler handler1 = new ProtocolHandler();
        Handler handler2 = new DomainHandler();
        Handler handler3 = new PortHandler();

        handler1.setNext(handler2).setNext(handler3);

        String url1 = "http://www.youtube.com:80";
        System.out.println("INPUT: " + url1);
        handler1.run(url1);

        String url2 = "https://www.naver.com:443";
        System.out.println("INPUT: " + url2);
        handler1.run(url2);

        String url3 = "http://localhost:8080";
        System.out.println("INPUT: " + url3);
        handler1.run(url3);
    }

    public void runLoginUseCOR() {
        try {
            Server server = new Server();
            server.register("kim@naver.com", "12345");
            server.register("chajy95@naver.com", "54321");
            server.register("lee@naver.com", "15243");
            LimitLoginAttemptMiddleware middleware1 = new LimitLoginAttemptMiddleware();
            AuthorizeMiddleware middleware2 = new AuthorizeMiddleware(server);
            AuthenticationMiddleware middleware3 = new AuthenticationMiddleware();
            LoggingMiddleware middleware4 = new LoggingMiddleware();

            middleware1.setNext(middleware2)
                    .setNext(middleware3)
                    .setNext(middleware4);

            do {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String email = reader.readLine();
                System.out.print("\nEmail : ");
                System.out.print("Password : ");
                String password = reader.readLine();

                short result = middleware1.check(email, password);

                if (result == -2) {
                    throw new RuntimeException("로그인 시도 횟수 초과로 프로그램을 종료합니다.");
                } else if (result == -1) {
                    break;
                } else if (result == 0) {
                    continue;
                }

            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runEnumFactoryMethod() {
        Shape rectangle = EnumShapeFactory.RECTANGLE.create("red");
        rectangle.draw();

        Shape circle = EnumShapeFactory.CIRCLE.create("blue");
        circle.draw();
    }

    public void runDynamicFactory() {
        DShape rectangle = DynamicShapeFactory.create("Rectangle", "red");
        rectangle.draw();

        DShape circle = DynamicShapeFactory.create("Circle", "blue");
        circle.draw();

        DynamicShapeFactory.registerType("Triangle", DTriangle.class);
        DShape triangle = DynamicShapeFactory.create("Triangle", "green");
        triangle.draw();

    }

    public void runCallback() {
        int x = 100;
        int y = 20;
        TestTemplate t = new TestTemplate();
        int result = t.workflow(e -> e + e);

        System.out.println(result);
    }

    public void runOperationStrategy() {
        int x = 100;
        int y = 30;

        OperationContext context = new OperationContext();

        context.setOperation(new Plus());
        System.out.println(context.calculate(x, y));

        context.setOperation(new Sub());
        System.out.println(context.calculate(x, y));

        context.setOperation(new Multi());
        System.out.println(context.calculate(x, y));

        context.setOperation(new Divide());
        System.out.println(context.calculate(x, y));

    }

    public void runOperationCallback() {
        int x = 100;
        int y = 30;

        OperationTemplate template = new OperationTemplate();
        System.out.println(template.calculate(x, y, (x1, y1) -> x1 + y1));
        System.out.println(template.calculate(x, y, (x1, y1) -> x1 - y1));
        System.out.println(template.calculate(x, y, (x1, y1) -> x1 * y1));
        System.out.println(template.calculate(x, y, (x1, y1) -> x1 / y1));
    }

    public void runBook() {
        Book book = Book.titleOf("어린왕자");
    }

    public void runCar() {
        Car tesla = Car.brandBlackFrom("Tesla");
        Car bmw = Car.brandColorOf("BMW", "red");
        System.out.println(tesla);
        System.out.println(bmw);
    }

    public void runPhone() {
        SmartPhone applePhone = SmartPhone.getApplePhone();
        SmartPhone samsungPhone = SmartPhone.getSamsungPhone();
        SmartPhone chinesePhone = SmartPhone.getChinesePhone();

        applePhone.information();
        samsungPhone.information();
        chinesePhone.information();

        SmartPhone phone1 = SmartPhone.getPhone(1000);
        SmartPhone phone2 = SmartPhone.getPhone(2000);
        SmartPhone phone3 = SmartPhone.getPhone(3000);

        phone1.information();
        phone2.information();
        phone3.information();
    }

    public void runGrade() {
        System.out.println(GradeCalculator.of(30).toText());
        System.out.println(GradeCalculator.of(90).toText());

        MemberGrade memberGrade = MemberGrade.of();
        System.out.println(memberGrade);
    }

    @PostMapping("/set")
    public void set() {
        long start = System.currentTimeMillis();
        try {
            dummyRepository.set();
        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("TIME ::: " + ((end - start) / 1000));
    }

    @PostMapping("/get")
    public void get() {
        dummyRepository.get();
    }

    @PostMapping("/just")
    public void just() {
        dummyRepository.just();
    }

    @PostMapping("/doublyLinkedList")
    public void doublyLinkedList(){
        DoublyLinkedList<Number> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println(list.toString2());

        list.removeFirst();

        System.out.println(list.toString2());

        list.removeLast();

        System.out.println(list.toString2());

        list.remove(2.5);

        System.out.println(list.toString2());

        System.out.println(list.get(2));
        list.set(1, 3.5);

        System.out.println(list.toString2());

    }

    @PostMapping("/doublyLinkedListToString2")
    public void doublyLinkedListToString2(){
        DoublyLinkedList<Number> list = new DoublyLinkedList<>();
        list.addLast(2);
        list.addFirst(1);
        list.addLast(3);
        list.add(2, 2.5);
        System.out.println(list.toString2());
    }

    @PostMapping("/circularDoublyLinkedList")
    public void circularDoublyLinkedList(){
        CircularDoublyLinkedList<Number> list = new CircularDoublyLinkedList<>();
        list.addLast(2);
        list.addFirst(1);
        list.addLast(3);
        list.add(2, 2.5);
        System.out.println(list.toString2());
    }

    @PostMapping("/myStack")
    public void myStack(){
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.search(4));
        System.out.println(stack.search(3));

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack);
    }

    @PostMapping("/openFeign/test")
    public void openFeign(@RequestBody Map<String,String> param){

        try {
            Response response = dummyService.openFeignTest(param.get("token"), param.get("uid"));
            System.out.println(response.getData());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @PostMapping("/dummy/set")
    public void dummySet(){
        try {
            dummyRepository.set();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @PostMapping("/dummy/get")
    public void dummyGet(){
        try {
            dummyRepository.get();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }




}

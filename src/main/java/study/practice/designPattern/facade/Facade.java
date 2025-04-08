package study.practice.designPattern.facade;

public class Facade {
    private DBMS dbms = new DBMS();
    private Cashe cashe = new Cashe();

    public void insert(){
        dbms.put("홍길동", new Row("홍길동", "1890-02-14", "honggildong@naver.com"));
        dbms.put("임꺽정", new Row("임꺽정", "1820-11-02", "imgguckjong@naver.com"));
        dbms.put("주몽", new Row("주몽", "710-08-27", "jumong@naver.com"));
    }

    public void run(String name){
        Row row = cashe.get(name);

        if(row == null){
            row = dbms.query(name);
            if(row != null){
                cashe.put(row);
            }
        }

        if(row != null) {
            Message message = new Message(row);

            System.out.println(message.makeName());
            System.out.println(message.makeBirthday());
            System.out.println(message.makeEmail());
        }
        else {
            System.out.println(name + " 가 데이터베이스에 존재하지 않습니다.");
        }
    }

}

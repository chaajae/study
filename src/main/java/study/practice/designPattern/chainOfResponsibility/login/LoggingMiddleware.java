package study.practice.designPattern.chainOfResponsibility.login;

public class LoggingMiddleware extends Middleware{
    @Override
    public short check(String email, String password) {
        System.out.println("요청을 로깅합니다.");
        return -1;
    }
}

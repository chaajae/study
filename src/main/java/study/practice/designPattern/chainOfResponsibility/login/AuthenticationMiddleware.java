package study.practice.designPattern.chainOfResponsibility.login;

public class AuthenticationMiddleware extends Middleware{

    @Override
    public short check(String email, String password) {
        short flag = 1;
        if(email.equals("chajy95@naver.com")){
            System.out.println("Hello, admin!");
            flag = -1;
        }else{
            System.out.println("Hello, user!");
            flag = super.check(email, password);
        }
        return flag;
    }
}

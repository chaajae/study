package study.practice.designPattern.chainOfResponsibility.login;

public class LimitLoginAttemptMiddleware extends Middleware{
    private int limit = 3;
    private int count = 0;

    @Override
    public short check(String email, String password) {
        short flag = 1;
        if(count > limit){
            System.out.println("로그인 요청 횟수 제한 !!");
            flag = -2;
        }else{
            flag = super.check(email, password);
        }
        count++;
        return flag;
    }
}

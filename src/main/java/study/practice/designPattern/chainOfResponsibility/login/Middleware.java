package study.practice.designPattern.chainOfResponsibility.login;

public abstract class Middleware {
    protected Middleware nextMiddleware = null;

    public Middleware setNext(Middleware middleware){
        this.nextMiddleware = middleware;
        return middleware;
    }

    public short check(String email, String password){
        /*
        -2 : Exception
        -1 : break    (종료)
         0 : continue (재입력)
         1 : 그대로 처리
         */
        short flag = 1;

        if(nextMiddleware != null){
            flag = nextMiddleware.check(email, password);
        }
        return flag;
    }

}

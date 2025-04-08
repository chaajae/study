package study.practice.designPattern.chainOfResponsibility.login;

public class AuthorizeMiddleware extends Middleware{
    private Server server;

    public AuthorizeMiddleware(Server server) {
        this.server = server;
    }

    @Override
    public short check(String email, String password) {
        short flag = 1;
        if(!server.hasEmail(email)){
            System.out.println("This email is not registered!");
            flag = 0;
        }else if(!server.isValidPassword(email, password)){
            System.out.println("Wrong password!");
            flag = 0;
        }else{
            flag = super.check(email, password);
        }
        return flag;
    }
}

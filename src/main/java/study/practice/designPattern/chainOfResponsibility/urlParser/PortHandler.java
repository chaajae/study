package study.practice.designPattern.chainOfResponsibility.urlParser;

public class PortHandler extends Handler{
    @Override
    protected void process(String url) {
        int index = url.lastIndexOf(":");
        if(index != -1){
            String strPort = url.substring(index + 1);
            try {
                int port = Integer.parseInt(strPort);
                System.out.println("PORT : " + port + "\n");
            }catch (Exception e){e.printStackTrace();}
        }
    }
}

package study.practice.designPattern.chainOfResponsibility.urlParser;

public class UrlParser {

    public static void run(String url){
        int index = url.indexOf("://");
        if(index != -1){
            System.out.println("PROTOCOL : " + url.substring(0, index));
        }else{
            System.out.println("NO PROTOCOL");
        }

        int startIndex = url.indexOf("://");
        int lastIndex = url.lastIndexOf(":");

        System.out.print("DOMAIN : ");
        if(startIndex == -1){
            if(lastIndex == -1){
                System.out.println(url);
            }else{
                System.out.println(url.substring(0, lastIndex));
            }
        }else if(startIndex != lastIndex){
            System.out.println(url.substring(startIndex + 3, lastIndex));
        }else{
            System.out.println(url.substring(startIndex + 3));
        }

        int index2 = url.lastIndexOf(":");
        if(index2 != -1){
            String strPort = url.substring(index2 + 1);
            try {
                int port = Integer.parseInt(strPort);
                System.out.println("PORT : " + port + "\n");
            }catch (Exception e){e.printStackTrace();}
        }

    }
}

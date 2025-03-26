package study.practice.designPattern.templateMethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileProcessor {
    private String path;

    public FileProcessor(String path) {
        this.path = path;
    }

    public final int process() {
        BufferedReader reader = null;
        int result = getResult();

        try {
            reader = new BufferedReader(new FileReader(path));
            String line = null;

            while ((line = reader.readLine()) != null){
                result = calculate(result, Integer.parseInt(line));
            }
            reader.close();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            if(reader != null) try { reader.close(); }catch (Exception e){}
        }
        return result;
    }

    protected abstract int calculate(int result, int number);
    protected abstract int getResult();
}

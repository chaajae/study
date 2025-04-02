package study.practice.designPattern.proxy.virtual.implement;

public class HighResolutionImage implements IImage{
    private String img;

    public HighResolutionImage(String path) {
        loadImage(path);
    }

    private void loadImage(String path) {
        try {
            Thread.sleep(1000);
            img = path;
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.printf("%s에 있는 이미지 로딩 완료\n", path);
    }

    @Override
    public void showImage() {
        System.out.printf("%s 이미지 출력\n", img);
    }
}

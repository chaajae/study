package study.practice.designPattern.proxy.virtual.implement;

public class ImageProxy implements IImage{
    private IImage proxyImage;
    private String path;

    public ImageProxy(String path) {
        this.path = path;
    }

    @Override
    public void showImage() {
        proxyImage = new HighResolutionImage(path);
        proxyImage.showImage();
    }
}

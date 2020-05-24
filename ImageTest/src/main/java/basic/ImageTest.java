package basic;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ImageTest {
    public static void main(String[] args) throws Exception {
        readAndWrite();
        readComparison();
    }

    public static void readAndWrite() throws Exception {
        //图像文件再内存中保存为BufferedImage
        //用ImageIO.read()方法来读取
        //用ImageIO.write()方法来写入文件
        BufferedImage image = ImageIO.read(new File("c:/temp/test.jpg"));
        System.out.println("Height: " + image.getHeight());
        System.out.println("Width: " + image.getWidth());
        ImageIO.write(image, "png", new File("c:/temp/test.png"));
        ImageIO.write(image, "png", new File("c:/temp/image.png"));
    }

    public static void readComparison() throws Exception {
        System.out.println("===========加载测试=============");
        //ImageIO需要测试图片的类型，加载合适的ImageReader来读取图片，耗时较长
        long startTime = System.nanoTime();
        BufferedImage image = ImageIO.read(new File("c:/temp/test.jpg"));
        System.out.println("Height: " + image.getHeight());
        System.out.println("Width: " + image.getWidth());
        long endTime = System.nanoTime();
        System.out.println("ImageIO 耗时： " + (endTime - startTime) / 1000000.0 + "ms");

        //指定用jpg Reader 来读，速度会更快
        startTime = System.nanoTime();
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader) readers.next();
        System.out.println(reader.getClass().getName());
        ImageInputStream iis = ImageIO.createImageInputStream("c:/temp/test.jpg");
        reader.setInput(iis,true);
        System.out.println("Height: " + reader.getHeight(0));
        System.out.println("Width: " + reader.getWidth(0));
        endTime=System.nanoTime();
        System.out.println("ImageReader 耗时： " + (endTime - startTime) / 1000000.0 + "ms");

    }

}

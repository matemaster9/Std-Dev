package cs.matemaster.jdk.io;

import cs.matemaster.jdk.util.StdioUtil;

import java.io.*;
import java.nio.file.Paths;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/6 14:14
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        File img = Paths.get(StdioUtil.getResourcesIdeaPath(), "img", "img.gif").toFile();
        File imgCopy = Paths.get(StdioUtil.getResourcesIdeaPath(), "img", "img-copy.gif").toFile();
        copy(img, imgCopy);
    }

    private static void copy(File src, File dst) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(src);
            outputStream = new FileOutputStream(dst);
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) != -1) {
                outputStream.write(bytes);
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            StdioUtil.autoClose(inputStream);
            StdioUtil.autoClose(outputStream);
        }
    }
}

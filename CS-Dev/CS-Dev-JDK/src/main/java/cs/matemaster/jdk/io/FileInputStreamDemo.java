package cs.matemaster.jdk.io;


import cs.matemaster.jdk.util.StdioUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/6 14:11
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        File img = Paths.get(StdioUtil.getResourcesIdeaPath(), "img", "img.gif").toFile();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(img);
            int result = 0;
            byte[] bytes = new byte[1024];
            while ((result = fileInputStream.read(bytes)) != -1) {
                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            StdioUtil.autoClose(fileInputStream);
        }
    }
}

package cs.matemaster.jdk.io;

import cs.matemaster.jdk.util.StdioUtil;

import java.io.*;
import java.nio.file.Paths;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/18 21:28
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        File text = Paths.get(StdioUtil.getResourcesIdeaPath(), "text", "孤勇者.txt").toFile();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(text);
            int result = 0;
            char[] chars = new char[512];
            while ((result = fileReader.read(chars)) != -1) {
                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            StdioUtil.autoClose(fileReader);
        }
    }
}

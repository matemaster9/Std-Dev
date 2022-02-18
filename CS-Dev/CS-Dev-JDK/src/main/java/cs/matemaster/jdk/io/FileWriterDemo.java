package cs.matemaster.jdk.io;

import cs.matemaster.jdk.util.StdioUtil;

import java.io.*;
import java.nio.file.Paths;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/18 22:17
 */
public class FileWriterDemo {
    public static void main(String[] args) {
        File src = Paths.get(StdioUtil.getResourcesIdeaPath(), "text", "孤勇者.txt").toFile();
        File dst = Paths.get(StdioUtil.getResourcesIdeaPath(), "text", "孤勇者-copy.txt").toFile();
        copyText(src, dst);
    }

    private static void copyText(File src, File dst) {
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader(src);
            writer = new FileWriter(dst);
            char[] chars = new char[512];
            while ((reader.read(chars)) != -1) {
                writer.write(chars);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            StdioUtil.autoClose(reader);
            StdioUtil.autoClose(writer);
        }
    }
}

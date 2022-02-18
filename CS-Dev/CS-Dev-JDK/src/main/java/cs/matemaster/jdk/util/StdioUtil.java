package cs.matemaster.jdk.util;

import cs.matemaster.log.SysLogUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/18 22:05
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StdioUtil {

    private static long current = 0;

    /**
     * 获取工作目录resources下的文件路径(root)
     *
     * @return 返回root路径
     */
    public static String getResourcesIdeaPath() {
        return Paths.get(System.getProperty("user.dir"), "CS-Dev-JDK", "src", "main", "resources").toString();
    }

    /**
     * 获取编译目录resources下的文件路径(root)
     * @return 返回root路径
     */
    public static String getResourcesPath() {
        String path = null;
        try {
            path = Paths.get(new URI(StdioUtil.class.getClassLoader().getResource("").toString())).toString();
        } catch (URISyntaxException e) {
            SysLogUtil.err("获取resources路径失败：" + e.getMessage());
        }
        return path;
    }

    /**
     * 计时器
     */
    public static void start() {
        current = System.currentTimeMillis();
    }

    public static long stop() {
        return System.currentTimeMillis() - current;
    }

    /**
     * 自动关闭
     *
     * @param inputStream
     */
    public static void autoClose(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            SysLogUtil.err("InputStream自动关闭失败：" + e.getMessage());
        }
    }

    public static void autoClose(OutputStream outputStream) {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            SysLogUtil.err("OutputStream自动关闭失败：" + e.getMessage());
        }
    }

    public static void autoClose(Reader reader) {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            SysLogUtil.err("Reader自动关闭失败：" + e.getMessage());
        }
    }

    public static void autoClose(Writer writer) {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            SysLogUtil.err("Writer自动关闭失败：" + e.getMessage());
        }
    }
}

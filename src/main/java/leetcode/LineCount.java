package leetcode;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class LineCount {
    //    代码行数
    private static AtomicLong codeLineCount;
    //    空行数

    private static AtomicLong blankLineCount;
    //    注释行数

    private static AtomicLong commentLineCount;

    //    调整处理文件的吞吐量
    private Queue<File> fileQueue = new ArrayBlockingQueue<>(1000);

    //
    private Queue<File> dirQueue = new ArrayBlockingQueue<>(1000);
    //    读取目录  获得文件
//    public File[] fileList(String path) {
//        File file = new File(path);
//        if (file.exists() && file.isDirectory()) {
//            return file.listFiles();
//        }
//        return null;
//    }

    public void fileList(String path) {
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            dirQueue.add(file);
        } else {
            fileQueue.add(file);
        }
    }


    //    check string
    public boolean isNotBlank(String s) {
        if (s != null && s.length() > 0 && !s.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    //    读取文件内容
    public void readContent(File file) {
        if (file.exists()) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                reader.lines().parallel().forEach(s -> {
                    if (isNotBlank(s)) {
                        s = s.trim();
                        if (s.startsWith("//")) {
                            commentLineCount.incrementAndGet();
                        } else if (s.length() > 0) {
                            codeLineCount.incrementAndGet();
                        } else {
                            blankLineCount.incrementAndGet();
                        }
                    } else {
                        blankLineCount.incrementAndGet();
                    }
                });

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        DirThread dirThread = new DirThread(new ArrayBlockingQueue<>(1000));
        dirThread.start();
    }

}

class DirThread extends Thread {
    private ArrayBlockingQueue<File> dirQueue;

    public DirThread(ArrayBlockingQueue<File> dirQueue) {
        this.dirQueue = dirQueue;
    }

    @Override
    public void run() {
        try {
            while (null != dirQueue.take()) {
                File file = dirQueue.take();

            }
        } catch (InterruptedException e) {

        }
    }

}

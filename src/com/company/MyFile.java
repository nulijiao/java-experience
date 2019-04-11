package com.company;
import java.io.*;

public class MyFile {
    public static int num = 0;
    private BufferedReader in;
    private BufferedWriter out;
    private File file;
    public void copy(File originFileName, File finalFileName) throws IOException{
        BufferedReader br = null;
        try {
           out = new BufferedWriter(new FileWriter(finalFileName));
           in = new BufferedReader(new FileReader(originFileName));
           String line = null;
            while ((line = in.readLine())!=null) {
                out.write(line);
                out.newLine(); //因为每次是读取一行内容，所以显示一行后就得换行
                out.flush(); //刷新内容
            }
        } catch (IOException e) {
            throw new RuntimeException("读写错误！");
        }finally{
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e2) {
                    throw new RuntimeException("写入关闭失败！");
                }
            }

            if (in != null) {
                try {
                   in.close();
                } catch (Exception e2) {
                    throw new RuntimeException("读取关闭失败！");
                }
            }
        }

    }

    public MyFile(String absolutePath, String fileName) throws IOException {
        file = new File(absolutePath + fileName);
    }

    public int editFile(String absolutePath, String fileName, String content, int positionNum)  throws IOException {
       try {
           num++;
//           System.exit(0);
       }
       finally {
           System.out.println(num);
           return num++;
       }
    }

    public void writeToString(String content) throws IOException{
        try {
            out = new BufferedWriter(new FileWriter(file));
            out.write(content);

        } catch (IOException e) {
            throw new RuntimeException("读写错误！");
        }finally{
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e2) {
                    throw new RuntimeException("写入关闭失败！");
                }
            }



        }
    }

    public String readToString() {
        String content = "";
        try {
            in = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = in.readLine())!=null) {
                content = content + line;
            }
        } catch (IOException e) {
            throw new RuntimeException("读写错误！");
        }finally{
            if (in != null) {
                try {
                   in.close();
                } catch (Exception e2) {
                    throw new RuntimeException("写入关闭失败！");
                }
            }


            return content;
        }
    }

    public static void main(String[] args)throws IOException {
//        MyFile f = new MyFile();
//     f.copy("a.txt", "b.txt");
//      f.addFile("", "f.txt", "13deffre\nfrjgf");
//   f.editFile("","", "", 8);
      System.out.println(MyFile.num);
        MyFile f = new MyFile("","f1.txt");
        f.writeToString("6778");

        System.out.println(f.readToString());
    }
}





package com.company;

import java.io.*;
import java.util.Scanner;

public class Terminal {

    class ReaderConsole implements Runnable{
        private InputStream is;
        public ReaderConsole(InputStream is){
            this.is = is;
            System.out.println(is);
        }
        public void run(){
            System.out.println("run read");
            InputStreamReader isr = null;
            try {
                isr = new InputStreamReader(is, "gbk");
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            BufferedReader br = new BufferedReader(isr);

            int c = -1;
            try{
                while((c = br.read()) != -1){
                    System.out.print((char)c);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    class WrittenConsole implements Runnable{
        private OutputStream os;
        public WrittenConsole(OutputStream os){
            this.os = os;
        }
        public void run(){
            System.out.println("run");
            try{
                while(true){
                    String line = this.getConsoleLine();
                    System.out.println("lg"+line);
                    line += "/n";
                    Process process = Runtime.getRuntime().exec(line);
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        private String getConsoleLine() throws IOException{
            System.out.println("start ");
            String line = null;
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(input);
            line = br.readLine();
            return line;
        }
    }

    public void execute() throws Exception{
        String[] cmds = {"/bin/sh", "-c", "cmds"};
        System.out.println("run main");
        Process process = Runtime.getRuntime().exec(cmds);
        InputStream is = process.getInputStream();
        OutputStream os = process.getOutputStream();
        Thread t1 = new Thread(new ReaderConsole(is));
        Thread t2 = new Thread(new WrittenConsole(os));
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Read a full line of input from stdin and save it to our variable, inputString.
        String inputString = scan.nextLine();
        // reverse此方法返回StringBuffer對象的顛倒順序
        String reverse = new StringBuffer(inputString).reverse().toString();

        System.out.println(inputString.equals(reverse));
        Terminal t = new Terminal();
        try{
            t.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


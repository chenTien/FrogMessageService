package concurrentInPractice;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 线程通信,管道
 * Created by chen.Tian on 2017/4/17.
 */
public class Piped {
    public static void main(String[] args) throws Exception{
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //将输入流输出流进行连接,否则抛出IOE
        out.connect(in);
        Thread thread = new Thread(new Print(in),"PrintThread");
        thread.start();
        int receive ;
        try {
            while ((receive=System.in.read())!=-1){
                out.write(receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }

    }

    static class Print implements Runnable{
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read())!=-1){
                    System.out.print((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

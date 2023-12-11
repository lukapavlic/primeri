package si.um.feri.banka;

import java.util.Arrays;
import java.util.List;

public class Aplikacija {

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            for (int i=0;i<100;i++) {
                System.out.print(".");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

//        new Thread(()->{
//            List<String> list=Arrays.asList("A","Ž","C");
//            list.sort((a,b)->a.compareTo(b));
//            list.forEach(System.out::println);
//        }).start();

    }

}

package si.um.feri.banka;

import java.awt.*;

public class App2Lambda {

    public static void main(String[] args) {
        Frame f=new Frame();
        Button b=new Button();
        f.add(b);

        b.addActionListener(System.out::println);

        f.setVisible(true);
    }

}

package si.um.feri.banka;

import si.um.feri.banka.vao.BancniRacun;
import si.um.feri.banka.vao.ZlatiRacun;

public class Testek {

    public static void main(String[] args) {

        BancniRacun o1=new BancniRacun("123");
        BancniRacun o2=new BancniRacun("123");
        System.out.println(o1.equals(o2));



//        BancniRacun br=new BancniRacun();
//        ZlatiRacun zr=new ZlatiRacun();
//
//        BancniRacun tretji=new ZlatiRacun();
//
//        br.izpis();
//        zr.izpis();
//
//        tretji.izpis();


    }

}

class Drugi {

}
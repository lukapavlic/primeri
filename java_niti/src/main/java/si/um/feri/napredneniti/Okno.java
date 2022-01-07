package si.um.feri.napredneniti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Okno extends javax.swing.JFrame {

    private Stevec st = new Stevec();
    private Vrecka v = new Vrecka(4);
    //private VreckaSKljucavnico v = new VreckaSKljucavnico();

    private Proizvajalec proizvajalec;
    private Potrosnik potrosnik;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;

    public static void main(String args[]) throws Exception {
        javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Okno().setVisible(true);
            }
        });
    }

    public Okno() {
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Štej");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("100");

        jLabel1.setText("100");

        jButton2.setText("Poženi proizvajalca in potrošnika");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ustavi proizvajalca in potrošnika");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Izračunaj Fibonačija");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel1))
                                        .addComponent(jButton4)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        st.reset();
        long n = Long.parseLong(jTextField1.getText());
        StevecNit nit1 = new StevecNit(st, n);
        StevecNit nit2 = new StevecNit(st, n);
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(nit1);
        es.execute(nit2);


//    while (es.) {
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException ex) {
//        }
//    }
//
//    jLabel1.setText(st.getSt()+"");


//    Thread thread1=new Thread(nit1);
//    Thread thread2=new Thread(nit2);
//
//    thread1.start();
//    thread2.start();
//
//    try {
//        thread1.join();
//        thread2.join();
//    } catch (InterruptedException ex) {}
//
//
//    jLabel1.setText(st.getSt()+"");

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        //zagon
        proizvajalec =
                //new ProizvajalecExchanger(v);
                new Proizvajalec(v);
        potrosnik =
                //new PotrosnikExchanger(v);
                new Potrosnik(v);

        new Thread(proizvajalec).start();
        new Thread(potrosnik).start();

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        //ustavitev
        proizvajalec.ustavi();
        potrosnik.ustavi();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {


        ArrayList<String> al = new ArrayList<String>();

        java.util.List al2 = Collections.synchronizedList(al);


        //fibo
        ExecutorService es = Executors.newCachedThreadPool();

        long st = Long.parseLong(jTextField1.getText());

        Future<Long> future = es.submit(new Fibonacci(st));

        System.out.println(future.isDone());

        while (!future.isDone())
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Okno.class.getName()).log(Level.SEVERE, null, ex);
            }

        try {
            jLabel1.setText(future.get() + "");
        } catch (InterruptedException ex) {
            Logger.getLogger(Okno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Okno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

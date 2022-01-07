package si.um.feri.niti;

public class Okno extends javax.swing.JFrame {

    private javax.swing.JButton btnPozeni;

    public Okno() {
        btnPozeni = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        btnPozeni.setText("Poženi");

        btnPozeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPozeniActionPerformed(evt);
            }
        });

        add(btnPozeni);
        pack();
    }

    public static void main(String args[]) throws Exception {
        javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Okno().setVisible(true);
            }
        });
    }

    private void btnPozeniActionPerformed(java.awt.event.ActionEvent evt) {
        Izpisovalec iz1R = new Izpisovalec("*", 400);
        Izpisovalec iz2R = new Izpisovalec("X", 400);

        Thread iz1 = new Thread(iz1R);
        Thread iz2 = new Thread(iz2R);

        System.out.println("Klical bom start");

        iz1.setPriority(Thread.MIN_PRIORITY);
        iz2.setPriority(Thread.MAX_PRIORITY);

        iz1.start();
        iz2.start();

//        iz1R.run();
//        iz2R.run();

//        try {
//            iz2.join();
//        } catch (InterruptedException ex) {
//
//        }

        iz1R.zaustaviNit();

        System.out.println("Metoda se je končala");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem;

/**
 *
 * @author 91310
 */
public class UIclasstime extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public UIclasstime() {
        initComponents();
        setTitle("Create a schedule");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        dateChooserPanel1 = new datechooser.beans.DateChooserPanel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        show2Swing1 = new datechooser.demo.steps.Show2Swing();
        show1Components1 = new datechooser.demo.steps.Show1Components();
        dateChooserPanel2 = new datechooser.beans.DateChooserPanel();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtxtstime = new javax.swing.JTextField();
        jtxtetime = new javax.swing.JTextField();
        jtxtmodule = new javax.swing.JTextField();
        jtxtintake = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbtncreatclasstime = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtxtdate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        dateChooserCombo2.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("SimSun", java.awt.Font.PLAIN, 15),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("SimSun", java.awt.Font.PLAIN, 15),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("SimSun", java.awt.Font.PLAIN, 15),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("SimSun", java.awt.Font.PLAIN, 15),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("SimSun", java.awt.Font.PLAIN, 15),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("SimSun", java.awt.Font.PLAIN, 15),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));

    jLabel7.setForeground(new java.awt.Color(153, 153, 153));
    jLabel7.setText("//00:00");

    jLabel1.setText("Lecture Date:");

    jLabel2.setText("Start time:");

    jLabel3.setText("End time:");

    jLabel4.setText("Module Name:");

    jLabel5.setText("Intake Code:");

    jbtncreatclasstime.setBackground(new java.awt.Color(0, 153, 153));
    jbtncreatclasstime.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
    jbtncreatclasstime.setForeground(new java.awt.Color(255, 255, 255));
    jbtncreatclasstime.setText("Create");
    jbtncreatclasstime.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jbtncreatclasstimeActionPerformed(evt);
        }
    });

    jLabel6.setForeground(new java.awt.Color(153, 153, 153));
    jLabel6.setText("//yy/mm/dd");

    jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(102, 0, 102));
    jLabel8.setText("Class Time");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)))
                .addComponent(jLabel3)
                .addComponent(jLabel2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jtxtmodule)
                .addComponent(jtxtintake)
                .addComponent(jtxtdate)
                .addComponent(jtxtstime)
                .addComponent(jtxtetime, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel7)
                .addComponent(jLabel6))
            .addGap(88, 88, 88))
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(193, 193, 193)
                    .addComponent(jbtncreatclasstime))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(166, 166, 166)
                    .addComponent(jLabel8)))
            .addContainerGap(173, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(36, 36, 36)
            .addComponent(jLabel8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1)
                .addComponent(jLabel6))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtstime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)
                .addComponent(jLabel7))
            .addGap(27, 27, 27)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtxtetime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(jtxtmodule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(24, 24, 24)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(jtxtintake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(64, 64, 64)
            .addComponent(jbtncreatclasstime)
            .addGap(76, 76, 76))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    setSize(new java.awt.Dimension(518, 547));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtncreatclasstimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtncreatclasstimeActionPerformed
       Admin admin = new Admin();
       admin.createclasstime(jtxtdate.getText(),jtxtstime.getText(),jtxtetime.getText(),jtxtmodule.getText(),jtxtintake.getText()); 
       jtxtdate.setText("");
       jtxtstime.setText("");
       jtxtetime.setText("");
       jtxtmodule.setText("");
       jtxtintake.setText("");
    }//GEN-LAST:event_jbtncreatclasstimeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIclasstime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIclasstime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIclasstime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIclasstime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIclasstime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserPanel dateChooserPanel1;
    private datechooser.beans.DateChooserPanel dateChooserPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtncreatclasstime;
    public static javax.swing.JTextField jtxtdate;
    public javax.swing.JTextField jtxtetime;
    public javax.swing.JTextField jtxtintake;
    public javax.swing.JTextField jtxtmodule;
    public javax.swing.JTextField jtxtstime;
    private datechooser.demo.steps.Show1Components show1Components1;
    private datechooser.demo.steps.Show2Swing show2Swing1;
    // End of variables declaration//GEN-END:variables
}

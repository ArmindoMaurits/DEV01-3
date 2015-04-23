package opdracht4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Wouter on 4/20/2015.
 */
public class Scherm extends JFrame{
        /**
         * Creates new form NewJFrame
         */
        public Scherm() {
            initComponents();
        }
        private void initComponents() {

            numerator1 = new javax.swing.JTextField();
            denumerator1 = new javax.swing.JTextField();
            jSeparator1 = new javax.swing.JSeparator();
            selectie = new javax.swing.JComboBox();
            numerator2 = new javax.swing.JTextField();
            denumerator2 = new javax.swing.JTextField();
            helen = new javax.swing.JLabel();
            numerator3 = new javax.swing.JLabel();
            denumerator3 = new javax.swing.JLabel();
            jSeparator2 = new javax.swing.JSeparator();
            jSeparator3 = new javax.swing.JSeparator();
            equalsbutton = new javax.swing.JToggleButton();
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            numerator1.setText("INPUT");
            denumerator1.setText("INPUT");

            selectie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "+", "-", "*", "/" }));


            numerator2.setText("INPUT");

            denumerator2.setText("INPUT");

            helen.setText("");

            numerator3.setText("");
            numerator3.setVisible(false);

            denumerator3.setText("");
            denumerator3.setVisible(false);

            jSeparator3.setVisible(false);

            equalsbutton.setText("=");
            equalsbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String currselectie = (String)selectie.getSelectedItem();
                    int[] returnvalues = new int[3];
                    try {
                        if(currselectie == "+"){
                            returnvalues = Operator.add(Integer.parseInt(numerator1.getText()), Integer.parseInt(denumerator1.getText()), Integer.parseInt(numerator2.getText()), Integer.parseInt(denumerator2.getText()));
                        }else if(currselectie == "-"){
                            returnvalues =Operator.extract(Integer.parseInt(numerator1.getText()),Integer.parseInt(denumerator1.getText()),Integer.parseInt(numerator2.getText()),Integer.parseInt(denumerator2.getText()));
                        }else if(currselectie == "*"){
                            returnvalues =Operator.mutiply(Integer.parseInt(numerator1.getText()),Integer.parseInt(denumerator1.getText()),Integer.parseInt(numerator2.getText()),Integer.parseInt(denumerator2.getText()));
                        }else if(currselectie == "/"){
                            returnvalues =Operator.divide(Integer.parseInt(numerator1.getText()),Integer.parseInt(denumerator1.getText()),Integer.parseInt(numerator2.getText()),Integer.parseInt(denumerator2.getText()));
                        }
                    }catch (ArithmeticException ex){
                        JDialog dialog = new JDialog();
                        dialog.add(new JLabel("Cannot devide by zero"));
                        dialog.setSize(200, 100);
                        dialog.setVisible(true);
                        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    }
                    helen.setVisible(true);
                    numerator3.setVisible(true);
                    denumerator3.setVisible(true);
                    jSeparator3.setVisible(true);
                    if(returnvalues[0] < 0){
                        if(returnvalues[2] != 0){
                            returnvalues[0] = returnvalues[0]*-1;
                        }else{
                            helen.setVisible(false);
                        }
                    }
                    numerator3.setText(returnvalues[0]+"");
                    denumerator3.setText(returnvalues[1]+ "");
                    helen.setText(returnvalues[2]+"");
                    if(returnvalues[0] == 0 ){
                        numerator3.setVisible(false);
                        denumerator3.setVisible(false);
                        jSeparator3.setVisible(false);
                    }
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(denumerator1)
                                            .addComponent(jSeparator1)
                                            .addComponent(numerator1))
                                    .addGap(27, 27, 27)
                                    .addComponent(selectie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(denumerator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(65, 65, 65)
                                                                    .addComponent(equalsbutton)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                                    .addComponent(helen))
                                            .addComponent(numerator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(denumerator3)
                                            .addComponent(numerator3))
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(92, 92, 92)
                                                    .addComponent(selectie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(numerator3)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(denumerator3))
                                    .addContainerGap(168, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(76, 76, 76)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(numerator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(numerator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(helen)
                                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(equalsbutton))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(denumerator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(denumerator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }


        public static void main(String args[]) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Scherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Scherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Scherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Scherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Scherm().setVisible(true);
                }
            });
        }

    private javax.swing.JTextField denumerator1;
        private javax.swing.JTextField denumerator2;
        private javax.swing.JLabel denumerator3;
        private javax.swing.JToggleButton equalsbutton;
        private javax.swing.JLabel helen;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JSeparator jSeparator2;
        private javax.swing.JSeparator jSeparator3;
        private javax.swing.JTextField numerator1;
        private javax.swing.JTextField numerator2;
        private javax.swing.JLabel numerator3;
        private javax.swing.JComboBox selectie;


}

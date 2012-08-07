/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui.frames;

import java.io.File;
import javax.swing.JFileChooser;
import org.jboss.rusheye.manager.gui.view.mask.MaskCase;
import org.jboss.rusheye.manager.gui.view.mask.converters.MaskConverter;
import org.jboss.rusheye.manager.gui.view.mask.converters.MaskToImageConverter;
import org.jboss.rusheye.manager.utils.FileChooserUtils;

/**
 *
 * @author hcube
 */
public class MaskAdder extends javax.swing.JFrame {

    private MaskCase node;
    /**
     * Creates new form MaskAdder
     */
    public MaskAdder(MaskCase mc) {
        initComponents();
        node = mc;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        alphaRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        topRadioButton = new javax.swing.JRadioButton();
        bottomRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        leftRadioButton = new javax.swing.JRadioButton();
        rightRadioButton = new javax.swing.JRadioButton();
        noneHRadioButton = new javax.swing.JRadioButton();
        noneVRadioButton = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonGroup1.add(alphaRadioButton);
        alphaRadioButton.setSelected(true);
        alphaRadioButton.setText("Selective alpha");

        jLabel1.setText("Mask type :");

        jLabel2.setText("Vertical align. :");

        buttonGroup2.add(topRadioButton);
        topRadioButton.setText("Top");

        buttonGroup2.add(bottomRadioButton);
        bottomRadioButton.setText("Bottom");

        jLabel3.setText("Horizontal align. :");

        buttonGroup3.add(leftRadioButton);
        leftRadioButton.setText("Left");

        buttonGroup3.add(rightRadioButton);
        rightRadioButton.setText("Right");

        buttonGroup3.add(noneHRadioButton);
        noneHRadioButton.setSelected(true);
        noneHRadioButton.setText("None");

        buttonGroup2.add(noneVRadioButton);
        noneVRadioButton.setSelected(true);
        noneVRadioButton.setText("None");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(leftRadioButton)
                                    .addComponent(rightRadioButton)
                                    .addComponent(noneHRadioButton))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alphaRadioButton)
                                    .addComponent(topRadioButton)
                                    .addComponent(bottomRadioButton)
                                    .addComponent(noneVRadioButton))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alphaRadioButton)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(topRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noneVRadioButton)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(leftRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noneHRadioButton)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fc = FileChooserUtils.saveChooser();

        int returnVal = fc.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            MaskConverter converter = new MaskToImageConverter(node);
            converter.save(file);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton alphaRadioButton;
    private javax.swing.JRadioButton bottomRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton leftRadioButton;
    private javax.swing.JRadioButton noneHRadioButton;
    private javax.swing.JRadioButton noneVRadioButton;
    private javax.swing.JRadioButton rightRadioButton;
    private javax.swing.JRadioButton topRadioButton;
    // End of variables declaration//GEN-END:variables
}

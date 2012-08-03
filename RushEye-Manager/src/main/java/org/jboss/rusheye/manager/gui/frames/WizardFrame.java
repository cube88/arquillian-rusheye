/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui.frames;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jboss.rusheye.manager.Main;
import org.jboss.rusheye.manager.project.Project;
import org.jboss.rusheye.manager.utils.FileChooserUtils;

/**
 *
 * @author hcube
 */
public class WizardFrame extends javax.swing.JFrame {

    /**
     * Creates new form WizardFrame
     */
    public WizardFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        suiteField = new javax.swing.JTextField();
        suiteButton = new javax.swing.JButton();
        patternsField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        patternsButton = new javax.swing.JButton();
        samplesField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        samplesButton = new javax.swing.JButton();
        masksField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        masksButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Load suite");

        jLabel1.setText("Suite :");

        suiteButton.setText("Set");
        suiteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suiteButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Patterns :");

        patternsButton.setText("Set");
        patternsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patternsButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Samples :");

        samplesButton.setText("Set");
        samplesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                samplesButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Masks :");

        masksButton.setText("Set");
        masksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masksButtonActionPerformed(evt);
            }
        });

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
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
                        .addComponent(suiteField)
                        .addGap(18, 18, 18)
                        .addComponent(suiteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(patternsField, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(patternsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(samplesField, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(samplesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(masksField, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(masksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suiteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suiteButton))
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patternsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patternsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(samplesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(samplesButton))
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(masksField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(masksButton))
                .addGap(18, 18, 18)
                .addComponent(loadButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void suiteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suiteButtonActionPerformed
        JFileChooser fc = FileChooserUtils.fileChooser();
        File tmp = FileChooserUtils.chooseFile(fc, this);
        if (tmp != null) {
            suiteField.setText(tmp.getAbsolutePath());
        }
    }//GEN-LAST:event_suiteButtonActionPerformed

    private void patternsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patternsButtonActionPerformed
        File dir = FileChooserUtils.openDir("Open Patterns Dir", this);
        if (dir != null) {
            patternsField.setText(dir.getAbsolutePath());
        }
    }//GEN-LAST:event_patternsButtonActionPerformed

    private void samplesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_samplesButtonActionPerformed
        File dir = FileChooserUtils.openDir("Open Samples Dir", this);
        if (dir != null) {
            samplesField.setText(dir.getAbsolutePath());
        }
    }//GEN-LAST:event_samplesButtonActionPerformed

    private void masksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masksButtonActionPerformed
        File dir = FileChooserUtils.openDir("Open Masks Dir", this);
        if (dir != null) {
            masksField.setText(dir.getAbsolutePath());
        }
    }//GEN-LAST:event_masksButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        if (suiteField.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No suite selected", "Crawl", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Main.mainProject = Project.projectFromDescriptor(suiteField.getText());
        Main.mainProject.setPatternPath(patternsField.getText());
        Main.mainProject.setSamplesPath(samplesField.getText());
        Main.mainProject.setMaskPath(masksField.getText());
        
        Main.projectFrame.createTree();
        Main.interfaceFrame.clean();
        
        Main.mainProject.updateFrames();
        
        this.dispose();
    }//GEN-LAST:event_loadButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton masksButton;
    private javax.swing.JTextField masksField;
    private javax.swing.JButton patternsButton;
    private javax.swing.JTextField patternsField;
    private javax.swing.JButton samplesButton;
    private javax.swing.JTextField samplesField;
    private javax.swing.JButton suiteButton;
    private javax.swing.JTextField suiteField;
    // End of variables declaration//GEN-END:variables
}

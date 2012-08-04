/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui.frames;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import org.jboss.rusheye.manager.Main;
import org.jboss.rusheye.manager.utils.FileChooserUtils;

/**
 * RushEye Manager Main Frame. One of 2 main frames for manager. Here we display
 * images.
 *
 * @author Jakub D.
 */
public class InterfaceFrame extends javax.swing.JFrame {

    public static final int SINGLE = 1;
    public static final int DOUBLE = 2;
    public static final int MASK = 3;
    private int view = InterfaceFrame.DOUBLE;
    private ProjectManagerFrame projectFrame;
    private StatisticsFrame statFrame;

    /**
     * Creates new form InterfaceFrame
     */
    public InterfaceFrame() {
        initComponents();
        this.setVisible(true);

        projectFrame = new ProjectManagerFrame();
        projectFrame.setVisible(true);

        statFrame = new StatisticsFrame();
        statFrame.setVisible(false);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    /**
     * Clears panel when we open new project.
     */
    public void clean() {
        mainPanel.removeAll();
        mainPanel.validate();
    }

    /**
     * Opens JFileChooser and allows to set path for patterns in project.
     *
     * @return File reference returned by JFileCHooser
     */
    public File setPatternsAction() {
        File dir = FileChooserUtils.openDir("Open Pattern Dir", this);
        if (dir != null) {
            Main.mainProject.setPatternPath(dir.getAbsolutePath());

            Main.mainProject.getRoot().removeDiffRecursive();
            projectFrame.putTestIntoView();
        }
        return dir;
    }

    /**
     * Opens JFileChooser and allows to set path for samples in project.
     *
     * @return File reference returned by JFileCHooser
     */
    public File setSamplesAction() {
        File dir = FileChooserUtils.openDir("Open Samples Dir", this);
        if (dir != null) {
            Main.mainProject.setSamplesPath(dir.getAbsolutePath());

            Main.mainProject.getRoot().removeDiffRecursive();
            projectFrame.putTestIntoView();
        }
        return dir;
    }

    public File setMasksAction() {
        File dir = FileChooserUtils.openDir("Open Mask Dir", this);
        if (dir != null) {
            Main.mainProject.setMaskPath(dir.getAbsolutePath());

            Main.mainProject.getRoot().removeDiffRecursive();
            projectFrame.putTestIntoView();
        }
        return dir;
    }

    public ProjectManagerFrame getProjectFrame() {
        return projectFrame;
    }

    public StatisticsFrame getStatFrame() {
        return statFrame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        emptyProjectMenuItem = new javax.swing.JMenuItem();
        descriptorProjectMenuItem = new javax.swing.JMenuItem();
        projectMenu = new javax.swing.JMenu();
        statisticsMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        patternsPathMenuItem = new javax.swing.JMenuItem();
        samplesPathMenuItem = new javax.swing.JMenuItem();
        masksPathMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        resultSaveMenuItem = new javax.swing.JMenuItem();
        resultLoadMenuItem = new javax.swing.JMenuItem();
        viewsMenu = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        doubleViewMenuItem = new javax.swing.JMenuItem();
        singleViewMenuItem = new javax.swing.JMenuItem();
        maskViewMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RushEye  - Manager");

        mainPanel.setLayout(new java.awt.BorderLayout());

        fileMenu.setText("File");

        emptyProjectMenuItem.setText("Generate suite");
        emptyProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptyProjectMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(emptyProjectMenuItem);

        descriptorProjectMenuItem.setText("Open suite");
        descriptorProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptorProjectMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(descriptorProjectMenuItem);

        menuBar.add(fileMenu);

        projectMenu.setText("Project");

        statisticsMenuItem.setText("Statistics");
        statisticsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsMenuItemActionPerformed(evt);
            }
        });
        projectMenu.add(statisticsMenuItem);
        projectMenu.add(jSeparator2);

        patternsPathMenuItem.setText("Set patterns path");
        patternsPathMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patternsPathMenuItemActionPerformed(evt);
            }
        });
        projectMenu.add(patternsPathMenuItem);

        samplesPathMenuItem.setText("Set samples path");
        samplesPathMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                samplesPathMenuItemActionPerformed(evt);
            }
        });
        projectMenu.add(samplesPathMenuItem);

        masksPathMenuItem.setText("Set masks path");
        masksPathMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masksPathMenuItemActionPerformed(evt);
            }
        });
        projectMenu.add(masksPathMenuItem);
        projectMenu.add(jSeparator1);

        resultSaveMenuItem.setText("Save result descriptor");
        resultSaveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultSaveMenuItemActionPerformed(evt);
            }
        });
        projectMenu.add(resultSaveMenuItem);

        resultLoadMenuItem.setText("Load result descriptor");
        resultLoadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultLoadMenuItemActionPerformed(evt);
            }
        });
        projectMenu.add(resultLoadMenuItem);

        menuBar.add(projectMenu);

        viewsMenu.setText("Views");

        jMenuItem3.setText("Project Manager");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        viewsMenu.add(jMenuItem3);
        viewsMenu.add(jSeparator3);

        doubleViewMenuItem.setText("Double View");
        doubleViewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleViewMenuItemActionPerformed(evt);
            }
        });
        viewsMenu.add(doubleViewMenuItem);

        singleViewMenuItem.setText("Single View");
        singleViewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleViewMenuItemActionPerformed(evt);
            }
        });
        viewsMenu.add(singleViewMenuItem);

        maskViewMenuItem.setText("Masks View");
        maskViewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maskViewMenuItemActionPerformed(evt);
            }
        });
        viewsMenu.add(maskViewMenuItem);

        menuBar.add(viewsMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void samplesPathMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_samplesPathMenuItemActionPerformed
        setSamplesAction();
    }//GEN-LAST:event_samplesPathMenuItemActionPerformed

    private void patternsPathMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patternsPathMenuItemActionPerformed
        setPatternsAction();
    }//GEN-LAST:event_patternsPathMenuItemActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        projectFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * Changes view to double view.
     *
     * @param evt event triggering method
     */
    private void doubleViewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleViewMenuItemActionPerformed
        view = InterfaceFrame.DOUBLE;
        projectFrame.putTestIntoView();
    }//GEN-LAST:event_doubleViewMenuItemActionPerformed
    /**
     * Changes view to single view.
     *
     * @param evt event triggering method
     */
    private void singleViewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleViewMenuItemActionPerformed
        view = InterfaceFrame.SINGLE;
        projectFrame.putTestIntoView();
    }//GEN-LAST:event_singleViewMenuItemActionPerformed

    /**
     * Opens project using descriptor xml file.
     *
     * @param evt event triggering method
     */
    private void descriptorProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptorProjectMenuItemActionPerformed
        WizardFrame wizardFrame = new WizardFrame();
        wizardFrame.setVisible(true);
    }//GEN-LAST:event_descriptorProjectMenuItemActionPerformed
    /**
     * Opens empty project.
     *
     * @param evt event triggering method
     */
    private void emptyProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptyProjectMenuItemActionPerformed
        CrawlFrame crawlFrame = new CrawlFrame();
        crawlFrame.setVisible(true);
    }//GEN-LAST:event_emptyProjectMenuItemActionPerformed
    /**
     * Opens result descriptor xml, so that we can modify it using tree.
     *
     * @param evt event triggering method
     */
    private void resultLoadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultLoadMenuItemActionPerformed
        JFileChooser fc = FileChooserUtils.fileChooser();
        File tmp = FileChooserUtils.chooseFile(fc, this);
        if (tmp != null) {
            Main.mainProject.setResultDescriptor(tmp);
            Main.mainProject.loadResultAsString();
        }
    }//GEN-LAST:event_resultLoadMenuItemActionPerformed

    private void maskViewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maskViewMenuItemActionPerformed
        view = InterfaceFrame.MASK;
        projectFrame.putTestIntoView();
        projectFrame.createMaskTree();
    }//GEN-LAST:event_maskViewMenuItemActionPerformed

    private void statisticsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsMenuItemActionPerformed
        statFrame.setVisible(true);
    }//GEN-LAST:event_statisticsMenuItemActionPerformed

    private void masksPathMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masksPathMenuItemActionPerformed
        setMasksAction();
    }//GEN-LAST:event_masksPathMenuItemActionPerformed

    private void resultSaveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultSaveMenuItemActionPerformed
        JFileChooser fc = FileChooserUtils.saveChooser();

        int returnVal = fc.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            FileChannel source = null;
            FileChannel destination = null;

            try {
                source = new FileInputStream(new File("result.xml")).getChannel();
                destination = new FileOutputStream(file).getChannel();
                destination.transferFrom(source, 0, source.size());
                if (source != null) {
                    source.close();
                }
                if (destination != null) {
                    destination.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_resultSaveMenuItemActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem descriptorProjectMenuItem;
    private javax.swing.JMenuItem doubleViewMenuItem;
    private javax.swing.JMenuItem emptyProjectMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem maskViewMenuItem;
    private javax.swing.JMenuItem masksPathMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem patternsPathMenuItem;
    private javax.swing.JMenu projectMenu;
    private javax.swing.JMenuItem resultLoadMenuItem;
    private javax.swing.JMenuItem resultSaveMenuItem;
    private javax.swing.JMenuItem samplesPathMenuItem;
    private javax.swing.JMenuItem singleViewMenuItem;
    private javax.swing.JMenuItem statisticsMenuItem;
    private javax.swing.JMenu viewsMenu;
    // End of variables declaration//GEN-END:variables
}

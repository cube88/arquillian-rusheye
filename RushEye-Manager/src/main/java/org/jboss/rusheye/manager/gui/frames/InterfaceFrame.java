/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui.frames;

import org.jboss.rusheye.manager.gui.frames.CrawlFrame;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import org.jboss.rusheye.manager.Main;
import org.jboss.rusheye.manager.gui.view.MenuView;
import org.jboss.rusheye.manager.project.Project;
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
    private MenuView menuView;

    /**
     * Creates new form InterfaceFrame
     */
    public InterfaceFrame() {
        initComponents();

        this.validate();
    }

    @Deprecated
    public void setMenu() {
        menuView = new MenuView();
        Main.mainProject.addObserver(menuView);
        mainPanel.removeAll();
        mainPanel.add(menuView);
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
     * Clears text fields an panel when we open new project.
     */
    public void clean() {
        Main.projectFrame.getPatternsPathField().setText("path...");
        Main.projectFrame.getSamplesPathField().setText("path...");
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
            Main.projectFrame.getPatternsPathField().setText(dir.getAbsolutePath());

            Main.mainProject.getRoot().removeDiffRecursive();
            Main.projectFrame.putTestIntoView();
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
            Main.projectFrame.getSamplesPathField().setText(dir.getAbsolutePath());

            Main.mainProject.getRoot().removeDiffRecursive();
            Main.projectFrame.putTestIntoView();
        }
        return dir;
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
        dirProjectMenuItem = new javax.swing.JMenuItem();
        projectMenu = new javax.swing.JMenu();
        suiteGenMenuItem = new javax.swing.JMenuItem();
        resultGenMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        patternsPathMenuItem = new javax.swing.JMenuItem();
        samplesPathMenuItem = new javax.swing.JMenuItem();
        resultMenuItem = new javax.swing.JMenuItem();
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

        emptyProjectMenuItem.setText("New empty project");
        emptyProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptyProjectMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(emptyProjectMenuItem);

        descriptorProjectMenuItem.setText("New project from descriptor");
        descriptorProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptorProjectMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(descriptorProjectMenuItem);

        dirProjectMenuItem.setText("New project from directories");
        dirProjectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirProjectMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(dirProjectMenuItem);

        menuBar.add(fileMenu);

        projectMenu.setText("Project");

        suiteGenMenuItem.setText("Generate Suite Descriptor");
        suiteGenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suiteGenMenuItemActionPerformed(evt);
            }
        });
        projectMenu.add(suiteGenMenuItem);

        resultGenMenuItem.setText("Generate Result Descriptor");
        resultGenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultGenMenuItemActionPerformed(evt);
            }
        });
        projectMenu.add(resultGenMenuItem);
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

        resultMenuItem.setText("Set result descriptor");
        resultMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultMenuItemActionPerformed(evt);
            }
        });
        projectMenu.add(resultMenuItem);

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
        Main.projectFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    /**
     * Opens project using 2 directories.
     *
     * @param evt event triggering method
     */
    private void dirProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirProjectMenuItemActionPerformed
        JFileChooser fc = FileChooserUtils.dirChooser();
        fc.setDialogTitle("Open Pattern Dir");
        String path1 = FileChooserUtils.chooseFile(fc, this).getAbsolutePath();
        fc.setDialogTitle("Open Samples Dir");
        String path2 = FileChooserUtils.chooseFile(fc, this).getAbsolutePath();
        if (path1 != null && path2 != null) {
            Main.mainProject = Project.projectFromDirs(path1, path2);
            Main.projectFrame.getPatternsPathField().setText(path1);
            Main.projectFrame.getSamplesPathField().setText(path2);
            Main.projectFrame.createTree();
        }
        clean();
    }//GEN-LAST:event_dirProjectMenuItemActionPerformed
    /**
     * Changes view to double view.
     *
     * @param evt event triggering method
     */
    private void doubleViewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleViewMenuItemActionPerformed
        view = InterfaceFrame.DOUBLE;
        Main.projectFrame.putTestIntoView();
    }//GEN-LAST:event_doubleViewMenuItemActionPerformed
    /**
     * Changes view to single view.
     *
     * @param evt event triggering method
     */
    private void singleViewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleViewMenuItemActionPerformed
        view = InterfaceFrame.SINGLE;
        Main.projectFrame.putTestIntoView();
    }//GEN-LAST:event_singleViewMenuItemActionPerformed
    /**
     * Opens Crawl Frame
     *
     * @param evt event triggering method
     */
    private void suiteGenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suiteGenMenuItemActionPerformed
        CrawlFrame crawlFrame = new CrawlFrame();
        crawlFrame.setVisible(true);
    }//GEN-LAST:event_suiteGenMenuItemActionPerformed
    /**
     * Opens Parse Frame
     *
     * @param evt event triggering method
     */
    private void resultGenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultGenMenuItemActionPerformed
        ParseFrame parseFrame = new ParseFrame();
        parseFrame.setVisible(true);
    }//GEN-LAST:event_resultGenMenuItemActionPerformed
    /**
     * Opens project using descriptor xml file.
     *
     * @param evt event triggering method
     */
    private void descriptorProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptorProjectMenuItemActionPerformed
        JFileChooser fc = FileChooserUtils.fileChooser();
        File tmp = FileChooserUtils.chooseFile(fc, this);
        if (tmp != null) {
            Main.mainProject = Project.projectFromDescriptor(tmp);
            Main.projectFrame.createTree();
            clean();
        }
    }//GEN-LAST:event_descriptorProjectMenuItemActionPerformed
    /**
     * Opens empty project.
     *
     * @param evt event triggering method
     */
    private void emptyProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptyProjectMenuItemActionPerformed
        Main.mainProject = Project.emptyProject();
    }//GEN-LAST:event_emptyProjectMenuItemActionPerformed
    /**
     * Opens result descriptor xml, so that we can modify it using tree.
     *
     * @param evt event triggering method
     */
    private void resultMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultMenuItemActionPerformed
        JFileChooser fc = FileChooserUtils.fileChooser();
        File tmp = FileChooserUtils.chooseFile(fc, this);
        if (tmp != null){
            Main.mainProject.setResultDescriptor(tmp);
            Main.mainProject.loadResultAsString();
        }
    }//GEN-LAST:event_resultMenuItemActionPerformed

    private void maskViewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maskViewMenuItemActionPerformed
        view = InterfaceFrame.MASK;
        Main.projectFrame.putTestIntoView();
        Main.maskFrame.createTree();
    }//GEN-LAST:event_maskViewMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem descriptorProjectMenuItem;
    private javax.swing.JMenuItem dirProjectMenuItem;
    private javax.swing.JMenuItem doubleViewMenuItem;
    private javax.swing.JMenuItem emptyProjectMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem maskViewMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem patternsPathMenuItem;
    private javax.swing.JMenu projectMenu;
    private javax.swing.JMenuItem resultGenMenuItem;
    private javax.swing.JMenuItem resultMenuItem;
    private javax.swing.JMenuItem samplesPathMenuItem;
    private javax.swing.JMenuItem singleViewMenuItem;
    private javax.swing.JMenuItem suiteGenMenuItem;
    private javax.swing.JMenu viewsMenu;
    // End of variables declaration//GEN-END:variables
}
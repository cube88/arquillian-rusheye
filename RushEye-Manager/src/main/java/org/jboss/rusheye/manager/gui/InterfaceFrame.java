/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import org.jboss.rusheye.CommandCrawl;
import org.jboss.rusheye.manager.Main;
import org.jboss.rusheye.manager.exception.ManagerException;
import org.jboss.rusheye.manager.project.ProjectFactory;
import org.jboss.rusheye.manager.project.Test;
import org.jboss.rusheye.manager.project.TestCase;

/**
 *
 * @author hcube
 */
public class InterfaceFrame extends javax.swing.JFrame {

    public static final int SINGLE = 1;
    public static final int DOUBLE = 2;
    public static final int CONSOLE = 3;
    private int view = InterfaceFrame.DOUBLE;
    private JFileChooser fc;

    /**
     * Creates new form InterfaceFrame
     */
    public InterfaceFrame() {
        initFileChooser();
        initComponents();

        this.validate();
    }

    private void initFileChooser() {
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);
        fc.setCurrentDirectory(new java.io.File("."));
    }

    private String choosePath() {
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            return file.getAbsolutePath();
        }
        return null;
    }

    private void createTree() {
        try {
            Main.mainProject.parseDirs();
            Main.projectFrame.setVisible(true);
            JTree tree = Main.projectFrame.getTree();

            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Test cases");
            for (TestCase current : Main.mainProject.getCases()) {
                DefaultMutableTreeNode caseNode = new DefaultMutableTreeNode(current.getCaseName());
                for (Test test : current.getTests()) {
                    DefaultMutableTreeNode testNode = new DefaultMutableTreeNode(test.getName());
                    caseNode.add(testNode);
                }
                root.add(caseNode);
            }

            DefaultTreeModel model = new DefaultTreeModel(root);
            tree.setModel(model);
            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

            Main.projectFrame.validate();

        } catch (ManagerException ex) {
            ex.printStackTrace();
        }
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RushEye  - Manager");

        mainPanel.setLayout(new java.awt.BorderLayout());

        jMenu6.setText("File");

        jMenu1.setText("New Project");

        jMenuItem4.setText("Empty Project");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Project From Directories");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Project From Descriptor");
        jMenu1.add(jMenuItem6);

        jMenu6.add(jMenu1);
        jMenu6.add(jSeparator4);

        jMenuItem17.setText("Preferences");
        jMenu6.add(jMenuItem17);

        jMenuItem16.setText("Save console output");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem16);
        jMenu6.add(jSeparator6);

        jMenuItem8.setText("Exit");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuBar1.add(jMenu6);

        jMenu2.setText("Project");

        jMenu5.setText("Sources");

        jMenuItem1.setText("Set patterns path");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem2.setText("Set samples path");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);
        jMenu5.add(jSeparator5);

        jMenuItem7.setText("Parse directories");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenu2.add(jMenu5);
        jMenu2.add(jSeparator1);

        jMenuItem12.setText("Test all");
        jMenu2.add(jMenuItem12);
        jMenu2.add(jSeparator2);

        jMenuItem14.setText("Generate Suite Descriptor");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuItem13.setText("Generate Result Descriptor");
        jMenu2.add(jMenuItem13);

        jMenuItem15.setText("Console");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Menu");

        jMenuItem3.setText("Project Manager");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);
        jMenu3.add(jSeparator3);

        jMenuItem11.setText("Single View Menu");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Views");

        jMenuItem9.setText("Double View");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("Single View");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

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

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (evt.getSource() == jMenuItem2) {
            fc.setDialogTitle("Open Samples Dir");
            String path = choosePath();
            if (path != null) {
                Main.mainProject.setSamplesPath(path);
                Main.projectFrame.getSamplesPathField().setText(path);
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (evt.getSource() == jMenuItem1) {
            fc.setDialogTitle("Open Pattern Dir");
            String path = choosePath();
            if (path != null) {
                Main.mainProject.setPatternPath(path);
                Main.projectFrame.getPatternsPathField().setText(path);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Main.projectFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Main.mainProject = ProjectFactory.emptyProject();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if (evt.getSource() == jMenuItem5) {
            fc.setDialogTitle("Open Pattern Dir");
            String path1 = choosePath();
            fc.setDialogTitle("Open Samples Dir");
            String path2 = choosePath();
            if (path1 != null && path2 != null) {
                Main.mainProject = ProjectFactory.projectFromDirs(path1, path2);
                if (Main.projectFrame == null) {
                    System.out.println("To frame");
                }
                Main.projectFrame.getPatternsPathField().setText(path1);
                Main.projectFrame.getSamplesPathField().setText(path2);
                createTree();
            }
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        createTree();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        view = InterfaceFrame.DOUBLE;
        Main.projectFrame.putTestIntoView();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        view = InterfaceFrame.SINGLE;
        Main.projectFrame.putTestIntoView();
        Main.singleFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Main.singleFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        this.setView(InterfaceFrame.CONSOLE);
        this.getMainPanel().removeAll();
        this.getMainPanel().add(Main.console);
        this.validate();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        JFileChooser fc2 = new JFileChooser();
        fc2.setCurrentDirectory(new java.io.File("."));

        int returnVal = fc2.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc2.getSelectedFile();
            System.out.println(file.getAbsolutePath());
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                out.write(Main.console.getConsoleArea().getText());
                out.close();
            } catch (Exception e) {
                System.out.println("Can not save Manager Console output to file");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        CommandCrawl crawl = new CommandCrawl();
        List<File> tmp = new ArrayList<File>();
        tmp.add(new File(Main.mainProject.getPatternPath()));
        crawl.setFiles(tmp);
        crawl.initialize();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        crawl.crawl(stream);
        Main.console.getConsoleArea().setText(stream.toString());
        this.setView(InterfaceFrame.CONSOLE);
        this.getMainPanel().removeAll();
        this.getMainPanel().add(Main.console);
        this.validate();
    }//GEN-LAST:event_jMenuItem14ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}

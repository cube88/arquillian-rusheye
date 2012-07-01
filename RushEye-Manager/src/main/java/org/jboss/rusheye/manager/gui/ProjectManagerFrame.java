/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.*;
import org.jboss.rusheye.manager.Main;
import org.jboss.rusheye.manager.exception.ManagerException;
import org.jboss.rusheye.manager.gui.view.DoubleView;
import org.jboss.rusheye.manager.gui.view.SingleView;
import org.jboss.rusheye.manager.project.LoadType;
import org.jboss.rusheye.manager.project.NodeList;
import org.jboss.rusheye.manager.project.TestCase;
import org.jboss.rusheye.manager.project.TestNode;
import org.jboss.rusheye.suite.ResultConclusion;

/**
 *
 * @author hcube
 */
public class ProjectManagerFrame extends javax.swing.JFrame {

    public static final int SHOW_ALL = 0;
    public static final int NOT_TESTED = 1;
    public static final int DIFF = 2;
    private int filter = 0;

    public ProjectManagerFrame() {
        initComponents();

        projectTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent tse) {
                putTestIntoView();
                if (Main.mainProject.getCurrentCase() != null && Main.mainProject.getCurrentCase().isLeaf()) {
                    jLabel4.setText(((TestCase) Main.mainProject.getCurrentCase().getParent()).getName());
                    jLabel5.setText(Main.mainProject.getCurrentCase().getName());
                    jLabel6.setText(Main.mainProject.getCurrentCase().getConclusion().toString());
                }
            }
        });
    }

    public javax.swing.JTextField getPatternsPathField() {
        return patternsPathField;
    }

    public javax.swing.JTextField getSamplesPathField() {
        return samplesPathField;
    }

    public JTree getTree() {
        return projectTree;
    }

    public void createTree() {
        Main.projectFrame.setVisible(true);

        projectTree.setCellRenderer(new CustomTreeRenderer());

        updateTreeModel();
    }

    public void updateTreeModel() {
        DefaultTreeModel model = new DefaultTreeModel(Main.mainProject.getRoot());
        projectTree.setModel(model);
        projectTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        Main.projectFrame.validate();
    }

    public void putTestIntoView() {
        TestCase node = (TestCase) projectTree.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }

        if (node.isLeaf()) {
            System.out.println(node.getPath());
            System.out.println(Main.mainProject.findTest(node.getPath()));
            Main.mainProject.setCurrentCase(Main.mainProject.findTest(node.getPath()));
            System.out.println(Main.mainProject.getCurrentCase().getName());

            JPanel panel = Main.interfaceFrame.getMainPanel();
            panel.removeAll();

            TestCase current = Main.mainProject.getCurrentCase();

            switch (Main.interfaceFrame.getView()) {
                case InterfaceFrame.SINGLE:
                    panel.add(new SingleView(current));
                    break;
                case InterfaceFrame.DOUBLE:
                    panel.add(new DoubleView(current));
                    break;
                case InterfaceFrame.CONSOLE:
                    panel.add(Main.console);
                default:
                    panel.add(new JPanel());
                    break;
            }

            panel.validate();
        }
    }

    private void updateIcons() {
        jLabel6.setText(Main.mainProject.getCurrentCase().getConclusion().toString());
        Main.mainProject.getCurrentCase().setChecked(true);
        TreePath path = projectTree.getSelectionPath();
        this.updateTreeModel();
        projectTree.setSelectionPath(path);
        projectTree.scrollPathToVisible(path);
    }

    private void findNeighbour(int offset) {
        TestNode node = (TestNode) projectTree.getLastSelectedPathComponent();
        TreePath parentPath = projectTree.getSelectionPath().getParentPath();

        NodeList list = (NodeList) node.getParent().children();
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).equals(node)) {
                if (i < list.size() - 1) {
                    projectTree.setSelectionPath(parentPath.pathByAddingChild(list.get(i + offset)));
                    break;
                }
            }
        }
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
        patternsPathField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        samplesPathField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        projectTree = new javax.swing.JTree();
        posButton = new javax.swing.JButton();
        negButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setTitle("ProjectManager");

        jLabel1.setText("Patterns :");

        patternsPathField.setText("path...");
        patternsPathField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        patternsPathField.setEnabled(false);

        jLabel2.setText("Samples :");

        samplesPathField.setBackground(new java.awt.Color(255, 255, 255));
        samplesPathField.setText("path...");
        samplesPathField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        samplesPathField.setEnabled(false);

        jLabel3.setText("Test cases :");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Test Cases");
        projectTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(projectTree);

        posButton.setText("Positive");
        posButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posButtonActionPerformed(evt);
            }
        });

        negButton.setText("Negative");
        negButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("      ");

        jLabel5.setText("     ");

        jLabel6.setText("     ");

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        prevButton.setText("Previous");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("Filters");

        jMenuItem1.setText("Show all");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Show not tested");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Show diff");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(252, 252, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(patternsPathField)
                            .addComponent(samplesPathField)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(posButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(negButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(patternsPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(samplesPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posButton)
                    .addComponent(negButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(prevButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void posButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posButtonActionPerformed
        Main.mainProject.getCurrentCase().setConclusion(ResultConclusion.PERCEPTUALLY_SAME);
        updateIcons();
    }//GEN-LAST:event_posButtonActionPerformed

    private void negButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negButtonActionPerformed
        Main.mainProject.getCurrentCase().setConclusion(ResultConclusion.DIFFER);
        updateIcons();
    }//GEN-LAST:event_negButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        filter = ProjectManagerFrame.SHOW_ALL;

        TestCase root = Main.mainProject.getRoot();
        root.setAllVisible();
        this.updateTreeModel();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        filter = ProjectManagerFrame.NOT_TESTED;

        TestCase root = Main.mainProject.getRoot();
        root.setVisibility(ResultConclusion.NOT_TESTED);
        this.updateTreeModel();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        filter = ProjectManagerFrame.DIFF;

        TestCase root = Main.mainProject.getRoot();
        root.setVisibility(ResultConclusion.DIFFER);
        this.updateTreeModel();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        findNeighbour(1);
    }//GEN-LAST:event_nextButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        findNeighbour(-1);
    }//GEN-LAST:event_prevButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton negButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField patternsPathField;
    private javax.swing.JButton posButton;
    private javax.swing.JButton prevButton;
    private javax.swing.JTree projectTree;
    private javax.swing.JTextField samplesPathField;
    // End of variables declaration//GEN-END:variables
}

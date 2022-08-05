/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.bolton.oom.view.panel;

import uk.bolton.oom.controller.ChannelController;
import uk.bolton.oom.factory.ControllerFactory;
import uk.bolton.oom.observer.ChannelSubject;

import java.awt.*;

/**
 * @author Binura
 */
public class ChannelContentPanel extends javax.swing.JPanel {

    /**
     * GUI Components
     */
    private javax.swing.JLabel btnShare;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChannelName;
    private javax.swing.JLabel lblSubscriberCount;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextArea txtPostContent;

    /**
     * Class Properties
     */
    private ChannelSubject channelSubject;
    private ChannelController channelController;

    /**
     * Creates new form ChannelStartPanel
     */
    public ChannelContentPanel(ChannelSubject channelSubject) {
        this.channelSubject = channelSubject;
        this.channelController = (ChannelController) ControllerFactory.getInstance()
                .getController(ControllerFactory.ControllerTypes.CHANNEL);
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

        pnlMain = new javax.swing.JPanel();
        btnShare = new javax.swing.JLabel();
        lblChannelName = new javax.swing.JLabel();
        lblSubscriberCount = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPostContent = new javax.swing.JTextArea();

        setPreferredSize(new Dimension(1105, 800));

        pnlMain.setBackground(new Color(255, 255, 255));
        pnlMain.setPreferredSize(new Dimension(1105, 800));

        btnShare.setBackground(new Color(59, 89, 152));
        btnShare.setFont(new Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        btnShare.setForeground(new Color(255, 255, 255));
        btnShare.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnShare.setText("Share");
        btnShare.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(59, 89, 152)));
        btnShare.setOpaque(true);
        btnShare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShareMouseClicked(evt);
            }
        });

        lblChannelName.setFont(new Font("Yu Gothic UI Light", 0, 30)); // NOI18N
        lblChannelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChannelName.setText("Channel Name");

        lblSubscriberCount.setBackground(new Color(220, 75, 56));
        lblSubscriberCount.setFont(new Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        lblSubscriberCount.setForeground(new Color(255, 255, 255));
        lblSubscriberCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubscriberCount.setText("Live Subscriber Count 23");
        lblSubscriberCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSubscriberCount.setOpaque(true);

        txtPostContent.setColumns(20);
        txtPostContent.setFont(new Font("Monospaced", 0, 24)); // NOI18N
        txtPostContent.setRows(5);
        txtPostContent.setText(" What's on your mind?");
        txtPostContent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPostContentFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPostContentFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtPostContent);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
                pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblChannelName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
                                                .addComponent(lblSubscriberCount, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(pnlMainLayout.createSequentialGroup()
                                .addGap(394, 394, 394)
                                .addComponent(btnShare, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(398, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
                pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblChannelName, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSubscriberCount, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnShare, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMain.getAccessibleContext().setAccessibleName("");
        lblChannelName.setText(channelSubject.getChannelName());
    }// </editor-fold>//GEN-END:initComponents

    private void txtPostContentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPostContentFocusGained
        if (txtPostContent.getText().equals(" What's on your mind?")) {
            txtPostContent.setText("");
        }
    }//GEN-LAST:event_txtPostContentFocusGained

    private void txtPostContentFocusLost(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void btnShareMouseClicked(java.awt.event.MouseEvent evt) {
        String postContent = txtPostContent.getText();
        channelController.shareNewPost(channelSubject, postContent);
    }
}
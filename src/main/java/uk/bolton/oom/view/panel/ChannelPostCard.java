/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.bolton.oom.view.panel;

import uk.bolton.oom.model.Post;

import java.awt.*;

/**
 * @author Binura
 */
public class ChannelPostCard extends javax.swing.JPanel {

    /**
     * GUI Components
     */
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChannelName;
    private javax.swing.JTextArea txtPostContent;

    /**
     * Class Properties
     */
    private final String channelName;
    private final String postContent;


    /**
     * Creates new post for user's news feed
     *
     * @param post details of post
     */
    public ChannelPostCard(Post post) {
        initComponents();
        this.channelName = post.getName();
        this.postContent = post.getPostContent();
        setPostDetails();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblChannelName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPostContent = new javax.swing.JTextArea();

        setBackground(new Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new Color(59, 89, 152)));
        setPreferredSize(new Dimension(625, 200));

        lblChannelName.setBackground(new Color(255, 255, 255));
        lblChannelName.setFont(new Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblChannelName.setText("Channel Name");
        lblChannelName.setOpaque(true);
        lblChannelName.setPreferredSize(new Dimension(630, 0));

        txtPostContent.setEditable(false);
        txtPostContent.setColumns(20);
        txtPostContent.setFont(new Font("Yu Gothic UI Light", 2, 24)); // NOI18N
        txtPostContent.setLineWrap(true);
        txtPostContent.setRows(3);
        txtPostContent.setBorder(null);
        jScrollPane1.setViewportView(txtPostContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblChannelName, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblChannelName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                .addContainerGap())
        );

        this.setPreferredSize(new Dimension(630, 198));
        this.setMinimumSize(new Dimension(630, 198));
        this.setMaximumSize(new Dimension(630, 198));
    }

    private void setPostDetails() {
        lblChannelName.setText(channelName);
        txtPostContent.setText(postContent);
    }
}
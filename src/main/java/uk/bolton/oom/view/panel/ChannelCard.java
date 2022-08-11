/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.bolton.oom.view.panel;

import uk.bolton.oom.controller.ChannelController;
import uk.bolton.oom.exception.ChannelCustomException;
import uk.bolton.oom.factory.ControllerFactory;
import uk.bolton.oom.observer.ChannelSubject;
import uk.bolton.oom.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static uk.bolton.oom.constant.ApplicationConstant.*;

/**
 * @author Binura
 */
public class ChannelCard extends javax.swing.JPanel {

    private static final Logger LOGGER = Logger.getLogger(ChannelCard.class.getName());

    /**
     * GUI Components
     */
    private javax.swing.JLabel btnSubscribe;
    private javax.swing.JLabel lblChannelName;

    /**
     * Class Properties
     */
    private ChannelSubject channelSubject;
    private Observer userObserver;
    private ChannelController channelController;


    public ChannelCard(ChannelSubject channelSubject, Observer userObserver) {
        this.channelSubject = channelSubject;
        this.userObserver = userObserver;
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
    private void initComponents() {

        lblChannelName = new javax.swing.JLabel();
        btnSubscribe = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 75, 56)));
        setPreferredSize(new Dimension(625, 200));

        lblChannelName.setBackground(new java.awt.Color(255, 255, 255));
        lblChannelName.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblChannelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChannelName.setText("Channel Name");
        lblChannelName.setOpaque(true);
        lblChannelName.setPreferredSize(new Dimension(630, 0));

        btnSubscribe.setBackground(new java.awt.Color(220, 75, 56));
        btnSubscribe.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        btnSubscribe.setForeground(new java.awt.Color(255, 255, 255));
        btnSubscribe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSubscribe.setText(BUTTON_TEXT_SUBSCRIBE);
        btnSubscribe.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(220, 75, 56)));
        btnSubscribe.setOpaque(true);
        btnSubscribe.setPreferredSize(new Dimension(630, 0));
        btnSubscribe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubscribeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblChannelName, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                                        .addComponent(btnSubscribe, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblChannelName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSubscribe, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        this.setPreferredSize(new Dimension(420, 145));
        this.setMinimumSize(new Dimension(420, 145));
        this.setMaximumSize(new Dimension(420, 145));
        lblChannelName.setText(channelSubject.getChannelName());
    }


    private void btnSubscribeMouseClicked(java.awt.event.MouseEvent evt) {
        try {

            if (btnSubscribe.getText().equals(BUTTON_TEXT_SUBSCRIBE)) {
                subscribeUserToChannel();
                showSuccessMessageInDialogBox(String.format("Successfully subscribe to %s channel.", channelSubject.getChannelName()));
                changeButtonAppearanceToUnSub();
            } else {
                unSubscribeUserFromChannel();
                showSuccessMessageInDialogBox(String.format("Successfully unsubscribe from %s channel.", channelSubject.getChannelName()));
                changeButtonAppearanceToSub();
            }

        } catch (ChannelCustomException e) {
            LOGGER.log(Level.SEVERE, "Method :  subscribe / unsubscribe UserToChannel", e);
            showErrorMessageInDialogBox(e.getMessage());

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Method :  subscribe / unsubscribe UserToChannel", e);
            showErrorMessageInDialogBox(ERROR_MSG_UNEXPECTED);
        }
    }

    private void subscribeUserToChannel() {
        channelController.subscribeUserToChannel(channelSubject, userObserver);
    }

    private void unSubscribeUserFromChannel() {
        channelController.unSubscribeUserFromChannel(channelSubject, userObserver);
    }

    private void showErrorMessageInDialogBox(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage,
                "Error", JOptionPane.ERROR_MESSAGE);
    }


    private void showSuccessMessageInDialogBox(String successMessage) {
        JOptionPane.showMessageDialog(this, successMessage,
                "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void changeButtonAppearanceToSub(){
        btnSubscribe.setBackground(new java.awt.Color(220, 75, 56));
        btnSubscribe.setText(BUTTON_TEXT_SUBSCRIBE);
    }

    private void changeButtonAppearanceToUnSub(){
        btnSubscribe.setBackground(new java.awt.Color(108, 122, 137));
        btnSubscribe.setText(BUTTON_TEXT_UNSUBSCRIBE);
    }

}

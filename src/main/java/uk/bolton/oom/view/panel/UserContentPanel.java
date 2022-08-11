/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.bolton.oom.view.panel;

import uk.bolton.oom.controller.UserController;
import uk.bolton.oom.enums.ObserverUpdateContentType;
import uk.bolton.oom.factory.ControllerFactory;
import uk.bolton.oom.model.Channel;
import uk.bolton.oom.model.ObserverUpdateContent;
import uk.bolton.oom.model.Post;
import uk.bolton.oom.observer.ChannelSubject;
import uk.bolton.oom.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

import static uk.bolton.oom.constant.ApplicationConstant.USER_PAGE_GREETING_MSG;

/**
 * @author Binura
 */
public class UserContentPanel extends JPanel implements Observer {

    /**
     * UI Components
     */
    private JScrollPane jScrollPane1;
    private JLabel lblChannels;
    private JLabel lblNewsFeed;
    private JLabel lblUserName;
    private JPanel pnlChannelList;
    private JPanel pnlMain;
    private JPanel pnlNewsFeed;
    private JScrollPane scrpNewsFeed;

    /**
     *  Class properties
     */

    private String userName;
    private UserController userController;

    /**
     * Creates new form ChannelStartPanel
     */
    public UserContentPanel(String userName) {
        this.userName = userName;
        this.userController = (UserController)
                ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.USER);
        initComponents();
        setUserDetailsAndRegister();
        loadAlreadyExistingChannels();

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlMain = new JPanel();
        lblNewsFeed = new JLabel();
        scrpNewsFeed = new JScrollPane();
        pnlNewsFeed = new JPanel();
        lblUserName = new JLabel();
        lblChannels = new JLabel();
        jScrollPane1 = new JScrollPane();
        pnlChannelList = new JPanel();

        setPreferredSize(new Dimension(1105, 800));

        pnlMain.setBackground(new Color(255, 255, 255));
        pnlMain.setPreferredSize(new Dimension(1105, 800));

        lblNewsFeed.setBackground(new Color(59, 89, 152));
        lblNewsFeed.setFont(new Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblNewsFeed.setForeground(new Color(255, 255, 255));
        lblNewsFeed.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewsFeed.setText("News Feed");
        lblNewsFeed.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(59, 89, 152)));
        lblNewsFeed.setOpaque(true);

        scrpNewsFeed.setBorder(new javax.swing.border.LineBorder(new Color(59, 89, 152), 2, true));
        scrpNewsFeed.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrpNewsFeed.setPreferredSize(new Dimension(635, 672));
        scrpNewsFeed.setRequestFocusEnabled(false);

        pnlNewsFeed.setBackground(new Color(255, 255, 255));
        pnlNewsFeed.setLayout(new BoxLayout(pnlNewsFeed, BoxLayout.Y_AXIS));
        scrpNewsFeed.setViewportView(pnlNewsFeed);

        lblUserName.setFont(new Font("Yu Gothic UI Light", 0, 30)); // NOI18N
        lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserName.setText("User Name");

        lblChannels.setBackground(new Color(220, 75, 56));
        lblChannels.setFont(new Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        lblChannels.setForeground(new Color(255, 255, 255));
        lblChannels.setHorizontalAlignment(SwingConstants.CENTER);
        lblChannels.setText("Channels");
        lblChannels.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(59, 89, 152)));
        lblChannels.setOpaque(true);
        lblChannels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChannelsMouseClicked(evt);
            }
        });

        pnlChannelList.setBackground(new Color(255, 255, 255));
        pnlChannelList.setBorder(new javax.swing.border.LineBorder(new Color(220, 75, 56), 1, true));
        pnlChannelList.setLayout(new BoxLayout(pnlChannelList, BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pnlChannelList);

        GroupLayout pnlMainLayout = new GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
                pnlMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlMainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblNewsFeed, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(scrpNewsFeed, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblChannels, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
                        .addGroup(pnlMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(pnlMainLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(lblUserName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap()))
        );
        pnlMainLayout.setVerticalGroup(
                pnlMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMainLayout.createSequentialGroup()
                                .addContainerGap(110, Short.MAX_VALUE)
                                .addGroup(pnlMainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewsFeed, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblChannels, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(scrpNewsFeed, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
                        .addGroup(pnlMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(pnlMainLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(705, Short.MAX_VALUE)))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(pnlMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(pnlMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMain.getAccessibleContext().setAccessibleName("");
        pnlNewsFeed.setLayout(new BoxLayout(pnlNewsFeed, BoxLayout.Y_AXIS));
    }

    private void lblChannelsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChannelsMouseClicked
//        ChannelPostCard channelPostCard = new ChannelPostCard("Testing Content");
//        pnlNewsFeed.add(channelPostCard);
//        pnlNewsFeed.revalidate();
//        pnlNewsFeed.repaint();


    }

    private void setUserDetailsAndRegister(){
        lblUserName.setText(String.format(USER_PAGE_GREETING_MSG, userName));
        userController.signUpUser(this);
    }

    private void updateNewsFeed(Post post){
        ChannelPostCard channelPostCard = new ChannelPostCard(post);
        pnlNewsFeed.add(channelPostCard, 0);
        pnlNewsFeed.revalidate();
        pnlNewsFeed.repaint();
    }

    private void updateChannelList(ChannelSubject channelSubject){
        ChannelCard channelCard = new ChannelCard(channelSubject, this);
        pnlChannelList.add(channelCard, 0);
        pnlChannelList.revalidate();
        pnlChannelList.repaint();
    }

    private void loadAlreadyExistingChannels(){
        Set<ChannelSubject> allChannelList = userController.getAllChannelList();
        for (ChannelSubject channelSubject : allChannelList) {
            updateChannelList(channelSubject);
        }
    }

    @Override
    public void update(ObserverUpdateContent observerUpdateContent) {

       if(observerUpdateContent.getObserverUpdateContentType().equals(ObserverUpdateContentType.POST)){
           updateNewsFeed((Post) observerUpdateContent);
       } else{
           Channel channel = (Channel) observerUpdateContent;
           updateChannelList(channel.getChannelSubject());
       }
    }
}

package uk.bolton.oom.controller.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.bolton.oom.exception.ChannelCustomException;
import uk.bolton.oom.factory.ChannelListSubjectFactory;
import uk.bolton.oom.model.ObserverUpdateContent;
import uk.bolton.oom.observer.ChannelListSubject;
import uk.bolton.oom.observer.ChannelSubject;
import uk.bolton.oom.observer.Observer;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


class ChannelControllerImplTest {

    private static final Logger LOGGER = Logger.getLogger(ChannelControllerImpl.class.getName());

    private ChannelListSubject channelListSubject;
    private Set<Observer> observers;
    private ChannelSubject channelSubject;
    private TestObserverUser testObserver;

    @BeforeEach
    void setUp() {
        channelListSubject = ChannelListSubjectFactory.getInstance().getChannelListSubject();
        observers = new HashSet<>();
        channelSubject = new ChannelSubject("Testing Channel");
        testObserver = new TestObserverUser("Testing first User");
    }

    @Test
    @DisplayName("Test Subscribe User to Channel")
    void subscribeUserToChannel() {
        
        //check subscribe process with valid user - check return type
        assertTrue(channelSubject.registerObserver(testObserver));

        //check subscribe process with valid user - check exception handling
        assertDoesNotThrow(() -> channelSubject.registerObserver(testObserver));

        //check subscribe process with invalid user - check exception handling
        assertThrows(ChannelCustomException.class, () -> channelSubject.registerObserver(null));
    }

    @Test
    @DisplayName("Test Unsubscribe User from Channel")
    void unSubscribeUserFromChannel() {

        // check already subscribed user
        channelSubject.registerObserver(testObserver);
        assertTrue(channelSubject.unRegisterObserver(testObserver));

        // check not subscribed user
        assertFalse(channelSubject.unRegisterObserver(new TestObserverUser("Testing second User")));
    }

    @Test
    @DisplayName("Test Share new post from channel")
    void shareNewPost() {

        //check post with valid content
        assertDoesNotThrow(() -> channelSubject.shareNewPost("This is valid content"));

        //check with null content
        assertThrows(ChannelCustomException.class, () -> channelSubject.shareNewPost(null));

        //check with empty content
        assertThrows(ChannelCustomException.class, () -> channelSubject.shareNewPost(""));
    }

    @Test
    @DisplayName("Test channel sign-up")
    void signUpChannel() {

        //check registration with valid channel
        assertDoesNotThrow(() -> channelListSubject.registerNewChannel(channelSubject));

        //check registration with null channel
        assertThrows(ChannelCustomException.class, () -> channelListSubject.registerNewChannel(null));

        ///check registration with invalid channel name - channel name null
        assertThrows(ChannelCustomException.class, () -> channelListSubject.
                registerNewChannel(new ChannelSubject(null)));

        ///check registration with invalid channel name - channel name empty
        assertThrows(ChannelCustomException.class, () -> channelListSubject.
                registerNewChannel(new ChannelSubject("")));
    }

    static class TestObserverUser implements Observer {

        private final String userName;

        public TestObserverUser(String userName) {
            this.userName = userName;
        }

        @Override
        public void update(ObserverUpdateContent observerUpdateContent) {
            LOGGER.log(Level.INFO, "Testing post content "+observerUpdateContent.getName());
        }
    }
}
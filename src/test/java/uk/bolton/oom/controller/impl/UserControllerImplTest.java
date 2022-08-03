package uk.bolton.oom.controller.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.bolton.oom.exception.UserCustomException;
import uk.bolton.oom.factory.ChannelListSubjectFactory;
import uk.bolton.oom.model.ObserverUpdateContent;
import uk.bolton.oom.observer.ChannelListSubject;
import uk.bolton.oom.observer.ChannelSubject;
import uk.bolton.oom.observer.Observer;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


class UserControllerImplTest {

    private static final Logger LOGGER = Logger.getLogger(UserControllerImplTest.class.getName());

    private ChannelListSubject channelListSubject;
    private TestObserverUser testObserver;


    @BeforeEach
    void setUp() {
        channelListSubject = ChannelListSubjectFactory.getInstance().getChannelListSubject();
        testObserver = new TestObserverUser("Testing first User");
    }

    @Test
    @DisplayName("Test user sign-up")
    void signUpUser() {

        //check user sign-up process with valid user - check return type
        assertTrue(channelListSubject.registerObserver(testObserver));

        //check subscribe process with valid user - check exception handling
        assertDoesNotThrow(() -> channelListSubject.registerObserver(testObserver));

        //check subscribe process with invalid user - check exception handling
        assertThrows(UserCustomException.class, () -> channelListSubject.registerObserver(null));
    }

    @Test
    @DisplayName("Test fetch all channel list")
    void getAllChannelList() {
        Set<ChannelSubject> channelList = channelListSubject.getChannelList();

        //check channel list not null when empty
        assertNotNull(channelList);

        //check channel list size if 0 when empty
        assertEquals(0, channelList.size());

        //check channel list size when after adding channel
        channelListSubject.registerNewChannel(new ChannelSubject("Testing channel"));
        assertEquals(1, channelList.size());

    }

    static class TestObserverUser implements Observer {

        private final String userName;

        public TestObserverUser(String userName) {
            this.userName = userName;
        }

        @Override
        public void update(ObserverUpdateContent observerUpdateContent) {
            LOGGER.log(Level.INFO, "Testing channel adding channel name : "+observerUpdateContent.getName());
        }
    }
}
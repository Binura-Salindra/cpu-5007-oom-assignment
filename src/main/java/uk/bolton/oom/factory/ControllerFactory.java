package uk.bolton.oom.factory;

import uk.bolton.oom.controller.SuperController;
import uk.bolton.oom.controller.impl.ChannelControllerImpl;
import uk.bolton.oom.controller.impl.UserControllerImpl;

public class ControllerFactory {

    public enum ControllerTypes{
        CHANNEL, USER
    }

    private static ControllerFactory controllerFactory;

    private ControllerFactory(){

    }

    public static ControllerFactory getInstance(){
        if (controllerFactory == null){
            controllerFactory = new ControllerFactory();
        }
        return controllerFactory;
    }

    public SuperController getController(ControllerTypes controller) {
        switch (controller){
            case CHANNEL:
                return new ChannelControllerImpl();
            case USER :
                return new UserControllerImpl();
            default:
                return null;
        }
    }
}

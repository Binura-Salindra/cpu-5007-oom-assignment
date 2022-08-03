package uk.bolton.oom.exception;

public class ChannelCustomException extends RuntimeException {

    private String message;

    public ChannelCustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

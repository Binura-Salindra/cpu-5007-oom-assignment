package uk.bolton.oom.exception;

public class UserCustomException extends RuntimeException {

    private String message;

    public UserCustomException(String message) {
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

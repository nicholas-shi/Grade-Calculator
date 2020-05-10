public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException() {
        this("InvalidInputException has occurred");
    }
}
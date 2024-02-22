public class InvalidCallNumber extends Exception {
    public InvalidCallNumber() {
        super("Invalid call number");
    }

    public InvalidCallNumber(String message) {
        super(message);
    }
}

package Domain;

public class EventValidatorException extends RuntimeException {
    EventValidatorException(String message) {

        super("Event Validator Exception ||| " + message);
    }
}

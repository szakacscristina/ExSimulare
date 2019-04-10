package Repository;

public class RepositoryException extends RuntimeException {
    RepositoryException(String message) {

        super("Repository Exception ||| " + message);
    }
}

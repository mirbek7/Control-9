package kg.atractor.control9.errors;

import java.util.NoSuchElementException;

public class CanNotFindImageException extends NoSuchElementException {
    public CanNotFindImageException(String msg) {
        super(msg);
    }
}

package io.library.libmgmtsys.exception;

public class UserAlreadyPresentException extends RuntimeException {
    UserAlreadyPresentException(Long id) {
        super("Already a user with this details is available " + id);
    }
}

package ru.academits.schepin.cft.exceptions;

public class WrongTransferredFileException extends RuntimeException {
    public WrongTransferredFileException(String message) {
        super(message);
    }
}

package edu.dio.bancodigital.exceptions;

public class DailyLimitExceededException extends RuntimeException{
    public DailyLimitExceededException(String message) {
        super(message);
    }
}

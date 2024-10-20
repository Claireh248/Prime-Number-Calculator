package com.primeNumberCalculator.primeNumberCalculator.model;

/**
 * A generic class representing the outcome of an operation.
 *
 * @param <T> the type of data included in the outcome
 */

public class Outcome<T> {
    private final boolean success;
    private final String message;
    private final T data;

    /**
     * Constructs an Outcome instance.
     *
     * @param success indicates if the operation was successful
     * @param message a message providing additional information
     * @param data the data returned by the operation
     */
    public Outcome(final boolean success, final String message, final T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    /**
     * Returns the success status of the operation.
     *
     * @return true if the operation was successful, false otherwise
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Returns the message associated with the outcome.
     *
     * @return the message providing additional information
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns the data associated with the outcome.
     *
     * @return the data returned by the operation
     */
    public T getData() {
        return data;
    }
}
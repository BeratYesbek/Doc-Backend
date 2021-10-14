package com.doc.doc_backend.core.utilities.concretes;

public class ErrorResult extends Result {

    public ErrorResult(String message) {
        super(false, message);
    }

    public ErrorResult() {
        super(false);
    }

}

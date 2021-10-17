package com.doc.doc_backend.core.utilities.concretes;

public class SuccessResult extends Result {

    public SuccessResult(String message) {
        super(true, message);
    }

    public SuccessResult() {
        super(true);
    }
}

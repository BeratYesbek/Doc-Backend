package com.doc.doc_backend.results;

public class SuccessResult extends Result {

    public SuccessResult(String message) {
        super(true, message);
    }

    public SuccessResult() {
        super(true);
    }

}

package com.doc.doc_backend.core.utilities.concretes;

public class DataResult<T> extends Result {
    //mdd was here
    int num;
    private T data;

    public DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    public DataResult(T data,boolean success) {
        super(success);
        this.data = data;
    }

    public T getData() {
        return data;
    }
}

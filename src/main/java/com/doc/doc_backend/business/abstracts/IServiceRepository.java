package com.doc.doc_backend.business.abstracts;



import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;

import java.util.List;

public interface IServiceRepository<T> {

    DataResult<T> add(T entity);

    Result update(T entity);

    Result delete(T entity);

    DataResult<T> getById(int id);

    DataResult<List<T>> getAll();
}

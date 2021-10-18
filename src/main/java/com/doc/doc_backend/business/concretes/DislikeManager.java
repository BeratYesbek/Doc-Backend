package com.doc.doc_backend.business.concretes;

import com.doc.doc_backend.business.abstracts.IDislikeService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.dataAccess.abstracts.IDislikeDao;
import com.doc.doc_backend.entities.concretes.Dislike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DislikeManager implements IDislikeService {

    private IDislikeDao dislikeDao;

    @Autowired
    public DislikeManager(IDislikeDao dislikeDao) {
        this.dislikeDao = dislikeDao;
    }

    @Override
    public DataResult<Dislike> add(Dislike entity) {
        return null;
    }

    @Override
    public Result update(Dislike entity) {
        return null;
    }

    @Override
    public Result delete(Dislike entity) {
        return null;
    }

    @Override
    public DataResult<Dislike> getById(int id) {
        return null;
    }

    @Override
    public DataResult<List<Dislike>> getAll() {
        return null;
    }
}

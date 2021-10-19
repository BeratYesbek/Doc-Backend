package com.doc.doc_backend.business.concretes;

import com.doc.doc_backend.business.abstracts.ILikeService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.ErrorDataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.core.utilities.concretes.SuccessDataResult;
import com.doc.doc_backend.dataAccess.abstracts.ILikeDao;
import com.doc.doc_backend.entities.concretes.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeManager implements ILikeService {

    private ILikeDao likeDao;

    @Autowired
    public LikeManager(ILikeDao likeDao) {
        this.likeDao = likeDao;
    }

    @Override
    public DataResult<Like> add(Like entity) {
        Like like = likeDao.save(entity);
        if (like != null) {
            return new SuccessDataResult(like);
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result update(Like entity) {
        return null;
    }

    @Override
    public Result delete(Like entity) {
        return null;
    }

    @Override
    public DataResult<Like> getById(int id) {
        return null;
    }

    @Override
    public DataResult<List<Like>> getAll() {
        return null;
    }
}

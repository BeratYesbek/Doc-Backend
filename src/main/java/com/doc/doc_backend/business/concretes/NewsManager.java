package com.doc.doc_backend.business.concretes;

import com.doc.doc_backend.business.abstracts.INewsService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.ErrorDataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.core.utilities.concretes.SuccessDataResult;
import com.doc.doc_backend.dataAccess.abstracts.INewsDao;
import com.doc.doc_backend.entities.concretes.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsManager implements INewsService {

    private INewsDao newsDao;

    @Autowired
    public NewsManager(INewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public DataResult<News> add(News entity) {
        News news = newsDao.save(entity);
        if (news != null) {
            return new SuccessDataResult(news);
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result update(News entity) {
        return null;
    }

    @Override
    public Result delete(News entity) {
        return null;
    }

    @Override
    public DataResult<News> getById(int id) {
        return null;
    }

    @Override
    public DataResult<List<News>> getAll() {
        return null;
    }
}

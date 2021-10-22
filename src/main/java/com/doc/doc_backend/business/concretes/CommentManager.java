package com.doc.doc_backend.business.concretes;

import com.doc.doc_backend.business.abstracts.ICommentService;
import com.doc.doc_backend.core.utilities.concretes.*;
import com.doc.doc_backend.dataAccess.abstracts.ICommentDao;
import com.doc.doc_backend.entities.concretes.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentManager implements ICommentService {

    private ICommentDao commentDao;

    @Autowired
    public CommentManager(ICommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public DataResult<Comment> add(Comment entity) {
        Comment comment = commentDao.save(entity);
        if (comment != null) {
            return new SuccessDataResult(comment);
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result update(Comment entity) {
        commentDao.save(entity);
        return new SuccessResult("Comment has been updated");
    }

    @Override
    public Result delete(Comment entity) {
        commentDao.delete(entity);
        return new SuccessResult("Comment has been deleted");
    }

    @Override
    public DataResult<Comment> getById(int id) {
        Comment comment = commentDao.findById(id).get();
        return new SuccessDataResult(comment);
    }

    @Override
    public DataResult<List<Comment>> getAll() {
        return new SuccessDataResult(commentDao.findAll());
    }
}

package com.doc.doc_backend.business.concretes;

import com.doc.doc_backend.business.abstracts.IUserService;
import com.doc.doc_backend.dataAccess.abstracts.IUserDao;
import com.doc.doc_backend.entities.concretes.User;
import com.doc.doc_backend.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements IUserService {

    private IUserDao userDao;
    private int count;

    @Autowired
    public UserManager(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<User> add(User entity) {
       User user = userDao.save(entity);
       if (user != null){
           return new SuccessDataResult(user,"User has been added successfully");
       }
        return new ErrorDataResult(null,"User has not been added successfully");
    }

    @Override
    public Result update(User entity) {
        return null;
    }

    @Override
    public Result delete(User entity) {
        userDao.delete(entity);

        return new SuccessResult("");
    }

    @Override
    public DataResult<User> getById(int id) {
        return null;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return null;
    }
}

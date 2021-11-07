package com.doc.doc_backend.business.concretes;

import com.doc.doc_backend.business.abstracts.IUserOperationClaimService;
import com.doc.doc_backend.business.abstracts.IUserService;
import com.doc.doc_backend.core.annotations.SecurityOperation;
import com.doc.doc_backend.core.utilities.concretes.*;
import com.doc.doc_backend.dataAccess.abstracts.IUserDao;
import com.doc.doc_backend.core.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class UserManager implements IUserService, UserDetailsService {

    private IUserDao userDao;
    private IUserOperationClaimService userOperationClaimService;
    private final PasswordEncoder passwordEncoder;
    private IUserService userService;

    @Autowired
    public UserManager(IUserDao userDao, IUserOperationClaimService userOperationClaimService, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.userOperationClaimService = userOperationClaimService;
        this.passwordEncoder = passwordEncoder;

    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userDao.findByEmail(username);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        ArrayList<String> userOperationClaims = new ArrayList<>();
        userOperationClaims.add("Admin");

        userOperationClaimService.findByUserId(user.getUserId()).forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getOperationClaim().getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public DataResult<User> add(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        User user = userDao.save(entity);
        if (user != null) {
            return new SuccessDataResult(user, "User has been added successfully");
        }
        return new ErrorDataResult(null, "User has not been added successfully");
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
    @SecurityOperation(security = {"User"})
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult(userDao.findAll());
    }


    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult(this.userDao.findByEmail(email));
    }
}

package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.IUserService;
import com.doc.doc_backend.core.entities.User;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@Controller
public class UsersController {

    private IUserService userService;

    @Autowired
    public UsersController(IUserService userService) {
        this.userService = userService;
    }

    //www.doc.com/api/users/add
    @PostMapping("/add")
    public DataResult<User> add(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll() {
        return userService.getAll();
    }
}

package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.ICommentService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.entities.concretes.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    private ICommentService commentService;

    public CommentsController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    private DataResult<Comment> add(@RequestBody Comment comment) {
        return this.commentService.add(comment);
    }

    @PostMapping("/update")
    private Result update(@RequestBody Comment comment) {
        return this.commentService.update(comment);
    }

    @PostMapping("/delete")
    private Result delete(@RequestBody Comment comment) {
        return this.commentService.delete(comment);
    }

    @GetMapping("/getById")
    private DataResult<Comment> getById(int id) {
        return this.commentService.getById(id);
    }

    @GetMapping("/getAll")
    private DataResult<List<Comment>> getAll() {
        return this.commentService.getAll();
    }

}

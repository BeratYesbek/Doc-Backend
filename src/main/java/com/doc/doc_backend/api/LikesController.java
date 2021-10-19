package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.ILikeService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.entities.concretes.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/likes")
public class LikesController {

    private ILikeService likeService;

    @Autowired
    public LikesController(ILikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/add")
    public DataResult<Like> add(@RequestBody Like like){

        return likeService.add(like);
    }

}

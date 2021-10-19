package com.doc.doc_backend.api;

import com.doc.doc_backend.business.abstracts.IDislikeService;
import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.dataAccess.abstracts.IDislikeDao;
import com.doc.doc_backend.entities.concretes.Dislike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dislikes")
public class DislikesController {

    private IDislikeService dislikeService;

    @Autowired
    public DislikesController(IDislikeService dislikeService) {
        this.dislikeService = dislikeService;
    }


    @PostMapping("/add")
    public DataResult<Dislike> add(@RequestBody Dislike dislike) {
        return dislikeService.add(dislike);
    }
}

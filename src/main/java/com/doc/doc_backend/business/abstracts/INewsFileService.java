package com.doc.doc_backend.business.abstracts;

import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.entities.concretes.NewsFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface INewsFileService  {

    DataResult add(NewsFile newsFile, MultipartFile[] multipartFile);

    Result update(NewsFile newsFile[], MultipartFile[] multipartFiles);

    Result delete(NewsFile[] newsFile);

    DataResult<NewsFile> getById(int id);

    DataResult<List<NewsFile>> getAll();
}

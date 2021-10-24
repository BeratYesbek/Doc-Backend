package com.doc.doc_backend.business.abstracts;

import com.doc.doc_backend.core.utilities.concretes.DataResult;
import com.doc.doc_backend.entities.concretes.NewsFile;
import org.springframework.web.multipart.MultipartFile;

public interface INewsFileService extends IServiceRepository<NewsFile>{
    DataResult add(NewsFile newsFile, MultipartFile[] multipartFile);
}

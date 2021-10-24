package com.doc.doc_backend.core.utilities.fileHelper;

import com.doc.doc_backend.core.utilities.concretes.Result;
import org.springframework.web.multipart.MultipartFile;

public interface IFileHelperService {
    Result add(MultipartFile file, String[] fileExtension);
}

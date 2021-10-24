package com.doc.doc_backend.business.concretes;

import com.doc.doc_backend.business.abstracts.INewsFileService;
import com.doc.doc_backend.core.utilities.concretes.*;
import com.doc.doc_backend.core.utilities.fileHelper.FileExtension;
import com.doc.doc_backend.core.utilities.fileHelper.FileHelperService;
import com.doc.doc_backend.dataAccess.abstracts.INewsFileDao;
import com.doc.doc_backend.entities.concretes.News;
import com.doc.doc_backend.entities.concretes.NewsFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class NewsFileManager implements INewsFileService {

    private INewsFileDao newsFileDao;

    @Autowired
    public NewsFileManager(INewsFileDao newsFileDao) {
        this.newsFileDao = newsFileDao;
    }

    @Override
    public DataResult add(NewsFile newsFile, MultipartFile[] multipartFiles) {
        for (MultipartFile file : multipartFiles) {
            Result result = new FileHelperService.FileHelper(FileExtension.image_extensions).add(file);
            if (!result.isSuccess()){
                return new ErrorDataResult(null,result.getMessage());
            }
            newsFile.setFile_path(result.getMessage());
            newsFileDao.save(newsFile);
        }
        return new SuccessDataResult(newsFile);
    }

    @Override
    public DataResult<NewsFile> add(NewsFile entity) {
        NewsFile newsFile = newsFileDao.save(entity);
        if (newsFile != null) {
            return new SuccessDataResult(newsFile);
        }
        return new ErrorDataResult(null);
    }

    @Override
    public Result update(NewsFile entity) {
        newsFileDao.save(entity);
        return new SuccessResult("");

    }

    @Override
    public Result delete(NewsFile entity) {
        newsFileDao.delete(entity);
        return new SuccessResult("");
    }

    @Override
    public DataResult<NewsFile> getById(int id) {
        return new SuccessDataResult(newsFileDao.findById(id));
    }

    @Override
    public DataResult<List<NewsFile>> getAll() {
        return new SuccessDataResult(newsFileDao.findAll());
    }


}

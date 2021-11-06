package com.doc.doc_backend.business.concretes;
import com.doc.doc_backend.business.abstracts.INewsFileService;
import com.doc.doc_backend.core.utilities.concretes.*;
import com.doc.doc_backend.core.utilities.fileHelper.FileExtension;
import com.doc.doc_backend.core.utilities.fileHelper.FileHelperService;
import com.doc.doc_backend.dataAccess.abstracts.INewsFileDao;
import com.doc.doc_backend.entities.concretes.NewsFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class NewsFileManager implements INewsFileService {

    private INewsFileDao newsFileDao;
    private FileHelperService fileHelperService = new FileHelperService();

    @Autowired
    public NewsFileManager(INewsFileDao newsFileDao) {
        this.newsFileDao = newsFileDao;
    }

    @Override
    public DataResult add(NewsFile newsFile, MultipartFile[] multipartFiles) {
        for (MultipartFile file : multipartFiles) {
            Result result = new FileHelperService.FileHelper(FileExtension.image_extensions).add(file);
            if (!result.isSuccess()) {
                return new ErrorDataResult(null, result.getMessage());
            }

            NewsFile addedNewsFile = new NewsFile(0, result.getMessage(), newsFile.getNews());
            newsFileDao.save(addedNewsFile);
        }
        return new SuccessDataResult(newsFile);
    }

    @Override
    public Result update(NewsFile[] newsFile, MultipartFile[] multipartFiles) {
        for (int i = 0; i < multipartFiles.length; i++) {
            Result result = new FileHelperService.FileHelper(FileExtension.image_extensions).add(multipartFiles[i]);
            if (!result.isSuccess()) {
                return new ErrorDataResult(null, result.getMessage());
            }
            newsFile[i].setFile_path(result.getMessage());
            newsFileDao.save(newsFile[i]);
        }
        return new SuccessResult("Images has been added successfully");
    }

    @Override
    public Result delete(NewsFile[] newsFiles) {

        for (NewsFile newsFile : newsFiles) {
            newsFileDao.delete(newsFile);
        }
        return new SuccessResult("Image has been deleted successfully");
    }

    @Override
    public DataResult<NewsFile> getById(int id) {
        NewsFile newsFile = newsFileDao.getById(id);
        if (newsFile != null) {
            return new SuccessDataResult(newsFile);
        }
        return new ErrorDataResult(null);
    }

    @Override
    public DataResult<List<NewsFile>> getAll() {
        List<NewsFile> newsFileList = newsFileDao.findAll();
        if (newsFileList.size() > 0) {
            return new SuccessDataResult(newsFileList);
        }
        return new ErrorDataResult(null);
    }


}

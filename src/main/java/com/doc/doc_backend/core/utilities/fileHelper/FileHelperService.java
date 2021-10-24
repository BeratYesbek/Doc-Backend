package com.doc.doc_backend.core.utilities.fileHelper;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.doc.doc_backend.core.utilities.concretes.ErrorResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.core.utilities.concretes.SuccessResult;
import com.doc.doc_backend.core.utilities.firebase.InitializeFirebase;
import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.util.Map;
import java.util.UUID;


public class FileHelperService {

    public static class FileHelper {
        private static String[] fileExtensions;
        private static Cloudinary cloudinary;

        @SneakyThrows
        public FileHelper(String[] fileExtensions) {
            cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "afteb",
                    "api_key","263478243847123",
                    "api_secret","TnN1Q8Tli3DcTZ-qDXw5zgZWid8"
                    ));
            this.fileExtensions = fileExtensions;
        }

        @SneakyThrows
        public static Result add(MultipartFile file) {
            Result result = checkFileExtension(file);
            if (!result.isSuccess()) {
                return result;
            }
            Map<String,Object> resultMap = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
            String url = resultMap.get("secure_url").toString();

            return new SuccessResult(url);
        }

        private static Result checkFileExtension(MultipartFile file) {
            String extension = file.getContentType().split("/")[1];
            if (fileExtensions != null) {
                for (String value : fileExtensions) {
                    if (value.equals(extension)) {
                        return new SuccessResult();
                    }
                }
                return new ErrorResult("File extension is not valid");
            }
            return new ErrorResult(null);
        }
    }


}

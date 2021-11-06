package com.doc.doc_backend.core.utilities.fileHelper;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.doc.doc_backend.core.utilities.concretes.ErrorResult;
import com.doc.doc_backend.core.utilities.concretes.Result;
import com.doc.doc_backend.core.utilities.concretes.SuccessResult;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;


public class FileHelperService {

    public static class FileHelper {
        private static String[] fileExtensions;
        private static Cloudinary cloudinary;
        private static Map<String, Object> optionsMap;

        @SneakyThrows
        public FileHelper(String[] fileExtensions) {
            optionsMap = ObjectUtils.asMap(
                    "cloud_name", "afteb",
                    "api_key", "263478243847123",
                    "api_secret", "TnN1Q8Tli3DcTZ-qDXw5zgZWid8"
            );
            cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "afteb",
                    "api_key", "263478243847123",
                    "api_secret", "TnN1Q8Tli3DcTZ-qDXw5zgZWid8"
            ));
            this.fileExtensions = fileExtensions;

        }

        @SneakyThrows
        public static Result add(MultipartFile file) {
            Result result = checkFileExtension(file);
            if (!result.isSuccess()) {
                return result;
            }
            Map<String, Object> resultMap = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String url = resultMap.get("secure_url").toString();

            return new SuccessResult(url);
        }

        @SneakyThrows
        public static Result delete(String path) {
            cloudinary.uploader().destroy(path,optionsMap);
            return new SuccessResult();
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

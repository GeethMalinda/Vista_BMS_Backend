package lk.vista.book.service;

import lk.vista.book.entity.FileData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileDataService {

    FileData saveFileData(MultipartFile file) throws IOException;

    FileData getFileData(Integer id);

    void deleteFileData(Integer id);

}

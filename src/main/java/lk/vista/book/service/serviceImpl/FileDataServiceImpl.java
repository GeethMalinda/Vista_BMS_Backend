package lk.vista.book.service.serviceImpl;

import lk.vista.book.entity.FileData;
import lk.vista.book.repo.FileDataRepository;
import lk.vista.book.service.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileDataServiceImpl  implements FileDataService {

    private final String FOLDER_PATH="src/main/java/lk/vista/book/file";

    @Autowired
    private FileDataRepository fileDataRepository;

    @Override
    public FileData saveFileData(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();
        FileData fileData = FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath)
                .build();

        // Save the file to the file system
        file.transferTo(new File(filePath));

        // Save the file data in database
        return fileDataRepository.save(fileData);
    }

    @Override
    public FileData getFileData(Integer id) {
        return fileDataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FileData not found with id: " + id));
    }

    @Override
    public void deleteFileData(Integer id) {
        fileDataRepository.deleteById(id);
    }

}

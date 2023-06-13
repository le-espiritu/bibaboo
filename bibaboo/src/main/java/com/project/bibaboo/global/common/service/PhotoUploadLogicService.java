package com.project.bibaboo.global.common.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.project.bibaboo.domain.alterations.dto.AlterPhotoDTO;

@Service
public class PhotoUploadLogicService {

  public String uploadPhoto(MultipartFile multipartFile, String path)
      throws IllegalStateException, IOException {

    String originalFileName = multipartFile.getOriginalFilename();
    // 서버에서 식별할 수 있도록 파일명을 변경
    String newFileName = createNewFileName(originalFileName);
    multipartFile.transferTo(new File(path + File.separator + newFileName));

    return newFileName;
  }

  private String createNewFileName(String originalFileName) {
    int pos = originalFileName.lastIndexOf(".");
    String fileExtension = originalFileName.substring(pos + 1);
    String uuid = UUID.randomUUID().toString();
    return uuid + "." + fileExtension;
  }

}

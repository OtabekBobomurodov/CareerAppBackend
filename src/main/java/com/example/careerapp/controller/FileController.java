package com.example.careerapp.controller;

import com.example.careerapp.entity.Attachment;
import com.example.careerapp.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("upload")
public class FileController {

    @Autowired
    AttachmentRepository attachmentRepository;

    @PostMapping("save")
    public void saveFile(@RequestParam("file") MultipartFile multipartFile) {
        try {
            attachmentRepository.save(new Attachment(multipartFile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

package com.tangmran.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 唐梦然
 * @date 2022/11/14
 * @note
 */
@RestController
public class UploadController {
    @RequestMapping("/fileUpload")
    public String upload(MultipartFile file){
        File dir = new File("D:\\upload");
        if (!dir.exists()){
            dir.mkdir();
        }
        try {
            file.transferTo(new File(dir,file.getOriginalFilename()));
            return "success";
        } catch (IOException e) {
            return "defeat";
        }
    }

}

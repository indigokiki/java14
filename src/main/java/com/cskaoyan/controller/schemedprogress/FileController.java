package com.cskaoyan.controller.schemedprogress;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileController {

    @RequestMapping("file/upload")
    @ResponseBody
    public Map<String, Object> fileupload(MultipartFile file) throws IOException {
        File directory = new File("D://fileupload");
        if (!directory.exists()){
            directory.mkdir();
        }

        String name = file.getOriginalFilename();
        name =  UUID.randomUUID() + name;
        File myfile = new File(directory, name);
        file.transferTo(myfile);

        HashMap<String, Object> map = new HashMap<>();
        map.put("error", 0);
        map.put("url",myfile.toString());
        return map;
    }

    @RequestMapping("file/delete")
    @ResponseBody
    public Map<String, String> deleteFile(String fileName){
        File file = new File(fileName);
        boolean delete = file.delete();
        HashMap<String, String> map = new HashMap<>();
        map.put("data", "success");
        return map;
    }

    @RequestMapping("pic/upload")
    @ResponseBody
    public Map<String, Object> picupload(MultipartFile pic) throws IOException {
        File directory = new File("D://fileupload");
        if (!directory.exists()){
            directory.mkdir();
        }

        String name = pic.getOriginalFilename();
        name =  UUID.randomUUID() + name;
        File myfile = new File(directory, name);
        pic.transferTo(myfile);

        HashMap<String, Object> map = new HashMap<>();
        map.put("error", 0);
        map.put("url",myfile.toString());
        return map;
    }

    @RequestMapping("pic/delete")
    @ResponseBody
    public Map<String, String> deletepic(String picName){
        File file = new File(picName);
        boolean delete = file.delete();
        HashMap<String, String> map = new HashMap<>();
        map.put("data", "success");
        return map;
    }

}

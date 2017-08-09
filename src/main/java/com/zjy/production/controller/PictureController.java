package com.zjy.production.controller;

import com.zjy.production.service.PictureService;
import com.zjy.production.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiuyangzhang2 on 2017/8/3 0003.
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String pictureUpload(MultipartFile multipartFile) throws Exception{
        Map<String,Object> result = pictureService.uploadPicture(multipartFile);
        String json = JsonUtils.objectToJson(result);
        return json;
    }

    @RequestMapping("/pic/delete")
    @ResponseBody
    public String pictureDelete(@RequestParam String picName) throws Exception{
        pictureService.deleteFile(picName);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("data","success");
        String json = JsonUtils.objectToJson(result);
        return json;
    }
}

package com.zjy.production.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zjy.production.service.FileService;
import com.zjy.production.util.FileUtil;
@Service
public class FileServiceImpl implements FileService {

	@Override
	public Map<String, Object> uploadFile(MultipartFile uploadFile) throws Exception {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			if(uploadFile!=null && uploadFile.getOriginalFilename()!=null && uploadFile.getOriginalFilename().length()>0){
				//生成一个新的文件名
				//取原始文件名
				String fileName = uploadFile.getOriginalFilename();
				
				//String date = new DateTime().toString("yyyy-MM-dd");
				//生成新文件名，防止重名
				//UUID.randomUUID();
				//String newName = oldName.substring(0,oldName.lastIndexOf("."))+"("+date+")"+oldName.substring(oldName.lastIndexOf("."));
				
				String filePath = "D:\\upload\\temp\\file\\";
				FileUtil fu = new FileUtil();
				String newName = fu.newFile(filePath, fileName);
				
				//新文件
				File file = new File(filePath+newName);
				//将内存中的文件写入磁盘
				uploadFile.transferTo(file);
				//图片上传成功后，将图片的地址写回
				resultMap.put("error", 0);
				resultMap.put("url", "/file/" + newName);
				return resultMap;
			}else{
				//返回结果
				resultMap.put("error", 1);
				resultMap.put("message", "文件异常");
				return resultMap;
			}
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发送异常");
			return resultMap;
		}
	}

	@Override
	public boolean deleteFile(String fileName) throws Exception {
		fileName = fileName.substring(fileName.lastIndexOf("/")+1);
		fileName = "D:\\upload\\temp\\file\\" + fileName;
		FileUtil.deleteFile(fileName);
		return true;
	}

}

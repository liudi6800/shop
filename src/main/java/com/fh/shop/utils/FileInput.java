package com.fh.shop.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class FileInput {

	//接收文件  保存目录   返回保存文件的路径
		public static String saveFile(MultipartFile file,String path,HttpServletRequest request) {
			
					//获取项目的绝对路径   
					String realPath = request.getServletContext().getRealPath("/");
					//指定的目录
					String savePath=realPath+"/"+path+"/";
					//创建目录对象
					File fileStroy=new File(savePath);
					//判断目录是否存在
					boolean exists = fileStroy.exists();
					if(exists==false) {
						//创建目录
						fileStroy.mkdirs();
					}
					//文件的保存目录已经存在

					//对上传的文件 进行重命名
					
					//获取上传文件的名 aaa.jpg  bbb.xlsx  cccc.zip
					String fileName = file.getOriginalFilename();
					//起新名
					String newName=UUID.randomUUID().toString();
					//处理文件格式
					String fileType=fileName.substring(fileName.lastIndexOf("."));
					String newFileName=newName+fileType;
					//拷贝文件
					
					// 输入流  输出流
					
					try {
						FileInputStream is=(FileInputStream) file.getInputStream();
						//输出流
						FileOutputStream os=new FileOutputStream(fileStroy+"/"+newFileName);
						//一次拷贝2kb
						byte[] bts=new byte[1024*2];
						//拷贝的过程
						while(is.read(bts)!=-1) {
							os.write(bts);
						}
						//拷贝完成
						os.close();
						is.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "/"+path+"/"+newFileName;
		}
	
}

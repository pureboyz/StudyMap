package com.pureboyz.studymap.web.ckeditor.act;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;

@Controller
@RequestMapping("/adm")
public class CkeditorFileUploadController
{
	@RequestMapping(value="fileupload.do")
	public @ResponseBody String fileUpload(HttpServletRequest req, HttpServletResponse resp, MultipartHttpServletRequest multiFile) throws Exception
	{
		JsonObject 		json 		= new JsonObject();
		PrintWriter 	printWriter = null;
		OutputStream 	out 		= null;
		MultipartFile 	file 		= multiFile.getFile("upload");
		
		if(file != null)
		{
			if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName()))
			{
				if(file.getContentType().toLowerCase().startsWith("image/"))
				{
					try
					{
						String 	fileName 	= file.getName();
						byte[] 	bytes 		= file.getBytes();
						String 	uploadPath 	= "/home/pureboyz/StudyMap/images";
						File 	uploadFile 	= new File(uploadPath);
						
						if(!uploadFile.exists())
						{
							uploadFile.mkdirs();
						}
						
						fileName 	= UUID.randomUUID().toString();
						uploadPath 	= uploadPath + "/" + fileName;
						out 		= new FileOutputStream(new File(uploadPath));
						
                        out.write(bytes);
                        
                        printWriter = resp.getWriter();
                        resp.setContentType("text/html");
                        
                        String fileUrl = "http://pureboyz.ml:8081/images/" + fileName;
                        
                        json.addProperty("uploaded", 1);
                        json.addProperty("fileName", fileName);
                        json.addProperty("url", fileUrl);
                        
                        printWriter.println(json);
                    }
					catch(IOException e)
					{
                        e.printStackTrace();
                    }
					finally
					{
                        if(out != null)
                        {
                            out.close();
                        }
                        if(printWriter != null)
                        {
                            printWriter.close();
                        }		
					}
				}
			}
		}
		return null;
	}	

}

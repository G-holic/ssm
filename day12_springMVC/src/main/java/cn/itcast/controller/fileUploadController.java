package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class fileUploadController {


    /**
     * 实现文件上传
     *
     * @return
     */
    @RequestMapping("/fileUploadController")
    public String fileUploadController(String username,
                                       MultipartFile uploadFile,
                                       HttpSession session) {
        System.out.println("==>>uploadFile!!!");
        try {
            // 获取文件名称
            String filename = uploadFile.getOriginalFilename();
            // 获取上传路径
            String realPath = session.getServletContext().getRealPath("/WEB-INF/upload/");
            // 判断上传路径是否存在【如不存在，创建】
            File filePath = new File((realPath));
            if (!filePath.exists()){
                filePath.mkdirs();
            }
            // 创建UUID
            String uuid = UUID.randomUUID().toString().replace("-","");
            // 实现文件上传【File.separator:路径分隔符】
//            File uFile = new File(filePath+"/"+filename);
            File uFile = new File(filePath+File.separator+uuid+filename);// 解决文件名重复问题
            uploadFile.transferTo(uFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        return "success";
    }
}

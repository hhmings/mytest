package cn.hhm.workfileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 文件上传 controller
 *
 * @outhor Ming
 * @create 2018-04-03 9:17
 */
@RestController
public class FileUploadController {

    private static Logger log = LoggerFactory.getLogger(FileUploadController.class);

    /**
     * 多文件上传
     *
     * @return
     */
    @PostMapping("/files/upload")
    public String fileUpload(HttpServletRequest request) {
        //MultipartFile
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

        MultipartFile file = null;
        BufferedOutputStream bos = null;

        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    //文件全称
                    String originalPath = file.getOriginalFilename();
                    log.error("文件全称：" + originalPath);
                    //文件名
                    String fileName = originalPath.substring(originalPath.lastIndexOf("\\") + 1, originalPath.indexOf("."));
                    log.error("文件名：" + fileName);
                    //文件后缀
                    String fileSuffix = originalPath.substring(originalPath.lastIndexOf(".") + 1);
                    log.error("fileSuffix："+fileSuffix);
                    //保存

                    bos = new BufferedOutputStream(new FileOutputStream(new File("F://"+fileName+"."+fileSuffix)));
                    byte[] bytes = file.getBytes();
                    bos.write(bytes);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "上传失败";
                }finally {
                        try {
                            if (bos != null){
                                bos.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            return "上传失败";
                        }
                }
            } else {
                return "上传失败";
            }
        }
        return "上传成功";
    }

}

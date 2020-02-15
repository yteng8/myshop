package com.yt.util;

import com.yt.entity.image.ImageName;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FileUploadUtils
 * @Description 图片上传工具类
 * @createTime 2020年02月14日 14:38:00
 */
@Component
public class FileUploadUtils {

    /**
     * 获取文件上传名称后缀名
     * @param multipartFile
     * @return
     */
    public String getUploadFileName(MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        return originalFilename.substring(originalFilename.lastIndexOf('.')+1);
    }

    /**
     * 上传文件并返回新文件名
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        // 一般决定于项目设计的时候时规范的路径
        String dirPath = "E:\\IDEA_workspace\\myshopImg\\";
        File filePath = new File(dirPath);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }

        // 使用uuid唯一标识文件
        String newFilename = UUID.randomUUID() + "_" + originalFilename;
        // 设置文件保存路径和名字
        multipartFile.transferTo(new File(filePath + "/" + newFilename));
        return newFilename;
    }

    /**
     * 判断是否是一张图片
     * @param multipartFile
     * @return
     */
    public boolean isImage(MultipartFile multipartFile){
        boolean flag=false;
        String h = getUploadFileName(multipartFile).toLowerCase();
        if (h.equals("jpg")||h.equals("bmp")||h.equals("jpeg")||h.equals("gif")||h.equals("psd")||h.equals("png")||h.equals("tiff")||h.equals("svg")||h.equals("swf")||h.equals("jfif")){
            flag = true;
        }
        return flag;
    }

    /**
     * 删除图片
     * @param imageName
     * @return
     */
    public boolean removeImage(ImageName imageName){
        String imagePath1 = "E:\\IDEA_workspace\\myshopImg\\"+imageName.getPic1();
        String imagePath2 = "E:\\IDEA_workspace\\myshopImg\\"+imageName.getPic2();
        String imagePath3 = "E:\\IDEA_workspace\\myshopImg\\"+imageName.getPic3();
        String imagePath4 = "E:\\IDEA_workspace\\myshopImg\\"+imageName.getMainPic();
        File file1 = new File(imagePath1);
        File file2 = new File(imagePath2);
        File file3 = new File(imagePath3);
        File file4 = new File(imagePath4);
        if (file1.delete() && file2.delete() && file3.delete() && file4.delete()){
            return true;
        }else {
            return false;
        }
    }
}

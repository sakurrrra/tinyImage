package com.nolife.utils;

import com.nolife.common.Constants;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *description 图片上传压缩
 *@author xierl
 *date 2020/3/15
 */
public class CompressUtil {

    public static List<Map<String,Object>> compress(HttpServletRequest request) throws Exception {

//        // 1.创建DiskFileItemFactory对象，配置缓存用
//        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//
//        // 2. 创建 ServletFileUpload对象
//        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
//
//        // 3. 设置文件名称编码
//        servletFileUpload.setHeaderEncoding("utf-8");

        // 4. 开始解析文件
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Iterator<String> fileNames = multipartRequest.getFileNames();

        // 图片压缩完成返回的数据对象
        List<Map<String,Object>> compressList = new ArrayList<>();
        InputStream is = null;
        ImageWriter writer = null;
        OutputStream os = null;
        ImageOutputStream ios = null;
        try {
            while (fileNames.hasNext()) {
                MultipartFile uploadFile = multipartRequest.getFile(fileNames.next());
                // 生成一个新的文件名
                String oldName = uploadFile.getOriginalFilename();
                // 文件后缀
                String suffix = oldName.substring(oldName.lastIndexOf('.'));
                String imageType = suffix.substring(1);

                // 生成新图片名
                String newName = IDUtils.genImageName();
                newName = newName + suffix;

                // 保存地址按日期区分
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String datePath = sdf.format(date);

                // 获取保存路径
//				String path = request.getSession().getServletContext().getRealPath("/pictureUpload");// request.getRealPath("/pictureUpload");
//                String path = "src/main/resources/static/images/"+datePath+"/";
                String path = "images/"+datePath+"/";

                // 判断保存路径是否存在-不存在则新建
                File saveFile = new File(path);
                if (!saveFile.exists()) {
                    saveFile.mkdirs();
                }

                // 图片压缩--并且--保存
                // 获取上传图片的ImageWriter
                is = uploadFile.getInputStream();
                BufferedImage image = ImageIO.read(is);

                // 指定写图片的方式为 jpg,png
                writer =  ImageIO.getImageWritersByFormatName(imageType).next();

                // 先指定Output，才能调用writer.write方法
                File newFile = new File(path, newName);
                os = new FileOutputStream(newFile);
                ios = ImageIO.createImageOutputStream(os);
                writer.setOutput(ios);

                ImageWriteParam param = writer.getDefaultWriteParam();
                if (param.canWriteCompressed()){
                    // 指定压缩方式为MODE_EXPLICIT
                    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                    // 压缩程度，参数qality是取值0~1范围内
                    param.setCompressionQuality(Constants.COMPRESS_QUALITY);
                }
                // 调用write方法，向输入流写图片
                writer.write(null, new IIOImage(image, null, null), param);

                // 构建返回结果
                Map<String,Object> map = new HashMap<>();
                map.put("path",Constants.SERVER_HOST+"/"+path+newName);
//                map.put("path","http://localhost:9001/tiny/images/"+datePath+"/"+newName);
                map.put("inSize",uploadFile.getSize());
                map.put("outSize", newFile.length());
                compressList.add(map);
            }
            return compressList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if(is!=null)is.close();
            if(os!=null)os.close();
            if(ios!=null)ios.close();
            if(writer!=null)writer.dispose();
        }
    }

    /**
     *  将图片输入流压缩保存到传入的路径
     * @param is 原图片输入流
     * @param descFilePath 保存路径
     * @Exception IOException io
     */
    public static void  compressPic(InputStream is, String descFilePath) throws IOException {
        BufferedImage image = ImageIO.read(is);

        // 指定写图片的方式为 jpg
        ImageWriter writer =  ImageIO.getImageWritersByFormatName("jpg").next();

        // 先指定Output，才能调用writer.write方法
        File output = new File(descFilePath);
        OutputStream out = new FileOutputStream(output);
        ImageOutputStream ios = ImageIO.createImageOutputStream(out);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();
        if (param.canWriteCompressed()){
            // 指定压缩方式为MODE_EXPLICIT
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            // 压缩程度，参数qality是取值0~1范围内
            param.setCompressionQuality(Constants.COMPRESS_QUALITY);
        }
        // 调用write方法，向输入流写图片
        writer.write(null, new IIOImage(image, null, null), param);

        out.close();
        ios.close();
        writer.dispose();
    }
}

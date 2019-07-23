package com.it100000.controller.file;

import com.it100000.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @author 杨新杰
 * @date 2019/7/2213:41
 */
@Slf4j
@Validated
@Controller
@RequestMapping("/file")
public class FileController {

    /**
     *
     * 获取文件
     * @param response 响应
     * @param fileId  文件id
     * @author 杨新杰
     * @date   2019/7/22 13:53
     **/
    @RequestMapping(value = "/getFile")
    public void getFile(HttpServletResponse response, String fileId) throws Exception {
        // 获取文件路劲
        if (!"".equals(fileId)){
            String fileName = new String(fileId.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            // 获取文件路径
            String path = null;
            File file = new File(path + File.separator + fileName);
            if (file.exists()){
                FileUtil.readFile(file,response);
            }
        }
    }

//
//    /**
//     *
//     * 功能描述:存入图片
//     *
//     * @param   request
//     * @param   response
//     * @param   fileNameStr
//     * @param   fileIdStr
//     * @return: void  {"success":"true"|"false","url":""}
//     * @author: 刘武祥
//     * @date: 2019/1/7 0007 14:45
//     */
//    @RequestMapping(value = "/savaimageMobile.do", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//    @ResponseBody
//    public void saveimageMobile(HttpServletRequest request, HttpServletResponse response, String fileNameStr, String fileIdStr) {
//        response.setContentType("text/plain;charset=UTF-8");
//        Map<String, Object> mapsuccess = new HashMap<String, Object>();
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//
//        // 是否压缩
//        boolean isCompression = true;
//
//        /** 页面控件的文件流 **/
//        MultipartFile multipartFile = multipartRequest.getFile(fileNameStr);
//        if (multipartFile == null) {
//            multipartFile = multipartRequest.getFile(fileIdStr);
//        }
//        /** 获取文件的后缀 **/
//        String fileName = null;
//        try {
//            fileName = new String((multipartFile.getOriginalFilename()).getBytes("iso-8859-1"), "utf-8");
//        } catch (UnsupportedEncodingException e1) {
//            e1.printStackTrace();
//        }
//        File imageFile = createImageFile(fileName);
//
//
//        try {
//            //获取文件信息，包括文件大小
//            FileInputStream fis = new FileInputStream(imageFile);
//            // 小于10kb 就不要压缩了
//            if (fis.available() / 1000 < 13) {
//                isCompression = false;
//            }
//
//            // 压缩
//            if (isCompression) {
//                CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
//                DiskFileItem fi = (DiskFileItem) cf.getFileItem();
//                File newFile = fi.getStoreLocation();
//                // 对服务器上的临时文件进行处理
//                Image srcFile = ImageIO.read(newFile);
//                int w = srcFile.getWidth(null);
//                int h = srcFile.getHeight(null);
//                //按比例缩放或扩大图片大小，将浮点型转为整型
//                int width = (int) (w * ImageToolsController.imageRate);
//                int height = (int) (h * ImageToolsController.imageRate);
//                // 宽,高设定
//                BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//                tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
//                FileOutputStream fstream = new FileOutputStream(imageFile);
//                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fstream);
//                JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
//                // 压缩质量
//                jep.setQuality((float) 0.8, true);
//                encoder.encode(tag, jep);
//                fstream.close();
//            } else {
//                // 小于10kb就不压缩了
//                FileOutputStream fstream = new FileOutputStream(imageFile);
//                BufferedOutputStream stream = null;
//                stream = new BufferedOutputStream(fstream);
//                stream.write(multipartFile.getBytes());
//                stream.close();
//            }
//
//            mapsuccess.put("success", "success");
//            mapsuccess.put("error", 0);
//            //mapsuccess.put("url", request.getRequestURL()+ "?imageid=" + imageFile.getName());
//            mapsuccess.put("url_location", imageShowURL + "?imageid=" + imageFile.getName());
//            mapsuccess.put("url", imageFile.getName());
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//            mapsuccess.put("error", "lose");
//            mapsuccess.put("message", "上传失败。");
//            System.out.println("上传失败。");
//        }
//        JSONObject jsonObject = JSONObject.fromObject(mapsuccess);
//        String willreturn = jsonObject.toString();
//        System.out.println("willreturn===" + willreturn);
//        try {
//            response.getWriter().write(willreturn);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 功能描述: LayUi富文本编辑器上传图片接口
//     *
//     * @param file     CommonsMultipartFile
//     * @param response HttpServletResponse 服务类
//     * @return
//     * @author 杨新杰
//     * @date 2018/10/25 19:12
//     */
//    @RequestMapping(value = "/saveImageLayUi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//    @ResponseBody
//    public void upload(@RequestParam("file") CommonsMultipartFile file, HttpServletResponse response) {
//        response.setContentType("text/plain;charset=UTF-8");
//        // 用作返回
//        Map<String, Object> map = new HashMap<>();
//        Map<String, Object> map2 = new HashMap<>();
//        // 获取文件的后缀
//        String fileName;
//        try {
//            fileName = new String((file.getOriginalFilename()).getBytes("iso-8859-1"), "utf-8");
//            File imageFile = createImageFile(fileName);
//
//            CommonsMultipartFile cf = file;
//            DiskFileItem fi = (DiskFileItem) cf.getFileItem();
//            File newFile = fi.getStoreLocation();
//            /** 对服务器上的临时文件进行处理 */
//            Image srcFile = ImageIO.read(newFile);
//            int w = srcFile.getWidth(null);
//            int h = srcFile.getHeight(null);
//            //按比例缩放或扩大图片大小，将浮点型转为整型
//            int width = (int) (w * ImageToolsController.imageRate);
//            int height = (int) (h * ImageToolsController.imageRate);
//            /** 宽,高设定 */
//            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//            tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
//
//            FileOutputStream fstream = new FileOutputStream(imageFile);
//
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fstream);
//            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
//            /** 压缩质量 */
//            jep.setQuality((float) 0.8, true);
//            encoder.encode(tag, jep);
//            fstream.close();
//
//            map2.put("src", imageShowURL + "?imageid=" + imageFile.getName());//图片url
//            map2.put("title", imageFile.getName());//图片名称，这个会显示在输入框里
//            map.put("code", 0);
//            map.put("msg", "上传成");
//            map.put("data", map2);
//            map.put("url", imageFile.getName());//图片url
//            JSONObject jsonObject = JSONObject.fromObject(map);
//            String willreturn = jsonObject.toString();
//            response.getWriter().write(willreturn);
//        } catch (Exception e1) {
//            map.put("code", 1);//0表示成功，1失败
//            map.put("msg", "上传失败");//提示消息
//            map.put("data", "");
//        }
//    }
//
//
//    /**
//     * 功能描述: Html5+上传文件
//     *
//     * @param response HttpServletResponse 服务类
//     * @return
//     * @author 杨新杰
//     * @date 2018/10/25 19:12
//     */
//    @RequestMapping(value = "/saveImageByPlus", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//    @ResponseBody
//    public void saveImageByPlus(HttpServletResponse response, @RequestParam("file") MultipartFile file) {
//        response.setContentType("text/plain;charset=UTF-8");
//        // 用作返回
//        Map<String, Object> map = new HashMap<>();
//        Map<String, Object> map2 = new HashMap<>();
//
//        // 获取文件的后缀
//        String fileName;
//        try {
//            fileName = new String((file.getOriginalFilename()).getBytes("iso-8859-1"), "utf-8");
//            File imageFile = createImageFile(fileName);
//
//            CommonsMultipartFile cf = (CommonsMultipartFile) file;
//            DiskFileItem fi = (DiskFileItem) cf.getFileItem();
//
//            File newFile = fi.getStoreLocation();
//            /** 对服务器上的临时文件进行处理 */
//            Image srcFile = ImageIO.read(newFile);
//            int w = srcFile.getWidth(null);
//            int h = srcFile.getHeight(null);
//            //按比例缩放或扩大图片大小，将浮点型转为整型
//            int width = (int) (w * ImageToolsController.imageRate);
//            int height = (int) (h * ImageToolsController.imageRate);
//            /** 宽,高设定 */
//            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//            tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
//
//            FileOutputStream fstream = new FileOutputStream(imageFile);
//
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fstream);
//            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
//            /** 压缩质量 */
//            jep.setQuality((float) 0.8, true);
//            encoder.encode(tag, jep);
//            fstream.close();
//
//            map2.put("src", imageShowURL + "?imageid=" + imageFile.getName());//图片url
//            map2.put("title", imageFile.getName());//图片名称，这个会显示在输入框里
//            map.put("code", 0);
//            map.put("msg", "上传成");
//            map.put("data", map2);
//            JSONObject jsonObject = JSONObject.fromObject(map);
//            String willreturn = jsonObject.toString();
//            response.getWriter().write(willreturn);
//        } catch (Exception e1) {
//            map.put("code", 1);//0表示成功，1失败
//            map.put("msg", "上传失败");//提示消息
//            map.put("data", "");
//        }
//    }
//
//    /**
//     * 功能描述: wangEditor文件上传
//     *
//     * @param response HttpServletResponse 服务类
//     * @return
//     * @author 杨新杰
//     * @date 2018/10/25 19:12
//     */
//    @RequestMapping(value = "/saveImageByWangEditor", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//    @ResponseBody
//    public void saveImageByWangEditor(HttpServletResponse response, @RequestParam("file") MultipartFile file) {
//        response.setContentType("text/plain;charset=UTF-8");
//        // 用作返回
//        Map<String, Object> map = new HashMap<>();
//        List<String> list = new LinkedList<>();
//
//        // 获取文件的后缀
//        String fileName;
//        try {
//            fileName = new String((file.getOriginalFilename()).getBytes("iso-8859-1"), "utf-8");
//            File imageFile = createImageFile(fileName);
//
//            CommonsMultipartFile cf = (CommonsMultipartFile) file;
//            DiskFileItem fi = (DiskFileItem) cf.getFileItem();
//
//            File newFile = fi.getStoreLocation();
//            /** 对服务器上的临时文件进行处理 */
//            Image srcFile = ImageIO.read(newFile);
//            int w = srcFile.getWidth(null);
//            int h = srcFile.getHeight(null);
//            //按比例缩放或扩大图片大小，将浮点型转为整型
//            int width = (int) (w * ImageToolsController.imageRate);
//            int height = (int) (h * ImageToolsController.imageRate);
//            /** 宽,高设定 */
//            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//            tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
//
//            FileOutputStream fstream = new FileOutputStream(imageFile);
//
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fstream);
//            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
//            /** 压缩质量 */
//            jep.setQuality((float) 0.8, true);
//            encoder.encode(tag, jep);
//            fstream.close();
//
//            map.put("errno", 0);
//            list.add(imageShowURL + "?imageid=" + imageFile.getName());
//            map.put("data", list);
//            JSONObject jsonObject = JSONObject.fromObject(map);
//            String willreturn = jsonObject.toString();
//            response.getWriter().write(willreturn);
//        } catch (Exception e1) {
//            map.put("code", 1);//0表示成功，1失败
//            map.put("msg", "上传失败");//提示消息
//            map.put("data", "");
//        }
//    }
//
//    /**
//     * 功能描述: Base64图片上传 jpeg
//     *
//     * @param response HttpServletResponse 服务类
//     * @return
//     * @author 杨新杰
//     * @date 2018/11/24 19:12
//     */
//    @RequestMapping(value = "/saveImageByBase64", method = RequestMethod.POST)
//    @ResponseBody
//    public void saveImageByBase64(HttpServletResponse response, String file) {
//        Map<String, Object> map = new HashMap<>();
//        Map<String, Object> map2 = new HashMap<>();
//        // 通过base64来转化图片
//        file = file.replaceAll("data:image/jpeg;base64,", "");
//        BASE64Decoder decoder = new BASE64Decoder();
//        // Base64解码
//        byte[] imageByte = null;
//        try {
//            imageByte = decoder.decodeBuffer(file);
//            for (int i = 0; i < imageByte.length; ++i) {
//                if (imageByte[i] < 0) {
//                    // 调整异常数据
//                    imageByte[i] += 256;
//                }
//            }
//        } catch (Exception e) {
//            map.put("code", 1);//0表示成功，1失败
//            map.put("msg", "上传失败");//提示消息
//            map.put("data", "");
//        }
//        // 生成文件名
//        String files = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ".jpeg";
//        // 生成文件路径
//        String filename = imageURL + "/" + files;
//        try {
//            // 生成文件
//            File imageFile = new File(filename);
//            imageFile.createNewFile();
//            if (!imageFile.exists()) {
//                imageFile.createNewFile();
//            }
//            OutputStream imageStream = new FileOutputStream(imageFile);
//            imageStream.write(imageByte);
//            imageStream.flush();
//            imageStream.close();
//
//            map2.put("src", imageShowURL + "?imageid=" + imageFile.getName());//图片url
//            map2.put("title", imageFile.getName());//图片名称，这个会显示在输入框里
//            map.put("code", 0);
//            map.put("msg", "上传成功");
//            map.put("data", map2);
//            JSONObject jsonObject = JSONObject.fromObject(map);
//            String willreturn = jsonObject.toString();
//
//            response.getWriter().write(willreturn);
//        } catch (Exception e) {
//            map.put("code", 1);//0表示成功，1失败
//            map.put("msg", "上传失败");//提示消息
//            map.put("data", "");
//        }
//    }



}

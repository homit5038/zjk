package com.it100000.controller.file;

import com.it100000.dto.BasicResult;
import com.it100000.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 杨新杰
 * @date 2019/7/2213:41
 */
@Slf4j
@Validated
@Controller
@RequestMapping("/file")
public class FileController {

    /** 文件保存路劲 */
    private String savePath = "F:/联鹏科技/数据融合平台/file";

    /**
     * 获取文件
     *
     * @param response 响应
     * @param fileId   文件id
     * @author 杨新杰
     * @date 2019/7/22 13:53
     **/
    @RequestMapping(value = "/getFile")
    public void getFile(HttpServletResponse response, String fileId) throws Exception {
        // 获取文件路劲
        if (!"".equals(fileId)) {
            String fileName = new String(fileId.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            // 获取文件路径
            File file = new File(savePath + File.separator + fileName);
            if (file.exists()) {
                FileUtil.readFile(file, response);
            }
        }
    }

    /**
     * 文件上传
     *
     * @param file 文件上传目标
     * @author 杨新杰
     * @date 2019/7/24 11:11
     **/
    @RequestMapping(value = "/saveFile", method = RequestMethod.POST)
    @ResponseBody
    public BasicResult saveFile(@NotNull(message = "文件不能为空") MultipartFile file) throws IOException {
        String fileName    = file.getOriginalFilename();
        if (fileName != null){
            String fileSuffix  = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
            String newFile     = FileUtil.getRandomFileName() + '.' + fileSuffix;
            String newFilePath = FileUtil.createNewFile(savePath, newFile);
            if (newFilePath != null){
                // 保存文件
                file.transferTo(new File(newFilePath));
                Map<String,String> resultMap = new HashMap<>(1);
                resultMap.put("fileName:",newFile);
                return BasicResult.successResult(resultMap);
            } else {
                return BasicResult.failureResult();
            }
        } else {
            return BasicResult.failureResult();
        }
    }

}

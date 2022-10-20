package com.greatgump.crm.controller.upload;

import com.greatgump.crm.utils.OSSUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author CodingPang
 * @version V1.0
 * @description OSS文件上传
 * @date 2022/10/21 1:24
 * @since 1.0
 */
@RestController
@RequestMapping("/upload")
@Slf4j
public class OSSController {
  @Autowired
  private OSSUtil ossUtil;

  @PostMapping("/test")
  public String ossTest(@RequestParam("file") MultipartFile multipartFile){
    String url = ossUtil.uploadDocument(multipartFile, "png");
    log.info("url路径：" + url);
    return "文件上传成功！";
  }
}

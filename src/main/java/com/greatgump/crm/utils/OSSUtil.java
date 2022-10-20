package com.greatgump.crm.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.MultipartUpload;
import com.aliyun.oss.model.PutObjectRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author CodingPang
 * @version V1.0
 * @description 阿里云OSS工具类
 * @date 2022/10/20 23:33
 * @since 1.0
 */
@Component
@Slf4j
public class OSSUtil {
  // 地域节点
  private static String ENDPOINT = "oss-cn-chengdu.aliyuncs.com";
  // 访问ID
  private static String ACCESSKEYID = "LTAI5tEnZ23zXdYhRVXzkk3E";
  // 访问地址
  private static String ACCESSKEYSECRET = "5ceJQLeAjA87ZXUyqoejw58GzV2Auj";
  // 填写仓库名称
  private static String BUCKETNAME = "crm-backend-storage";
  // 填写外网访问地址
  private static String SUFFER_URL = "http://crm-backend-storage.oss-cn-chengdu.aliyuncs.com/";


  // 创建OSSClient实例。
  public OSSClient getOSSClient(){
    // 1、创建一个OSSClient对象
      OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESSKEYID, ACCESSKEYSECRET);
      // 判断仓库是否存在
    if (ossClient.doesBucketExist(BUCKETNAME)){
        log.info("====仓库加载成功=====");

    } else {
      // 通过api接口形式创建bucket仓库
      log.info("bucket不存在，创建新的bucket:",BUCKETNAME);
      CreateBucketRequest bucketRequest = new CreateBucketRequest(null);
      bucketRequest.setBucketName(BUCKETNAME);
      bucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
      ossClient.createBucket(bucketRequest);
      ossClient.shutdown();
    }
    return (OSSClient) ossClient;
  }

  /**
   * 基于OOS实现的文件上传
   * @return 上传文件后的url
   */
  public String uploadDocument(MultipartFile multipartFile, String bussessType){
    // 获取OSS连接
    OSSClient ossClient = this.getOSSClient();
    // 获取文件的后缀名称
    String ext = multipartFile.getOriginalFilename(); // 文件名
    ext = ext.substring(ext.lastIndexOf(".")); // 截取点后的名称

    String date = TimeParse.generateUploadFolder("yyyyMMdd");
    // 为避免图片名重名，使用UUID命名
    String uuid = UUID.randomUUID().toString().replace("-","");
    // 组合filename
    StringBuffer preFilename = null;
    preFilename = new StringBuffer();
    String filename = preFilename.append(bussessType).append("/").append(date).append("/").append(uuid)
        .append(ext).toString();
    String url = null;
    // 通过OSSClient来获取上传文件后返回的url
    try {
      ossClient.putObject(BUCKETNAME, filename, new ByteArrayInputStream(multipartFile.getBytes()));
      url = SUFFER_URL + filename;
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      ossClient.shutdown();
    }

    return url;
  }
}

package com.greatgump.testMapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.back.record.BackRecordAllDto;
import com.greatgump.crm.mapper.BackRecordMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/17 19:34
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mybatis-spring-config.xml"}) //spring配置文件
public class TestBackRecordMapper {
  @Autowired
  private BackRecordMapper backRecordMapper;


  @Test
  public void testQueryAllBackRecord(){
    Page<BackRecordAllDto> backRecordPage = new Page<>(1,2); // 使用MybatisPlus对单表进行分页
    Page<BackRecordAllDto> backRecordPage1 = backRecordMapper.queryAllBackRecord(backRecordPage);
    backRecordPage1.getRecords().forEach(System.out::println);
  }
}

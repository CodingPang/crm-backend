package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.entity.BackRecord;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Mapper
public interface BackRecordMapper extends BaseMapper<BackRecord> {

  /**
   * 查询所有的回款记录
   * @param backRecordPage
   * @return
   */
  Page<BackRecord> queryAllBackRecord(Page<BackRecord> backRecordPage);

  /**
   * 分页查询所有的审批记录
   * @param backRecordPage
   * @return
   */
  Page<BackRecord> queryAllBackCheck(Page<BackRecord> backRecordPage);

  /**
   * 带条件查询所有的回款审批
   * @param current
   * @param size
   * @param backRecord
   * @return
   */
  List<BackRecord> selectAllByCondition(@Param("current") Integer current, @Param("size") Integer size,@Param("backRecord") BackRecord backRecord);



  /**
   * 条件查询所有的回款审批
   * @param current 所在页
   * @param size 每页放的记录条数
   * @param checkStatus 审批状态
   * @param submitStartTime 提交开始的时间
   * @param submitEndTime 提交结束的时间
   * @return
   */
  List<BackRecord> selectAllWithCondition(@Param("current") Integer current, @Param("size") Integer size, @Param("checkStatus") Integer checkStatus, @Param("submitStartTime") String submitStartTime, @Param("submitEndTime") String submitEndTime);

  /**
   * 根据主键多表查询回款记录
   * @param id 主键
   * @return
   */
  BackRecord selectByPrimaryId(@Param("id") Integer id);

  /**
   * 跟新一条记录的审批状态
   * @param id 主键
   * @param checkStatus 审批状态(0表示待审批，1表示已通过，2表示已驳回)
   * @param checkTime 审批时间
   * @return
   */
  boolean updateOne(@Param("bid") Integer id, @Param("checkStatus") Integer checkStatus, @Param("remark") String remark, @Param("checkTime") String checkTime);

  /**
   * 不分页查询所有的审批记录
   * @return
   */
  List<BackRecord> selectAllbackRecord();
}

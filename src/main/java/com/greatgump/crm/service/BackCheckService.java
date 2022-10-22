package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.dto.back.check.BackCheckFuzzyQuery;
import com.greatgump.crm.dto.back.check.ChangeChecker;
import com.greatgump.crm.dto.back.common.BackAllFuzzyQuery;
import com.greatgump.crm.dto.back.common.CheckRecorderDto;
import com.greatgump.crm.entity.BackRecord;
import java.util.List;

/**
 * <p>
 * 回款审批 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
public interface BackCheckService extends IService<BackRecord> {

  /**
   * 查询所有的回款审批对象
   * @param backCheckPage
   * @return
   */
  Page<BackRecord> queryAllBackCheck(Page<BackRecord> backCheckPage);

  /**
   * 条件查询所有的回款审批
   * @param current 所在页
   * @param size 每页放的记录条数
   * @param backRecord 带参数的对象
   * @return
   */
  List<BackRecord> queryAllByCondition(Integer current, Integer size, BackRecord backRecord);

  /**
   * 条件查询所有的回款审批
   * @param current 所在页
   * @param size 每页放的记录条数
   * @param checkStatus 审批状态
   * @param submitStartTime 提交开始的时间
   * @param submitEndTime 提交结束的时间
   * @return
   */
  List<BackRecord> queryAllByCondition(Integer current, Integer size, Integer checkStatus, String submitStartTime, String submitEndTime);

  List<BackRecord> queryAllByCondition(Integer current, Integer size, BackAllFuzzyQuery backAllFuzzyQuery);

  /**
   * 根据回款id找到该回款的所有信息
   * @param id
   * @return
   */
  BackRecord preUpdate(Integer id);

  /**
   * 更新审批状态
   * @param id
   * @param checkStatus
   * @return
   */
  boolean updateOne(Integer id, Integer checkStatus, String remark);

  /**
   * 回款审批条件查询
   * @param current
   * @param size
   * @param backCheckFuzzyQuery
   * @return
   */
  List<BackRecord> queryAllByCondition(Integer current, Integer size, BackCheckFuzzyQuery backCheckFuzzyQuery);

  /**
   *
   * @return
   */
  List<CheckRecorderDto> queryAllCheck();

  /**
   * 更新回款记录的审核人员
   * @param changeChecker
   * @return
   */
  boolean updateBackChecker(ChangeChecker changeChecker);
}

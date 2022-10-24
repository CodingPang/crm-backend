package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.BusinessCustomerDto;
import com.greatgump.crm.dto.BusinessSourceDto;
import com.greatgump.crm.dto.ClueReceiveDto;
import com.greatgump.crm.dto.FollowFromAscriptionDto;
import com.greatgump.crm.dto.clue.CluePreEditDto;
import com.greatgump.crm.entity.FollowForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 跟进表 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-15 04:12:20
 */
@Mapper
public interface FollowFormMapper extends BaseMapper<FollowForm> {

  /**
   * 新增线索
   * @param clueReceiveDto
   * @return
   */
  boolean insertClue(ClueReceiveDto clueReceiveDto);

  /**
   * 编辑/更新线索
   * @param clueReceiveDto
   * @return
   */
  boolean updateClue(ClueReceiveDto clueReceiveDto);

  /**
   * 1、根据id查询这条数据在线索表的记录
   * @param id
   * @return
   */
  CluePreEditDto selectOneClue(Integer id);


  /*
   * 根据商机id删除记录
   */
  @Select("delete f.* from t_follow_form f where f.business_name in (select bussiness_title form t_business where id=#{businessId}) ")
  void deleteByBusinessId(Long businessId);

  /*
   *由商机的增加而
   */
  void addBusinessFollowForm(BusinessSourceDto businessSourceDto);

  /*
  * 查询信息
  * */
  List<BusinessSourceDto> queryNeeds(String businessTitle);
  /*
  * 查询联系人
  */
  List<BusinessCustomerDto> queryPeople(String businessTitle);
  /*
  *归属人员
  */
  List<FollowFromAscriptionDto> queryAscription(String businessTitle);
}

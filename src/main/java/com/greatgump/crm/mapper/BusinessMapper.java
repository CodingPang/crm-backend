package com.greatgump.crm.mapper;

import com.greatgump.crm.dto.*;
import com.greatgump.crm.dto.businessDto.BusinessDto;
import com.greatgump.crm.dto.businessDto.BusinessDto2;
import com.greatgump.crm.dto.businessDto.BusinessSourceDto;
import com.greatgump.crm.dto.finance.cost.BusinessListDto;
import com.greatgump.crm.entity.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 商机管理 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface BusinessMapper extends BaseMapper<Business> {


  /**
   * 查询出所有的商机
   * @return
   */
  List<BusinessListDto> selectAllBusiness();

    List<LoanBusinessDto> queryBusiness();



    /**
     * 查询出所有的商机
     * @return
     */
    List<BusinessDto> listBase(@Param("current") int current, @Param("size") int size);
    /*
    新增商机
     */
    void saveBusiness(BusinessSourceDto businessSourceDto);

    /*
     * 条件查询
     */

    List<BusinessDto> queryBusinessForm(@Param("current") int current, @Param("size") int size, @Param("customerName") String customerName, @Param("businessOrigin") String businessOrigin, @Param("businessStage")String businessStage, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    /*
     *
     *回显数据
     */
    BusinessDto2 queryId(Long id);


    /*
     * 编辑
     */
    void updateBusiness(BusinessSourceDto businessSourceDto);
  List<BusinessTitleDto> listTitle();


}

package com.greatgump.crm.service;

import com.greatgump.crm.dto.*;
import com.greatgump.crm.dto.BusinessTitleDto;
import com.greatgump.crm.dto.businessDto.*;
import com.greatgump.crm.dto.businessDto.BusinessCustomerDto;
import com.greatgump.crm.dto.businessDto.BusinessDto;
import com.greatgump.crm.dto.businessDto.BusinessDto2;
import com.greatgump.crm.dto.businessDto.BusinessSourceDto;
import com.greatgump.crm.dto.businessDto.BussinessDictionaryDto;
import com.greatgump.crm.dto.businessDto.ChasingAddDto;
import com.greatgump.crm.dto.businessDto.ChasingDto;
import com.greatgump.crm.dto.businessDto.OrderBusinessDto;
import com.greatgump.crm.dto.businessDto.OrderFollowDto;
import com.greatgump.crm.entity.Business;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.entity.BusinessOrigin;
import com.greatgump.crm.entity.BusinessStage;

import java.util.List;

/**
 * <p>
 * 商机管理 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface BusinessService extends IService<Business> {

    List<BusinessTitleDto> listTitle();
    /*
       全部商机
       */
    List<BusinessDto> queryAllBusiness(int current, int size);
    /*
    商机来源
    */
    List<BusinessOrigin> queryBusinessOrigin();
    /*
   商机阶段
   */
    List<BusinessStage> queryBusinessStage();

    /*
    关联客户
     */
    List<Customer1Dto> queryAllCustomer();

    /*
     *商机归属
     */

    List<Customer1Dto> queryCustomerAscription();

    /*
    添加商机
    */
    void saveBusiness(BusinessSourceDto businessSourceDto);

    /*
    表单查询
    */
    List<BusinessDto> queryBusinessForm(BussinessDictionaryDto bussinessDictionaryDto);

    /*
     * 单个删除
     */
    void deleteBusiness(Long id);

    /*
     * 批量删除
     */
    void deletesBusiness(List<Long> ids);

    /*
     *回显编辑映射
     *
     */
    BusinessDto2 queryId(Long id);
    /*
     *编辑数据
     */
    void updateBusiness(BusinessSourceDto businessSourceDto);
    /*
     *跟进回显
     */
    ChasingDto queryChasing(int id);

    /*
     *添加跟进
     */
    void saveChasing(ChasingAddDto chasingAddDto);
    /*
     * 点击标题跳转
     * */
    List<BusinessSourceDtos> queryInformation(String businessTitle);
    /*
     *联系人
     */
    List<BusinessCustomerDto> queryPeople(String businessTitle);
    /*
     * 跟进记录
     */
    List<FollowDetailsDto> queryChasingPlans(String businessTitle);

    /*
     *单个跟进记录
     */
    FollowDetailsDto queryChasingPlan(String userName, String progressiveTime);

    /*
     *跟进计划
     */
    List<FollowPlan1Dto> queryFollowPlan(String businessTitle);

    /*
     * 跟进计划条件查询
     */
    List<FollowPlan1Dto> queryFollowPlan1(String title,String planProgress);

    /*
     *产品报价
     */
    List<ProductPlanDto> queryProductPlan(String businessTitle);
    /*
     *产品报价单条删除
     */
    void deleteProduct(int id);
    /*
     *产品报价批量删除
     */
    void deleteProducts(List<Integer> ids);
    /*
     *查找报价记录等
     */
    ProductCountDto queryCount(String businessTitle);
    /*
     *查找关联订单
     */
    List<OrderBusinessDto> queryBusinessOder(String businessTitle);

    /*
     * 关联订单跟进
     *
     */
    OrderFollowDto addOrderFollow(Long id);

    /*
     *关联订单删除
     */
    void deleteOder(Long id);
    /*
     * 相关附件查询
     */
    List<UplodeEnclosureDto> queryEnclosure(String businessTitle);
    /*
     *相关附件单个删除
     */
    void deleteEnclosure(Long id);

    /*
     *归属信息
     */
    List<FollowFromAscriptionDto> queryAscription(String businessTitle);
    List<LoanBusinessDto> queryBusiness();



}

package com.greatgump.crm.service.impl;

import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.mapper.*;
import com.greatgump.crm.service.BusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商机管理 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    @Autowired
    private BusinessOriginMapper businessOriginMapper;

    @Autowired
    private BusinessStageMapper businessStageMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FollowFormMapper followFormMapper;

    @Autowired
    private ChasingRecordMapper chasingRecordMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private UploadAttachmentMapper uploadAttachmentMapper;

    @Autowired
    private FollowPlanMapper followPlanMapper;

    @Override
    public List<BusinessDto> queryAllBusiness(int current, int size) {

        List<BusinessDto> businessDtos = businessMapper.listBase(current, size);
        return businessDtos;
    }

    @Override
    public List<BusinessOrigin> queryBusinessOrigin() {
        List<BusinessOrigin> businesses = businessOriginMapper.selectList(null);
        return businesses;

    }

    @Override
    public List<BusinessStage> queryBusinessStage() {
        List<BusinessStage> businesses = businessStageMapper.selectList(null);
        return businesses;
    }

    @Override
    public List<Customer1Dto> queryAllCustomer(){
        List<Customer1Dto> customers = this.customerMapper.selectCustomerRelation();
        return customers;
    }

    @Override
    public List<Customer1Dto> queryCustomerAscription() {
        List<Customer1Dto> customers = this.customerMapper.selectCustomerAscription();
        return customers;
    }

    @Override
    public void addBusiness(BusinessSourceDto businessSourceDto) {
        this.businessMapper.addBusiness(businessSourceDto);
        this.followFormMapper.addBusinessFollowForm(businessSourceDto);
    }

    @Override
    public List<BusinessDto> queryBusinessForm(BussinessDictionaryDto bussinessDictionaryDto) {
        String shopTime=bussinessDictionaryDto.getShapTime();
        String startTime = null;
        String endTime = null;
        Date startDate = null;
        Date endDate = null;
        if (shopTime != null && !shopTime.equals("")){
            String[] times = shopTime.split("~");
            startTime = times[0];
            endTime = times[1];

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                startDate = sdf.parse(startTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                endDate = sdf.parse(endTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        List<BusinessDto> list=this.businessMapper.queryBusinessForm(bussinessDictionaryDto.getCurrent(),bussinessDictionaryDto.getSize(),bussinessDictionaryDto.getCustomerName(),bussinessDictionaryDto.getBusinessOrigin(),bussinessDictionaryDto.getBusinessStage(),startDate,endDate);

        return list;
    }

    @Override
    public void deleteBusiness(Long id) {
        this.businessMapper.deleteById(id);
    }

    @Override
    public void deletesBusiness(List<Long> ids) {
        this.businessMapper.deleteBatchIds(ids);
    }

    @Override
    public BusinessDto2 queryId(Long id) {
        BusinessDto2 list=this.businessMapper.queryId(id);
        return list;
    }


    @Override
    public void updateBusiness(BusinessSourceDto businessSourceDto) {
        this.businessMapper.updateBusiness(businessSourceDto);
        this.followFormMapper.addBusinessFollowForm(businessSourceDto);
    }

    @Override
    public ChasingDto queryChasing(Long id) {
        ChasingDto chasingDto = this.businessMapper.queryChasing(id);
        return chasingDto;
    }

    @Override
    public void addChasing(ChasingAddDto chasingAddDto) {
        this.chasingRecordMapper.addChasing(chasingAddDto);
    }

    @Override
    public  List<BusinessSourceDto> queryInformation(String businessTitle) {
        List<BusinessSourceDto> businessSourceDtos = this.followFormMapper.queryNeeds(businessTitle);
        return businessSourceDtos;
    }

    @Override
    public List<BusinessCustomerDto> queryPeople(String businessTitle) {
        this.followFormMapper.queryPeople(businessTitle);
        return null;
    }

    @Override
    public List<FollowDetailsDto> queryChasingPlans(String businessTitle) {
        List<FollowDetailsDto> followDetailsDtos = this.chasingRecordMapper.queryChasingPlans(businessTitle);
        return followDetailsDtos;
    }

    @Override
    public FollowDetailsDto queryChasingPlan(String userName, Date progressiveTime) {
        FollowDetailsDto followDetailsDto = this.chasingRecordMapper.queryChasingPlan(userName, progressiveTime);
        return followDetailsDto;
    }

    @Override
    public List<FollowPlan1Dto> queryFollowPlan(String businessTitle) {
        List<FollowPlan1Dto> followPlan1Dtos = this.followPlanMapper.queryFollowPlan(businessTitle);
        return followPlan1Dtos;
    }

    @Override
    public List<FollowPlan1Dto> queryFollowPlan1(String title, String planProgress) {
        List<FollowPlan1Dto> followPlan1Dtos = this.followPlanMapper.queryFollowPlan1(title,planProgress);
        return followPlan1Dtos;
    }

    @Override
    public List<ProductPlanDto> queryProductPlan(String businessTitle) {
        List<ProductPlanDto> productPlanDtos = this.productMapper.queryProductPlan(businessTitle);
        return productPlanDtos;
    }

    @Override
    public void deleteProduct(int id) {
        this.productMapper.deleteById(id);
    }

    @Override
    public void deleteProducts(List<Integer> ids) {
         this.productMapper.deleteBatchIds(ids);
    }

    @Override
    public ProductCountDto queryCount(String businessTitle) {
        this.productMapper.queryCount(businessTitle);
        return null;
    }

    @Override
    public List<OrderBusinessDto> queryBusinessOder(String businessTitle) {
        List<OrderBusinessDto> orderBusinessDtos = this.orderMapper.queryBusinessOder(businessTitle);
        return orderBusinessDtos;
    }

    @Override
    public OrderFollowDto addOrderFollow(Long id) {
        OrderFollowDto orderFollowDto = this.followMapper.addOrderFollow(id);
        return orderFollowDto;
    }

    @Override
    public void deleteOder(Long id) {
        this.orderMapper.deleteById(id);
    }

    @Override
    public List<UplodeEnclosureDto> queryEnclosure(String businessTitle) {
        List<UplodeEnclosureDto> uplodeEnclosureDtos = this.uploadAttachmentMapper.queryEnclosure(businessTitle);
        return uplodeEnclosureDtos;
    }

    @Override
    public void deleteEnclosure(Long id) {
        this.uploadAttachmentMapper.deleteById(id);
    }

    @Override
    public List<FollowFromAscriptionDto> queryAscription(String businessTitle) {
        List<FollowFromAscriptionDto> followFromAscriptionDtos = this.followFormMapper.queryAscription(businessTitle);

        return followFromAscriptionDtos;
    }

}

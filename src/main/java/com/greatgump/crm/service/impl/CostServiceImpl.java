package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.finance.cost.BusinessListDto;
import com.greatgump.crm.dto.finance.cost.CostAddDto;
import com.greatgump.crm.dto.finance.cost.CostDetailDto;
import com.greatgump.crm.dto.finance.cost.CostDto;
import com.greatgump.crm.dto.finance.cost.CostQueryDto;
import com.greatgump.crm.dto.finance.cost.CostTypeDto;
import com.greatgump.crm.dto.finance.cost.CustomerList;
import com.greatgump.crm.dto.finance.cost.OrderListDto;
import com.greatgump.crm.dto.finance.cost.PrincipalDto;
import com.greatgump.crm.dto.finance.cost.comm.CostCommFuzzyQuery;
import com.greatgump.crm.entity.Business;
import com.greatgump.crm.entity.Cost;
import com.greatgump.crm.entity.Order;
import com.greatgump.crm.mapper.BusinessMapper;
import com.greatgump.crm.mapper.CostMapper;
import com.greatgump.crm.mapper.CustomerMapper;
import com.greatgump.crm.mapper.OrderMapper;
import com.greatgump.crm.mapper.UserMapper;
import com.greatgump.crm.service.CostService;
import com.greatgump.crm.utils.NoGenerateUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Service
public class CostServiceImpl extends ServiceImpl<CostMapper, Cost> implements CostService {


  @Autowired
  private CostMapper costMapper;

  @Autowired
  private CustomerMapper customerMapper;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private OrderMapper orderMapper;

  @Autowired
  private BusinessMapper businessMapper;



  @Override
  public Page<CostQueryDto> queryAllCost(Page<CostQueryDto> costQueryDtoPage) {
    return costMapper.selectAllCost(costQueryDtoPage);
  }


  @Override
  public List<CostQueryDto> queryAllCost(int current, int size,
      CostCommFuzzyQuery costCommFuzzyQuery) {
    if (current != 0 && size != 0){
      List<CostQueryDto> costQueryDtos = costMapper.selectAllCosts((current - 1) * size, size, costCommFuzzyQuery);
      return costQueryDtos;
    }
    return null;
  }

  @Override
  public List<CostTypeDto> getAllCostType() {
    // 费用类型(0表示招待费，1表示交通费，2表示住宿费，3表示礼品费，4表示其他)
    CostTypeDto costTypeDto01 = new CostTypeDto(0, "招待费");
    CostTypeDto costTypeDto02 = new CostTypeDto(1, "交通费");
    CostTypeDto costTypeDto03 = new CostTypeDto(2, "住宿费");
    CostTypeDto costTypeDto04 = new CostTypeDto(3, "礼品费");
    CostTypeDto costTypeDto05 = new CostTypeDto(4, "其他");

    List<CostTypeDto> costTypeDtos = new ArrayList<>();
    costTypeDtos.add(costTypeDto01);
    costTypeDtos.add(costTypeDto02);
    costTypeDtos.add(costTypeDto03);
    costTypeDtos.add(costTypeDto04);
    costTypeDtos.add(costTypeDto05);

    return costTypeDtos;
  }

  @Override
  public HashMap<String, Object> preAdd() {
    HashMap<String, Object> map = new HashMap<>();

    // 1、准备费用类型列表
    List<CostTypeDto> allCostType = getAllCostType();
    map.put("allCostType",allCostType);

    // 2、准备所有的客户
    List<CustomerList> allCustomers = customerMapper.queryAllCustomerList();
    map.put("allCustomers", allCustomers);

    // 3、准备负责人员(PrincipalDto)列表
    List<PrincipalDto> allPrincipalDtos = userMapper.queryAllPrincipalDto();
    map.put("allPrincipalDtos", allPrincipalDtos);

    // 4、准备订单列表
    List<OrderListDto> allOrderListDtos = orderMapper.selectOrderListDto();
    map.put("allOrderListDtos", allOrderListDtos);

    // 5、准备商机列表
    List<BusinessListDto> allBusiness = businessMapper.selectAllBusiness();
    map.put("allBusiness", allBusiness);

    return map;
  }


  @Override
  public boolean saveCost(CostAddDto costAddDto) {
    // 1、根据订单的ID生成费用编号
    String costNo = NoGenerateUtils.getCostCode(
        Integer.valueOf(Math.toIntExact(costAddDto.getOrder().getId())));
    // 2、将费用编号放进Dto类
    costAddDto.setCostNo(costNo);
   boolean flag = costMapper.insertOneCost(costAddDto);
    return flag;
  }

  @Override
  public CostDetailDto getOnCost(Integer id) {
    return costMapper.selectOneById(id);

  }

  @Override
  public boolean deleteByPrimary(Integer id) {
    int result = costMapper.deleteById(id);
    if (result != 0){
      return true;
    }
    return false;
  }
}

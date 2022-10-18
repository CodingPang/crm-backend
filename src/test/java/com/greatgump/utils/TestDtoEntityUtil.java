package com.greatgump.utils;

import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import com.greatgump.crm.dto.back.BackRecordPreDto;
import com.greatgump.crm.dto.power.UserDto;
import com.greatgump.crm.entity.BackPeriod;
import com.greatgump.crm.entity.BackRecord;
import com.greatgump.crm.entity.TransferType;
import com.greatgump.crm.utils.DtoEntityUtil;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/17 16:18
 * @since 1.0
 */
public class TestDtoEntityUtil {

  @Test
  public void testDtoToEntity(){
    // 1、准备数据
    // 1、封装关联客户列表
    CustomerDto customerDto01 = new CustomerDto();
    customerDto01.setId(1L);
    customerDto01.setCustomerName("张三");

    CustomerDto customerDto02 = new CustomerDto();
    customerDto02.setId(2L);
    customerDto02.setCustomerName("李四");

    List<CustomerDto> customerDtos = new ArrayList<>();
    customerDtos.add(customerDto01);
    customerDtos.add(customerDto02);

    // 2、封装关联订单列表
    OrderDto orderDto01 = new OrderDto(1L,"订单标题一");
    OrderDto orderDto02 = new OrderDto(2L,"订单标题二");
    List<OrderDto> orderDtos = new ArrayList<>();
    orderDtos.add(orderDto01);
    orderDtos.add(orderDto02);

    // 3、付款方式列表封装
    TransferType type01 = new TransferType(1L,"现金");
    TransferType type02 = new TransferType(2L,"对公转账");
    List<TransferType> transferTypes = new ArrayList<>();
    transferTypes.add(type01);
    transferTypes.add(type02);

    // 4、回款期次列表封装
    BackPeriod backPeriod01 = new BackPeriod(1L,"第一期");
    BackPeriod backPeriod02 = new BackPeriod(2L,"第二期");
    BackPeriod backPeriod03 = new BackPeriod(2L,"第三期");
    List<BackPeriod> backPeriods = new ArrayList<>();
    backPeriods.add(backPeriod01);
    backPeriods.add(backPeriod02);
    backPeriods.add(backPeriod03);

    // 5、收款人员列表封装
    UserDto userDto01 = new UserDto(1L,"张宏");
    UserDto userDto02 = new UserDto(2L,"张大仙");
    List<UserDto> userDtos = new ArrayList<>();
    userDtos.add(userDto01);
    userDtos.add(userDto02);


    BackRecordPreDto backRecordPreDto = new BackRecordPreDto(customerDtos,orderDtos,backPeriods,transferTypes,userDtos); // 将需要的列表(List对象封装好的)放进BackPlanDto

    BackRecord backRecord = DtoEntityUtil.trans(backRecordPreDto, BackRecord.class);
    System.out.println(backRecord);
  }

}

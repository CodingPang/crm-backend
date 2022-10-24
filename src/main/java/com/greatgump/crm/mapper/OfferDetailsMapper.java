package com.greatgump.crm.mapper;

import com.greatgump.crm.entity.OfferDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface OfferDetailsMapper extends BaseMapper<OfferDetails> {


    int countNumber();

    double totalMoney();

    List<OfferDetails> listBycompany(@Param("id") int id, @Param("current") int current,@Param("size") int size);

    Long listBycompanyCount(int id);

    List<OfferDetails> listBycompanyUpdate(int id, int current, int size, int orderid);

    Long listBycompanyCountUpdate(int id, int orderid);
}

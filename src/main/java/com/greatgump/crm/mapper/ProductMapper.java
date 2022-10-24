package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ProductCountDto;
import com.greatgump.crm.dto.ProductListDto;
import com.greatgump.crm.dto.ProductPlanDto;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.dto.LuoDto1;
import com.greatgump.crm.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 产品库 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    //    zhuiyi add
//    IPage<Product> selectByPage(IPage<Product> page, @Param(Constants.WRAPPER) Wrapper<Product> wrapper);
    List<Product> selectByPage( @Param(Constants.WRAPPER) Wrapper<Product> wrapper);





    List<LuoDto1> listIneed(@Param("customerId")int customerId,@Param("current")int current, @Param("size")int size);

    Page<ProductDto> queryAllProducts(Page page);







    QueryProductDto queryBid(Integer id);

    int updateProduct(UpdeProductDto updeProductDto);


    Page<ProductListDto> listAll(Page<ProductListDto> productListDtoPage);

    List<ProductDto> searchList(ProductSearch productSearch);

    /*
     *
     *报价计划
     */
    List<ProductPlanDto> queryProductPlan(String businessTitle);

    /*
     *求报价记录
     */
    ProductCountDto queryCount(String businessTitle);
}

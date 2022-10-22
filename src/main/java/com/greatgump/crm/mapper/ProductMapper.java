package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.LoanDto;
import com.greatgump.crm.dto.ProductCountDto;
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

    List<LuoDto1> listIneed();

    List<LuoDto1> listIneed(@Param("current")int current, @Param("size")int size);

    Page<ProductDto> queryAllProducts(Page page);

    int insertProduct(AddProductDto addProductDTO);

    QueryProductDto queryBid(Integer id);

    int updateProduct(UpdeProductDto updeProductDto);

    boolean deleteProduct(Integer id);

    List<ProductBox1Dto> getAssort();

    List<ProductBox2Dto> getClacUnit();

    List<ProductBox3Dto> getProperty();


    List<ProductDto> searchList(ProductsearchDto productsearchDto);




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

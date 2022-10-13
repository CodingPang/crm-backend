package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.common.R;
import com.greatgump.crm.dto.BusinessDto;
import com.greatgump.crm.dto.ProductDto;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Offer;
import com.greatgump.crm.entity.Product;
import com.greatgump.crm.service.ProductService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 * 产品库 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "产品库功能说明")
@RestController
@RequestMapping("/crm/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ApiOperation("获取所有产品信息")
    @GetMapping("/products")
    public Result<ProductDto> getAllCustomer(@PathVariable("product") int current,
                                             @PathVariable("size") int size) {
        Page<Customer> customerPage = new Page<>(current, size);
        ProductDto productDto = new ProductDto("CP-0003","服装","男士卫衣","件",new Date());
        return Result.success(productDto);
    }










}

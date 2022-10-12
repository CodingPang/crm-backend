package com.greatgump.crm.controller;

import com.greatgump.crm.common.R;
import com.greatgump.crm.entity.OfferDetails;
import com.greatgump.crm.service.OfferDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@RestController
public class OfferDetailsController {
    @Autowired
    private OfferDetailsService offerDetailsService;

    public R add(List<OfferDetails> offerDetails){
       offerDetailsService.saveBatch(offerDetails);
       return R.ok().put("offerDetails",offerDetails);
    }



}

package com.greatgump.crm.controller;

import com.greatgump.crm.common.R;
import com.greatgump.crm.entity.Clue;
import com.greatgump.crm.entity.Offer;
import com.greatgump.crm.service.ClueService;
import com.greatgump.crm.service.OfferService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.Date;

/**
 * <p>
 * 线索管理 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@RestController
//@RequestMapping("/crm/clue")
public class ClueController {
    @Autowired
    private ClueService clueService;

    @ApiOperation("线索管理页面主界面列表")
    @GetMapping("/crm/clue/list")
    public R list() {
        return R.ok().put("cluelist", clueService.list());
    }

    @ApiOperation("线索管理页面增加")
    @PostMapping("/crm/clue/add")
    public R add(Clue clue) {

        Date date = new Date();
        clue.setLastFollow(date);
        clueService.save(clue);
        return R.ok().put("clueadd", clue);
    }
    @ApiOperation("线索管理页面删除")
    @DeleteMapping("/crm/clue/delete")
    public R delete(Long id) {
        clueService.removeById(id);
        return R.ok().put("cldudelete", id);
    }
    @ApiOperation("线索管理页面修改")
    @PutMapping("/crm/clue/update")
    private R update(Clue clue) {

        Date date = new Date();
        clue.setPersonnel(String.valueOf(date));
        clueService.updateById(clue);
        return R.ok().put("clueupdate", clue);
    }




}
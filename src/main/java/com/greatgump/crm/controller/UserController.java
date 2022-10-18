package com.greatgump.crm.controller;

import com.greatgump.crm.dto.UserDto;
import com.greatgump.crm.entity.Dept;
import com.greatgump.crm.entity.User;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "")
@RestController
@RequestMapping("/crm/user")
public class UserController {

/*  @PostMapping("/login")
  public Result<UserDto> login(@RequestBody User user){
    System.out.println("前端用户是：" + user.toString());
    Result<UserDto> userDtoResult = new Result<>();

    return  ;
  }*/

/*  @GetMapping("/users")
  public Result<UserDto> queryAllUsers(){
    UserDto userDto = new UserDto();
    userDto.setDept(new Dept());

    return Result.success(userDto,2L);
  }*/
}

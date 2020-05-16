package com.mingx.user.controller;

import com.alibaba.druid.sql.visitor.functions.Locate;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mingx.common.AppResult;
import com.mingx.common.AppResultBuilder;
import com.mingx.common.ResultCode;
import com.mingx.user.bo.SaveUserBO;
import com.mingx.user.entity.SysUser;
import com.mingx.user.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author fuqiangxin
 * @Classname: SysController
 * @Description: 用户信息控制器
 * @date 2020/5/15 18:47
 */

@RestController
@RequestMapping("/user")
public class SysController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/test")
    public String test() {
        return "可行！！";
    }

    @PostMapping("/saveUser")
    public AppResult<String> saveUser(@Validated @RequestBody SaveUserBO bo) {
        Integer count = sysUserService.count(new QueryWrapper<SysUser>().eq("name", bo.getName()));
        if (count > 0) {
            return AppResultBuilder.error(ResultCode.USER_HAS_EXISTED);
        }
        SysUser user = new SysUser();
        user.setName(bo.getName()).setSex(Integer.valueOf(bo.getSex()))
                .setBirthday(LocalDate.parse(bo.getBirthday(), DateTimeFormatter.ofPattern("yyyyMMdd")))
                .setCreateTime(LocalDateTime.now());
        sysUserService.save(user);
        return AppResultBuilder.success(user.getId());
    }
}

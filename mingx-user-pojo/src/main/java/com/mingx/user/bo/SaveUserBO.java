package com.mingx.user.bo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import com.mingx.common.RegexpContants;
import lombok.Data;

/**
 * @author fuqiangxin
 * @Classname: SaveUserBO
 * @Description: 对应方法名 + BO   添加用户
 * @NotBank注解即是非空注解，标识该字段不能为空
 * @Length注解可设置其字段长度
 * @Pattern注解可进行自定义正则表达式校验，可以将相关正则表达式单独抽取出来，利用之前创建的RegexpContants.java接口，其中定义常用正则表达式即可
 * @date 2020/5/15 18:41
 */
@Data
public class SaveUserBO {

    @NotBlank(message = "用户名称不能为空")
    @Length(max = 10, message = "长度不能超过10个字符")
    private String name;

    @NotBlank(message = "性别不能为空")
    @Pattern(regexp = RegexpContants.ZERO_OR_ONE_EREGEXP, message = "性别格式不正确")
    private String sex;

    @NotBlank(message = "出生日期不能为空")
    @Pattern(regexp = RegexpContants.SIMPLE_DATE_PATTERN_SIMPLE, message = "出生日期格式不正确")
    private String birthday;
}

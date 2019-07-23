package com.it100000.controller.admin;

import com.it100000.dto.BasicResult;
import com.it100000.entity.User;
import com.it100000.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 人员管理
 *
 * @author 杨新杰
 * @date 2019/7/2214:33
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Resource
    private UserService userService;

    /**
     * 通过用户类型查询用户
     * <p>如果type为空则查询全部人员</p>
     *
     * @param type 用户类型
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 9:37
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/queryUserByType", method = RequestMethod.POST)
    public BasicResult queryUserByType(String type) {
        return BasicResult.successResult(userService.queryUserByType(type));
    }

    /**
     * 插入用户
     *
     * @param user 用户实体类
     * @param type admin | patrol
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 9:37
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public BasicResult insertUser(@NotNull(message = "用户信息不能为空") User user,
                                  @NotBlank(message = "用户类型不能为空") String type) {
        if (userService.insertUser(user, type) > 0) {
            return BasicResult.successResult();
        } else {
            return new BasicResult(BasicResult.FAILURE, "[]", "未知错误");
        }

    }


    /**
     * 删除用户
     *
     * @param uId 用户ID
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 9:37
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public BasicResult deleteUser(@NotBlank(message = "用户ID不能为空") String uId) {
        if (userService.deleteUser(uId) > 0) {
            return BasicResult.successResult();
        } else {
            return new BasicResult(BasicResult.FAILURE, "[]", "未知错误");
        }
    }

    /**
     * 删除用户
     *
     * @param uId    用户ID
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @return com.it100000.dto.BasicResult
     * @author 杨新杰
     * @date 2019/7/23 9:37
     **/
    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/updatePwdByUserId", method = RequestMethod.POST)
    public BasicResult updatePwdByUserId(@NotBlank(message = "用户ID不能为空") String uId,
                                         @NotBlank(message = "旧密码不能为空") String oldPwd,
                                         @NotBlank(message = "新密码不能为空") String newPwd) {
        String msg = userService.updatePwdByUserId(uId, oldPwd, newPwd);
        return new BasicResult(BasicResult.FAILURE, "[]", msg);
    }


}

package com.xu.xupicture.interfaces.assembler;

import com.xu.xupicture.domain.user.entity.User;
import com.xu.xupicture.interfaces.dto.user.UserAddRequest;
import com.xu.xupicture.interfaces.dto.user.UserUpdateRequest;
import org.springframework.beans.BeanUtils;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-10
 * 用户对象转换
 */
public class UserAssembler {

    public static User toUserEntity(UserAddRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request, user);
        return user;
    }

    public static User toUserEntity(UserUpdateRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request, user);
        return user;
    }
}

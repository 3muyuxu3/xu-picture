package com.xu.xupicture.domain.space.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xu.xupicture.application.service.SpaceApplicationService;
import com.xu.xupicture.application.service.SpaceUserApplicationService;
import com.xu.xupicture.application.service.UserApplicationService;
import com.xu.xupicture.domain.space.entity.Space;
import com.xu.xupicture.domain.space.entity.SpaceUser;
import com.xu.xupicture.domain.space.service.SpaceUserDomainService;
import com.xu.xupicture.domain.space.valueobject.SpaceRoleEnum;
import com.xu.xupicture.domain.user.entity.User;
import com.xu.xupicture.infrastructure.exception.BusinessException;
import com.xu.xupicture.infrastructure.exception.ErrorCode;
import com.xu.xupicture.infrastructure.exception.ThrowUtils;
import com.xu.xupicture.infrastructure.mapper.SpaceUserMapper;
import com.xu.xupicture.interfaces.dto.spaceuser.SpaceUserAddRequest;
import com.xu.xupicture.interfaces.dto.spaceuser.SpaceUserQueryRequest;
import com.xu.xupicture.interfaces.vo.space.SpaceUserVO;
import com.xu.xupicture.interfaces.vo.space.SpaceVO;
import com.xu.xupicture.interfaces.vo.user.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
* @author 22746
* @description 针对表【space_user(空间用户关联)】的数据库操作Service实现
* @createDate 2025-09-09 18:17:52
*/
@Service
public class SpaceUserDomainServiceImpl implements SpaceUserDomainService {

    @Override
    public QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest) {
        QueryWrapper<SpaceUser> queryWrapper = new QueryWrapper<>();
        if (spaceUserQueryRequest == null) {
            return queryWrapper;
        }
        // 从对象中取值
        Long id = spaceUserQueryRequest.getId();
        Long spaceId = spaceUserQueryRequest.getSpaceId();
        Long userId = spaceUserQueryRequest.getUserId();
        String spaceRole = spaceUserQueryRequest.getSpaceRole();
        queryWrapper.eq(ObjUtil.isNotEmpty(id), "id", id);
        queryWrapper.eq(ObjUtil.isNotEmpty(spaceId), "spaceId", spaceId);
        queryWrapper.eq(ObjUtil.isNotEmpty(userId), "userId", userId);
        queryWrapper.eq(ObjUtil.isNotEmpty(spaceRole), "spaceRole", spaceRole);
        return queryWrapper;
    }
}
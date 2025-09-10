package com.xu.xupicture.domain.space.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xu.xupicture.application.service.SpaceApplicationService;
import com.xu.xupicture.application.service.SpaceUserApplicationService;
import com.xu.xupicture.application.service.UserApplicationService;
import com.xu.xupicture.domain.space.entity.Space;
import com.xu.xupicture.domain.space.entity.SpaceUser;
import com.xu.xupicture.domain.space.repository.SpaceRepository;
import com.xu.xupicture.domain.space.service.SpaceDomainService;
import com.xu.xupicture.domain.space.valueobject.SpaceLevelEnum;
import com.xu.xupicture.domain.space.valueobject.SpaceRoleEnum;
import com.xu.xupicture.domain.space.valueobject.SpaceTypeEnum;
import com.xu.xupicture.domain.user.entity.User;
import com.xu.xupicture.infrastructure.exception.BusinessException;
import com.xu.xupicture.infrastructure.exception.ErrorCode;
import com.xu.xupicture.infrastructure.exception.ThrowUtils;
import com.xu.xupicture.infrastructure.mapper.SpaceMapper;
import com.xu.xupicture.interfaces.dto.space.SpaceAddRequest;
import com.xu.xupicture.interfaces.dto.space.SpaceQueryRequest;
import com.xu.xupicture.interfaces.vo.space.SpaceVO;
import com.xu.xupicture.interfaces.vo.user.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
* @author 22746
* @description 针对表【space(空间)】的数据库操作Service实现
* @createDate 2025-09-08 09:41:32
*/
@Service
public class SpaceDomainServiceImpl implements SpaceDomainService {

    @Resource
    private SpaceRepository spaceRepository;

    @Override
    public QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest) {
        QueryWrapper<Space> queryWrapper = new QueryWrapper<>();
        if (spaceQueryRequest == null) {
            return queryWrapper;
        }
        // 从对象中取值
        Long id = spaceQueryRequest.getId();
        Long userId = spaceQueryRequest.getUserId();
        String spaceName = spaceQueryRequest.getSpaceName();
        Integer spaceLevel = spaceQueryRequest.getSpaceLevel();
        Integer spaceType = spaceQueryRequest.getSpaceType();
        String sortField = spaceQueryRequest.getSortField();
        String sortOrder = spaceQueryRequest.getSortOrder();
        // 拼接查询条件
        queryWrapper.eq(ObjUtil.isNotEmpty(id), "id", id);
        queryWrapper.eq(ObjUtil.isNotEmpty(userId), "userId", userId);
        queryWrapper.like(StrUtil.isNotBlank(spaceName), "spaceName", spaceName);
        queryWrapper.eq(ObjUtil.isNotEmpty(spaceLevel), "spaceLevel", spaceLevel);
        queryWrapper.eq(ObjUtil.isNotEmpty(spaceType), "spaceType", spaceType);
        // 排序
        queryWrapper.orderBy(StrUtil.isNotEmpty(sortField), sortOrder.equals("ascend"), sortField);
        return queryWrapper;
    }

    @Override
    public void fillSpaceBySpaceLevel(Space space) {
        SpaceLevelEnum spaceLevelEnum = SpaceLevelEnum.getEnumByValue(space.getSpaceLevel());
        if (spaceLevelEnum != null) {
            long maxSize = spaceLevelEnum.getMaxSize();
            if (space.getMaxSize() == null) {
                space.setMaxSize(maxSize);
            }
            long maxCount = spaceLevelEnum.getMaxCount();
            if (space.getMaxCount() == null) {
                space.setMaxCount(maxCount);
            }
        }
    }

    @Override
    public void checkSpaceAuth(User loginUser, Space space) {
        // 仅本人或管理员可编辑
        if (!space.getUserId().equals(loginUser.getId()) && !loginUser.isAdmin()) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
    }
}



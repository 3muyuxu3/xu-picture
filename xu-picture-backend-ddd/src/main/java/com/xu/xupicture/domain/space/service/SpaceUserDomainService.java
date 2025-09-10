package com.xu.xupicture.domain.space.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xu.xupicture.domain.space.entity.SpaceUser;
import com.xu.xupicture.interfaces.dto.spaceuser.SpaceUserAddRequest;
import com.xu.xupicture.interfaces.dto.spaceuser.SpaceUserQueryRequest;
import com.xu.xupicture.interfaces.vo.space.SpaceUserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 22746
* @description 针对表【space_user(空间用户关联)】的数据库操作Service
* @createDate 2025-09-09 18:17:52
*/
public interface SpaceUserDomainService {

    /**
     * 获取查询对象
     *
     * @param spaceUserQueryRequest
     * @return
     */
    QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest);
}

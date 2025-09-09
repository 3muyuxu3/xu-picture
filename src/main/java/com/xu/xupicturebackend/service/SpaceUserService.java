package com.xu.xupicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xu.xupicturebackend.model.dto.spaceuser.SpaceUserAddRequest;
import com.xu.xupicturebackend.model.dto.spaceuser.SpaceUserQueryRequest;
import com.xu.xupicturebackend.model.entity.SpaceUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xu.xupicturebackend.model.vo.SpaceUserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 22746
* @description 针对表【space_user(空间用户关联)】的数据库操作Service
* @createDate 2025-09-09 18:17:52
*/
public interface SpaceUserService extends IService<SpaceUser> {

    /**
     * 添加空间用户关联
     *
     * @param spaceUserAddRequest 空间用户关联添加请求
     * @return 新增的空间用户关联ID
     */
    long addSpaceUser(SpaceUserAddRequest spaceUserAddRequest);

    /**
     * 校验空间用户关联
     *
     * @param spaceUser 空间用户关联
     * @param add       是否为新增操作
     */
    void validSpaceUser(SpaceUser spaceUser, boolean add);

    /**
     * 将空间用户关联实体转换为视图对象
     *
     * @param spaceUser 空间用户关联实体
     * @param request   HTTP请求对象
     * @return 空间用户关联视图对象
     */
    SpaceUserVO getSpaceUserVO(SpaceUser spaceUser, HttpServletRequest request);

    /**
     * 将空间用户关联实体列表转换为视图对象列表
     *
     * @param spaceUserList 空间用户关联实体列表
     * @return 空间用户关联视图对象列表
     */
    List<SpaceUserVO> getSpaceUserVOList(List<SpaceUser> spaceUserList);

    /**
     * 获取空间用户关联的查询条件
     *
     * @param spaceUserQueryRequest 空间用户关联查询请求
     * @return 查询条件封装
     */
    QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest);
}

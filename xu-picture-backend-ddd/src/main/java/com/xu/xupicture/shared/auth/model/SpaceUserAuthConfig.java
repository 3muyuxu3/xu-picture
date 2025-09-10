package com.xu.xupicture.shared.auth.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-09
 * 空间成员权限配置
 */
@Data
public class SpaceUserAuthConfig implements Serializable {

    /**
     * 权限列表
     */
    private List<SpaceUserPermission> permissions;

    /**
     * 角色列表
     */
    private List<SpaceUserRole> roles;

    private static final long serialVersionUID = 1L;
}

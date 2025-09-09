package com.xu.xupicturebackend.model.dto.spaceuser;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xu
 * @version 1.0
 * @CreateTime: 2025-09-09
 * 编辑空间成员请求
 */
@Data
public class SpaceUserEditRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 空间角色：viewer/editor/admin
     */
    private String spaceRole;

    private static final long serialVersionUID = 1L;
}
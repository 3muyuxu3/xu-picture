package com.xu.xupicture.interfaces.dto.space;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-08
 * 空间编辑请求
 */
@Data
public class SpaceEditRequest implements Serializable {

    /**
     * 空间 id
     */
    private Long id;

    /**
     * 空间名称
     */
    private String spaceName;

    private static final long serialVersionUID = 1L;
}


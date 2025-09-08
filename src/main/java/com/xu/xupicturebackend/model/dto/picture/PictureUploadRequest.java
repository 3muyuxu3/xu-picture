package com.xu.xupicturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xu
 * @version 1.0
 * @CreateTime: 2025-09-06
 * 图片上传请求
 */
@Data
public class PictureUploadRequest implements Serializable {

    /**
     * 图片 id（用于修改）
     */
    private Long id;

    /**
     * 文件地址
     */
    private String fileUrl;

    /**
     * 图片名称
     */
    private String picName;

    /**
     * 空间 id
     */
    private Long spaceId;

    private static final long serialVersionUID = 1L;
}



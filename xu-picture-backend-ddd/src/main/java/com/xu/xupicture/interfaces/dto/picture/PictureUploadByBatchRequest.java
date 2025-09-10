package com.xu.xupicture.interfaces.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-07
 * 批量导入图片请求
 */
@Data
public class PictureUploadByBatchRequest implements Serializable {

    /**
     * 搜索词
     */
    private String searchText;

    /**
     * 抓取数量
     */
    private Integer count = 10;

    /**
     * 图片名称前缀
     */
    private String namePrefix;

    private static final long serialVersionUID = 1L;
}
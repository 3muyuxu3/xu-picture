package com.xu.xupicturebackend.model.dto.picture;

import lombok.Data;

/**
 * @author xu
 * @version 1.0
 * @CreateTime: 2025-09-07
 * 批量导入图片请求
 */
@Data
public class PictureUploadByBatchRequest {

    /**
     * 搜索词
     */
    private String searchText;

    /**
     * 抓取数量
     */
    private Integer count = 10;

    /**
     * 名称前缀
     */
    private String namePrefix;

    private static final long serialVersionUID = 1L;
}


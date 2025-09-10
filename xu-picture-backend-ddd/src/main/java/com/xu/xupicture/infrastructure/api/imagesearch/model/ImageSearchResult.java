package com.xu.xupicture.infrastructure.api.imagesearch.model;

import lombok.Data;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-08
 */
@Data
public class ImageSearchResult {

    /**
     * 缩略图地址
     */
    private String thumbUrl;

    /**
     * 来源地址
     */
    private String fromUrl;
}

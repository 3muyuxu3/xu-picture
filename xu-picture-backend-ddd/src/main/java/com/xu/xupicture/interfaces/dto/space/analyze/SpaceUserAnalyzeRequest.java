package com.xu.xupicture.interfaces.dto.space.analyze;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-09
 * 空间用户上传行为分析请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SpaceUserAnalyzeRequest extends SpaceAnalyzeRequest {

    /**
     * 用户 ID
     */
    private Long userId;

    /**
     * 时间维度：day / week / month
     */
    private String timeDimension;
}


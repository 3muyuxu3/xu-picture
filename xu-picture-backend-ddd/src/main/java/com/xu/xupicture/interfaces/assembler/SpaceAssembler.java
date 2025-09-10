package com.xu.xupicture.interfaces.assembler;

import com.xu.xupicture.domain.space.entity.Space;
import com.xu.xupicture.interfaces.dto.space.SpaceAddRequest;
import com.xu.xupicture.interfaces.dto.space.SpaceEditRequest;
import com.xu.xupicture.interfaces.dto.space.SpaceUpdateRequest;
import org.springframework.beans.BeanUtils;

/**
 * @author xu
 * @version 2.0
 * @CreateTime: 2025-09-10
 */
public class SpaceAssembler {

    public static Space toSpaceEntity(SpaceAddRequest request) {
        Space space = new Space();
        BeanUtils.copyProperties(request, space);
        return space;
    }

    public static Space toSpaceEntity(SpaceUpdateRequest request) {
        Space space = new Space();
        BeanUtils.copyProperties(request, space);
        return space;
    }

    public static Space toSpaceEntity(SpaceEditRequest request) {
        Space space = new Space();
        BeanUtils.copyProperties(request, space);
        return space;
    }
}

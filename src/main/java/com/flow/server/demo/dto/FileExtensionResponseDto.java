package com.flow.server.demo.dto;

import com.flow.server.demo.domain.FileExtension;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class FileExtensionResponseDto {

    private String extension;

    private boolean isFixed;

    private boolean isUse;

    public FileExtensionResponseDto(FileExtension entity) {
        this.extension = entity.getExtension();
        this.isFixed = entity.isFixed();
        this.isUse = entity.isUse();
    }

}

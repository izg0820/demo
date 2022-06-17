package com.flow.server.demo.dto;

import com.flow.server.demo.domain.FileExtension;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class FileExtensionResponseDto {

    private String extension;

    private boolean fixed;

    public FileExtensionResponseDto(FileExtension entity) {
        this.extension = entity.getExtension();
        this.fixed = entity.isFixed();
    }

}

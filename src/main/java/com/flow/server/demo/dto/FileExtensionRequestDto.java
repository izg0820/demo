package com.flow.server.demo.dto;

import com.flow.server.demo.domain.FileExtension;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class FileExtensionRequestDto {

    private String extension;

    private boolean isFixed;

    private boolean isUse;

    public FileExtensionRequestDto(String extension) {
        this.extension = extension;
        this.isFixed = false;
        this.isUse = true;
    }

    public FileExtensionRequestDto(String extension, boolean isFixed, boolean isUse) {
        this.extension = extension;
        this.isFixed = isFixed;
        this.isUse = isUse;
    }

    public FileExtension toEntity() {
        return new FileExtension(extension, isFixed, isUse);
    }
}

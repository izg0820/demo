package com.flow.server.demo.dto;

import com.flow.server.demo.domain.FileExtension;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
public class FileExtensionResponseDto {

    private String extension;

    private boolean fixed;

    private boolean useYn;

    public FileExtensionResponseDto(FileExtension entity) {
        this.extension = entity.getExtension();
        this.fixed = entity.getFixed();
        this.useYn = entity.getUseYn();
    }

    public String getExtension() {
        return extension;
    }

    public boolean getFixed() {
        return fixed;
    }

    public boolean getUseYn() {
        return useYn;
    }

}

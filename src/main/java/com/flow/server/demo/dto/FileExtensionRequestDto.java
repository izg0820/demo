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

    private boolean fixed;

    public FileExtensionRequestDto(String extension) {
        this.extension = extension;
        this.fixed = false;
    }

    public FileExtensionRequestDto(String extension, boolean fixed) {
        this.extension = extension;
        this.fixed = fixed;
    }

    public FileExtension toEntity() {
        return new FileExtension(extension, fixed);
    }
}

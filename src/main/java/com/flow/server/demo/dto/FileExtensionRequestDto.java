package com.flow.server.demo.dto;

import com.flow.server.demo.domain.FileExtension;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter
public class FileExtensionRequestDto {

    private String extension;

    private boolean fixed;

    private boolean use;

    public FileExtensionRequestDto(String extension) {
        this.extension = extension;
        this.fixed = false;
        this.use = true;
    }

    public FileExtensionRequestDto(String extension, boolean fixed, boolean use) {
        this.extension = extension;
        this.fixed = fixed;
        this.use = use;
    }

    public FileExtension toEntity() {
        return new FileExtension(extension, fixed, use);
    }

    public String getExtension() {
        return extension;
    }

    public boolean getFixed() {
        return fixed;
    }

    public boolean getUse() {
        return use;
    }

}

package com.flow.server.demo.dto;

import com.flow.server.demo.domain.FileExtension;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter
public class FileExtensionRequestDto {

    private String extension;

    private boolean fixed;

    private boolean used;

    public FileExtensionRequestDto(String extension) {
        this.extension = extension;
        this.fixed = false;
        this.used = true;
    }

    public FileExtensionRequestDto(String extension, boolean fixed, boolean used) {
        this.extension = extension;
        this.fixed = fixed;
        this.used = used;
    }

    public FileExtension toEntity() {
        return new FileExtension(extension, fixed, used);
    }

    public String getExtension() {
        return extension;
    }

    public boolean getFixed() {
        return fixed;
    }

    public boolean getUsed() {
        return used;
    }
}

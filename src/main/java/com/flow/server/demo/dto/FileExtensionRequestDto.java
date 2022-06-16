package com.flow.server.demo.dto;

import com.flow.server.demo.domain.FileExtension;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FileExtensionRequestDto {

    private String extension;

    @Builder
    public FileExtensionRequestDto(String extension) {
        this.extension = extension;
    }

    public FileExtension toEntity() {
        return new FileExtension(extension);
    }
}

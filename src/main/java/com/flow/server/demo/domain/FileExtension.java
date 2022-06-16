package com.flow.server.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor @Getter
@Entity
public class FileExtension {
    @Id
    private String extension;

    public FileExtension(String extension) {
        validateLength(extension);
        validateCharacter(extension);
        this.extension = extension;
    }

    private void validateLength(String extension) {
        if (extension.length() > 20) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCharacter(String extension) {
        if (!extension.matches("^[a-zA-Z0-9\\$]*$")) {
            throw new IllegalArgumentException();
        }
    }

}

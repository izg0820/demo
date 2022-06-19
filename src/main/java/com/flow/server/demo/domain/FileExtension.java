package com.flow.server.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor @Getter @Setter
@Entity
public class FileExtension {
    @Id
    private String extension;

    private boolean isFixed;

    private boolean isUse;

    public FileExtension(String extension) {
        validateLength(extension);
        validateCharacter(extension);
        this.extension = extension;
        this.isFixed = false;
        this.isUse = true;
    }

    public FileExtension(String extension, boolean isFixed, boolean isUse) {
        validateLength(extension);
        validateCharacter(extension);
        this.extension = extension;
        this.isFixed = isFixed;
        this.isUse = isUse;
    }

    private void validateLength(String extension) {
        if (extension.length() > 20 && extension.length() > 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCharacter(String extension) {
        if (!extension.matches("^[a-zA-Z0-9\\$]*$")) {
            throw new IllegalArgumentException();
        }
    }

}

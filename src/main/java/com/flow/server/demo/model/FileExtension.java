package com.flow.server.demo.model;

public class FileExtension {
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

package com.flow.server.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor @Setter
@Entity
public class FileExtension {
    @Id
    private String extension;

    private boolean fixed;

    private boolean useYn;

    public FileExtension(String extension) {
        this.extension = extension;
        this.fixed = false;
        this.useYn = true;
    }

    public FileExtension(String extension, boolean fixed, boolean useYn) {
        this.extension = extension;
        this.fixed = fixed;
        this.useYn = useYn;
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

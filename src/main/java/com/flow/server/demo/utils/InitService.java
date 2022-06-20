package com.flow.server.demo.utils;

import com.flow.server.demo.domain.FileExtension;
import com.flow.server.demo.domain.repository.FileExtensionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitService {

    private final FileExtensionRepository fileExtensionRepository;

    public void init() {
        String[] fixedExtensions = Constant.FixedExtenstion;
        for (String fixedExtension : fixedExtensions) {
            fileExtensionRepository.save(new FileExtension(fixedExtension, true, false));
        }
    }
}

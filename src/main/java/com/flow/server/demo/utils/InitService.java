package com.flow.server.demo.utils;

import com.flow.server.demo.controller.FileExtensionController;
import com.flow.server.demo.dto.FileExtensionRequestDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class InitService {

    @Autowired
    private FileExtensionController fileExtensionController;

    public void init() {
        String[] fixedExtensions = Constant.FixedExtenstion;
        for (String fixedExtension : fixedExtensions) {
            fileExtensionController.save(new FileExtensionRequestDto(fixedExtension, true));
        }
    }
}

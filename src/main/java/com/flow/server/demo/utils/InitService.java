package com.flow.server.demo.utils;

import com.flow.server.demo.controller.FileExtensionController;
import com.flow.server.demo.domain.FileExtension;
import com.flow.server.demo.domain.repository.FileExtensionRepository;
import com.flow.server.demo.dto.FileExtensionRequestDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

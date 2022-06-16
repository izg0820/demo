package com.flow.server.demo.controller;

import com.flow.server.demo.domain.FileExtension;
import com.flow.server.demo.dto.FileExtensionRequestDto;
import com.flow.server.demo.dto.FileExtensionResponseDto;
import com.flow.server.demo.service.FileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileExtensionController {

    private final FileExtensionService fileExtensionService;

    @PutMapping("/fileextension")
    public void save(@RequestBody FileExtensionRequestDto fileExtensionRequestDto) {
        fileExtensionService.save(fileExtensionRequestDto);
    }

    @GetMapping("/fileextension")
    public FileExtensionResponseDto findById(String extension) {
        return fileExtensionService.findById(extension);
    }

}

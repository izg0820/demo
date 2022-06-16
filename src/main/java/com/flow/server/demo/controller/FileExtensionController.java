package com.flow.server.demo.controller;

import com.flow.server.demo.dto.FileExtensionRequestDto;
import com.flow.server.demo.dto.FileExtensionResponseDto;
import com.flow.server.demo.service.FileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileExtensionController {

    private final FileExtensionService fileExtensionService;

    @PutMapping("/extension")
    public void save(@RequestBody FileExtensionRequestDto fileExtensionRequestDto) {
        fileExtensionService.save(fileExtensionRequestDto);
    }

    @GetMapping("/extension")
    public FileExtensionResponseDto findById(String extension) {
        return fileExtensionService.findById(extension);
    }

    @DeleteMapping("/extension")
    public void delete(FileExtensionRequestDto requestDto) {
        fileExtensionService.delete(requestDto);
    }

    @GetMapping("extensions")
    public List<FileExtensionResponseDto> findAll() {
        return fileExtensionService.findAll();
    }

}

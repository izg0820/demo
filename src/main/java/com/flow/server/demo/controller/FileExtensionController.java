package com.flow.server.demo.controller;

import com.flow.server.demo.domain.FileExtension;
import com.flow.server.demo.dto.FileExtensionRequestDto;
import com.flow.server.demo.dto.FileExtensionResponseDto;
import com.flow.server.demo.service.FileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FileExtensionController {

    private final FileExtensionService fileExtensionService;

    @GetMapping
    public String home(Model model) {
        List<FileExtensionResponseDto> list = new ArrayList<>();
        list.add(new FileExtensionResponseDto(new FileExtension("bat")));
        list.add(new FileExtensionResponseDto(new FileExtension("cmd")));
        list.add(new FileExtensionResponseDto(new FileExtension("exe")));

        model.addAttribute("fileExtensionList", list);
        model.addAttribute("item", new FileExtensionRequestDto());
        return "index";
    }

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

    @GetMapping("extensions/fixed")
    public List<FileExtensionResponseDto> findFixedExtensionAll() {
        return fileExtensionService.findFixedExtensionAll();
    }

    @GetMapping("extensions/custom")
    public List<FileExtensionResponseDto> findCustomExtensionAll() {
        return fileExtensionService.findCustomExtensionAll();
    }
}

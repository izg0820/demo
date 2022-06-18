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

    @GetMapping("/")
    public String home(Model model) {
        List<FileExtensionResponseDto> fixedFileExtensionList = fileExtensionService.findFixedExtensionAll();
        List<FileExtensionResponseDto> customFileExtensionList = fileExtensionService.findCustomExtensionAll();

        model.addAttribute("fixedFileExtensionList", fixedFileExtensionList);
        model.addAttribute("customFileExtensionList", customFileExtensionList);
        model.addAttribute("fileExtensionRequestDto", new FileExtensionRequestDto());
        return "index";
    }

    @PostMapping("/extension")
    public String save(FileExtensionRequestDto fileExtensionRequestDto) {
        System.out.println("requestDto = " + fileExtensionRequestDto.getExtension());
        fileExtensionService.save(fileExtensionRequestDto);
        return "redirect:/";
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

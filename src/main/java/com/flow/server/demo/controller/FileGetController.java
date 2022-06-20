package com.flow.server.demo.controller;

import com.flow.server.demo.dto.FileExtensionRequestDto;
import com.flow.server.demo.dto.FileExtensionResponseDto;
import com.flow.server.demo.service.FileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FileGetController {

    private final FileExtensionService fileExtensionService;

    @GetMapping("/")
    public String home(Model model) {
        List<FileExtensionResponseDto> fixedFileExtensionList = fileExtensionService.findFixedExtensionAll();
        List<FileExtensionResponseDto> customFileExtensionList = fileExtensionService.findCustomExtensionAll();

        for(FileExtensionResponseDto fixedExtension : fixedFileExtensionList) {
            fixedExtension.setUseYn(!fixedExtension.getUseYn());
        }
        model.addAttribute("fixedFileExtensionList", fixedFileExtensionList);
        model.addAttribute("customFileExtensionList", customFileExtensionList);
        model.addAttribute("customFileExtensionSize", customFileExtensionList.size());
        return "index";
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

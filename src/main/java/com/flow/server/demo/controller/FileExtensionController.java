package com.flow.server.demo.controller;

import com.flow.server.demo.domain.FileExtension;
import com.flow.server.demo.dto.FileExtensionRequestDto;
import com.flow.server.demo.dto.FileExtensionResponseDto;
import com.flow.server.demo.service.FileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
        model.addAttribute("customFileExtensionSize", customFileExtensionList.size());
        model.addAttribute("fileExtensionRequestDto", new FileExtensionRequestDto());
        return "index";
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/extension")
    public RedirectView save(FileExtensionRequestDto fileExtensionRequestDto) {
        fileExtensionService.save(fileExtensionRequestDto);
        return new RedirectView("/");
    }

    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping("/extension/{param}")
    public void delete(@PathVariable String param) {
        FileExtensionRequestDto requestDto = new FileExtensionRequestDto(param);
        fileExtensionService.delete(requestDto);
    }

    @Transactional(rollbackFor = Exception.class)
    @PutMapping("/extension")
    public RedirectView update(FileExtensionRequestDto fileExtensionRequestDto) {
        fileExtensionService.update(fileExtensionRequestDto);
        return new RedirectView("/");
    }

    @GetMapping("/extension")
    public FileExtensionResponseDto findById(String extension) {
        return fileExtensionService.findById(extension);
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

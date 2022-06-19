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
    public String save(FileExtensionRequestDto fileExtensionRequestDto) {
        fileExtensionService.save(fileExtensionRequestDto);
        return "redirect:/";
    }

    @DeleteMapping("/extension/{id}")
    public String delete(@PathVariable("id") String id) {
        FileExtensionRequestDto requestDto = new FileExtensionRequestDto(id);
        fileExtensionService.delete(requestDto);
        return "redirect:/";
    }

    @PatchMapping("extension/{param}")
    @Transactional
    public String update(@PathVariable String param, @RequestBody FileExtensionRequestDto fileExtensionRequestDto) {
        fileExtensionService.update(param, fileExtensionRequestDto);
        return "redirect:/";
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

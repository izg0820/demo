package com.flow.server.demo.controller;

import com.flow.server.demo.domain.FileExtension;
import com.flow.server.demo.dto.FileExtensionRequestDto;
import com.flow.server.demo.dto.FileExtensionResponseDto;
import com.flow.server.demo.service.FileExtensionService;
import com.flow.server.demo.utils.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.awt.*;
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

    @PostMapping("/extension")
    public String save(FileExtensionRequestDto fileExtensionRequestDto) {
        try {
            fileExtensionService.save(fileExtensionRequestDto);
        } catch (IllegalArgumentException exception) {
            return "redirect:/";
        }
        return "redirect:/";
    }

    @DeleteMapping("/extension/{id}")
    public String delete(@PathVariable("id") String id) {
        FileExtensionRequestDto requestDto = new FileExtensionRequestDto(id);
        fileExtensionService.delete(requestDto);
        return "redirect:/";
    }

    @PutMapping(value = "/extension/{id}")
    public String update(@PathVariable("id") String id, FileExtensionRequestDto fileExtensionRequestDto) {
        fileExtensionService.save(fileExtensionRequestDto);
        return "redirect:/";
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

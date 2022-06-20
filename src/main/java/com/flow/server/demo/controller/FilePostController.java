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

@RestController
@RequiredArgsConstructor
public class FilePostController {

    private final FileExtensionService fileExtensionService;

    @PostMapping("/api/extension")
    public void save(@RequestBody FileExtensionRequestDto fileExtensionRequestDto) {
        fileExtensionService.save(fileExtensionRequestDto);
    }

    @DeleteMapping("/api/extension/{id}")
    public void delete(@PathVariable("id") String id) {
        FileExtensionRequestDto requestDto = new FileExtensionRequestDto(id);
        fileExtensionService.delete(requestDto);
    }

    @PutMapping("/api/extension/{id}")
    public void update(@PathVariable("id") String id, @RequestBody FileExtensionRequestDto fileExtensionRequestDto) {
        fileExtensionService.save(fileExtensionRequestDto);
    }

}

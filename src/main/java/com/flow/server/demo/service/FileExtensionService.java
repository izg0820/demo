package com.flow.server.demo.service;

import com.flow.server.demo.domain.FileExtension;
import com.flow.server.demo.domain.repository.FileExtensionRepository;
import com.flow.server.demo.dto.FileExtensionRequestDto;
import com.flow.server.demo.dto.FileExtensionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileExtensionService {

    private final FileExtensionRepository fileExtensionRepository;

    public String save(FileExtensionRequestDto requestDto) {
        return this.fileExtensionRepository.save(requestDto.toEntity()).getExtension();
    }

    public FileExtensionResponseDto findById(String extension) {
        FileExtension fileExtension = fileExtensionRepository.findById(extension).orElse(new FileExtension());
        return new FileExtensionResponseDto(fileExtension);
    }

    public void delete(FileExtensionRequestDto requestDto) {
        fileExtensionRepository.delete(requestDto.toEntity());
    }

    public List<FileExtensionResponseDto> findFixedExtensionAll() {
        return fileExtensionRepository.findByFixed().stream().map(FileExtensionResponseDto::new).collect(Collectors.toList());
    }

    public List<FileExtensionResponseDto> findCustomExtensionAll() {
        return fileExtensionRepository.findByCustom().stream().map(FileExtensionResponseDto::new).collect(Collectors.toList());
    }

    public void update(String extension) {
        FileExtensionRequestDto requestDto = new FileExtensionRequestDto(extension);

        this.fileExtensionRepository.save(requestDto.toEntity());
    }
}

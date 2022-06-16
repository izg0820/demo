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

    @Transactional
    public void save(FileExtensionRequestDto requestDto) {
        this.fileExtensionRepository.save(requestDto.toEntity());
    }

    public FileExtensionResponseDto findById(String extension) {
        FileExtension fileExtension = fileExtensionRepository.findById(extension).orElse(new FileExtension());
        return new FileExtensionResponseDto(fileExtension);
    }

    public void delete(FileExtensionRequestDto requestDto) {
        fileExtensionRepository.delete(requestDto.toEntity());
    }

    public List<FileExtensionResponseDto> findAll() {
        return fileExtensionRepository.findAll().stream().map(FileExtensionResponseDto::new).collect(Collectors.toList());
    }
}

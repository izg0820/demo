package com.flow.server.demo.service;

import com.flow.server.demo.domain.repository.FileExtensionRepository;
import com.flow.server.demo.dto.FileExtensionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FileExtensionService {

    private FileExtensionRepository fileExtensionRepository;

    @Transactional
    public void save(FileExtensionRequestDto requestDto) {
        fileExtensionRepository.save(requestDto.toEntity());
    }

}

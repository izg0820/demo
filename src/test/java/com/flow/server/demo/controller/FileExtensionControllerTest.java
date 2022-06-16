package com.flow.server.demo.controller;

import com.flow.server.demo.domain.FileExtension;
import com.flow.server.demo.domain.repository.FileExtensionRepository;
import com.flow.server.demo.dto.FileExtensionRequestDto;
import com.flow.server.demo.dto.FileExtensionResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileExtensionControllerTest {

    @Autowired
    private FileExtensionController fileExtensionController;

    @Test
    public void add() {
        FileExtensionRequestDto requestDto = new FileExtensionRequestDto("mp3");
        fileExtensionController.save(requestDto);

        FileExtensionResponseDto responseDto = fileExtensionController.findById("mp3");
        assertThat(requestDto.toEntity().getExtension()).isEqualTo(responseDto.getExtension());
    }

}

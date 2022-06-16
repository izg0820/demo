package com.flow.server.demo.controller;

import com.flow.server.demo.dto.FileExtensionRequestDto;
import com.flow.server.demo.dto.FileExtensionResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

    @Test
    public void delete() {
        FileExtensionRequestDto requestDto = new FileExtensionRequestDto("mp3");
        fileExtensionController.save(requestDto);

        fileExtensionController.delete(requestDto);
        FileExtensionResponseDto responseDto = fileExtensionController.findById(requestDto.getExtension());
        assertThat(responseDto.getExtension()).isNull();
    }

    @Test
    public void findAll() {
        FileExtensionRequestDto requestDto1 = new FileExtensionRequestDto("mp3");
        fileExtensionController.save(requestDto1);
        FileExtensionRequestDto requestDto2 = new FileExtensionRequestDto("mp4");
        fileExtensionController.save(requestDto2);

        List<FileExtensionResponseDto> responseDto = fileExtensionController.findAll();
        assertThat(responseDto.size()).isEqualTo(2);
    }


}

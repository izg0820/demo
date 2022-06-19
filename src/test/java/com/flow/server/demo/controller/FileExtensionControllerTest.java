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
import static org.assertj.core.api.Assertions.tuple;

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

        fileExtensionController.delete(requestDto.getExtension());
        FileExtensionResponseDto responseDto = fileExtensionController.findById(requestDto.getExtension());
        assertThat(responseDto.getExtension()).isNull();
    }

    @Test
    public void update() {
        FileExtensionRequestDto requestDto = new FileExtensionRequestDto("mp3");
        fileExtensionController.save(requestDto);

        fileExtensionController.update(requestDto.getExtension(), new FileExtensionRequestDto(requestDto.getExtension(), requestDto.isFixed(), false));

        FileExtensionResponseDto findFileExtension = fileExtensionController.findById(requestDto.getExtension());
        assertThat(findFileExtension.isUse()).isFalse();
    }

    @Test
    public void findCustomExtensionAll() {
        FileExtensionRequestDto requestDto1 = new FileExtensionRequestDto("mp3", false, true);
        fileExtensionController.save(requestDto1);
        FileExtensionRequestDto requestDto2 = new FileExtensionRequestDto("mp4", false, true);
        fileExtensionController.save(requestDto2);

        List<FileExtensionResponseDto> responseDto = fileExtensionController.findCustomExtensionAll();
        assertThat(responseDto).extracting("fixed").containsExactly(false, false);
    }

    @Test
    public void findDefaultExtensionAll() {
        FileExtensionRequestDto requestDto1 = new FileExtensionRequestDto("cmd", true, true);
        fileExtensionController.save(requestDto1);
        FileExtensionRequestDto requestDto2 = new FileExtensionRequestDto("exe", true, true);
        fileExtensionController.save(requestDto2);

        List<FileExtensionResponseDto> responseDto = fileExtensionController.findFixedExtensionAll();
        assertThat(responseDto).extracting("fixed").containsExactly(true, true);
    }


}

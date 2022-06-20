package com.flow.server.demo.controller;

import com.flow.server.demo.dto.FileExtensionRequestDto;
import com.flow.server.demo.dto.FileExtensionResponseDto;
import com.flow.server.demo.service.FileExtensionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilePostControllerTest {

    @Autowired
    private FilePostController filePostController;
    @Autowired
    private FileExtensionService fileExtensionService;
    @Autowired
    private FileGetController fileGetController;

    @Test
    public void add() {
        FileExtensionRequestDto requestDto = new FileExtensionRequestDto("mp3");
        filePostController.save(requestDto);

        FileExtensionResponseDto responseDto = fileExtensionService.findById("mp3");
        assertThat(requestDto.toEntity().getExtension()).isEqualTo(responseDto.getExtension());
    }

    @Test
    public void delete() {
        FileExtensionRequestDto requestDto = new FileExtensionRequestDto("mp3");
        filePostController.save(requestDto);

        filePostController.delete(requestDto.getExtension());
        FileExtensionResponseDto responseDto = fileExtensionService.findById(requestDto.getExtension());
        assertThat(responseDto.getExtension()).isNull();
    }

    @Test
    public void update() {
        FileExtensionRequestDto requestDto = new FileExtensionRequestDto("mp3");
        filePostController.save(requestDto);

        requestDto.setUsed(false);
        filePostController.save(requestDto);

        FileExtensionResponseDto findFileExtension = fileExtensionService.findById(requestDto.getExtension());
        assertThat(findFileExtension.getUsed()).isFalse();
    }

    @Test
    public void findCustomExtensionAll() {
        FileExtensionRequestDto requestDto1 = new FileExtensionRequestDto("mp3", false, true);
        filePostController.save(requestDto1);
        FileExtensionRequestDto requestDto2 = new FileExtensionRequestDto("mp4", false, true);
        filePostController.save(requestDto2);

        List<FileExtensionResponseDto> responseDto = fileGetController.findCustomExtensionAll();
        assertThat(responseDto).extracting("fixed").containsExactly(false, false);
    }

    @Test
    public void findDefaultExtensionAll() {
        FileExtensionRequestDto requestDto1 = new FileExtensionRequestDto("cmd", true, true);
        filePostController.save(requestDto1);
        FileExtensionRequestDto requestDto2 = new FileExtensionRequestDto("exe", true, true);
        filePostController.save(requestDto2);

        List<FileExtensionResponseDto> responseDto = fileGetController.findFixedExtensionAll();
        assertThat(responseDto).extracting("fixed").containsExactly(true, true);
    }


}

package com.flow.server.demo.utils;

import com.flow.server.demo.controller.FilePostController;
import com.flow.server.demo.controller.FileGetController;
import com.flow.server.demo.dto.FileExtensionRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class initServiceTest {

    @Autowired
    private FilePostController filePostController;

    @Autowired
    private FileGetController fileGetController;

    @Test
    public void init() {
        String[] fixedExtensions = Constant.FixedExtenstion;
        for (String fixedExtension : fixedExtensions) {
            filePostController.save(new FileExtensionRequestDto(fixedExtension, true, false));
        }
        assertThat(fileGetController.findFixedExtensionAll().size()).isEqualTo(7);
    }

}

package com.flow.server.demo.service;

import com.flow.server.demo.domain.FileExtension;
import com.flow.server.demo.domain.repository.FileExtensionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileExtensionRepositoryTest {

    @Autowired
    private FileExtensionRepository fileExtensionRepository;

    @Test
    public void add() {
        FileExtension fileExtension = new FileExtension("mp3");
        fileExtensionRepository.save(fileExtension);

        FileExtension findFileExtension = fileExtensionRepository.findById("mp3").orElse(new FileExtension());
        assertThat(fileExtension.getExtension()).isEqualTo(findFileExtension.getExtension());
    }
}

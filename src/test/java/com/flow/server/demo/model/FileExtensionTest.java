package com.flow.server.demo.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FileExtensionTest {

    @Test
    public void lengthCheck() {
        assertThatThrownBy(() -> {
            FileExtension fileExtension = new FileExtension("123456789012345678901");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"%!@", "가나다"})
    public void textCheck(String name) {
        assertThatThrownBy(() -> {
            FileExtension fileExtension = new FileExtension(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

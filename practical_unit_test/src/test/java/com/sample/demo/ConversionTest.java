package com.sample.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalTime;

public class ConversionTest {

    @ParameterizedTest
    @CsvSource({
            "http://valid.url, 123.456e789",
            "http://whatever.com, -987.653e321"})
    void expectsURLsAndBigDecimals(URL url, BigDecimal bigDec) {
        System.out.println("url: " + url + ", bigDec: " + bigDec);
    }

    @ParameterizedTest
    @CsvSource({
            "/path/to/file, 15:24:38",
            "/usr/local/file.txt, 11:11:11"})
    void expectsPathAndTime(Path path, LocalTime time) {
        System.out.println("path: " + path + ", time: " + time);
    }
}

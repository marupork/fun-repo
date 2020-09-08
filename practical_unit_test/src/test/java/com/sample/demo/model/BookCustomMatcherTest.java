package com.sample.demo.model;

import org.junit.jupiter.api.Test;

import static com.sample.demo.model.BookAssert.assertThat;

public class BookCustomMatcherTest {

    private static final String TITLE = "My book";

    @Test
    void constructorShouldSetTitle() {
        Book book = new Book(TITLE);

        assertThat(book).hasTitle(TITLE);
    }
}

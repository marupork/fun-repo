package com.sample.demo;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class CollectionsTest {

    @Test
    void  containsElements() {
        Object a = new Object();
        Object b = new Object();

        List<Object> objects = Arrays.asList(a, b);

        assertThat(objects.size()).isEqualTo(2);
        assertThat(objects.contains(a)).isTrue();
        assertThat(objects.contains(b)).isTrue();

        // vs

        assertThat(objects)
                .hasSize(2)
                .containsOnly(a, b);
    }

    @Test
    void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "this");
        map.put("b", "that");

        assertThat(map)
            .contains(
                    entry("a", "this"),
                    entry("b", "that")
            )
            .doesNotContain(entry("c", "those"));

        Set<String> set = Sets.newTreeSet("a", "b", "c");
    }


    @Test
    void testByProperty() {
        Collection<Book> books = Sets.newLinkedHashSet(
                new Book("Homer", "Odyssey"),
                new Book("J.R.R. Tolkien", "Hobbit")
        );

        assertThat(books)
            .extracting(Book::getAuthor)
            .contains("J.R.R. Tolkien")
            .doesNotContain("J.K. Rowling");
    }

    @Test
    void shouldReturnUsersPhoneTDD() {
        User user = new User();
        user.addPhone("123 456 789");

        List<String> phones = user.getPhones();

        assertThat(phones)
            .isNotNull()
            .isNotEmpty()
            .hasSize(1)
            .contains("123 456 789");

        // vs

        assertThat(phones).containsExactly("123 456 789");
    }
}

class Book {
    private final String author;
    private final String title;

    Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class User {
    private List<String> phones = new ArrayList<>();

    void addPhone(String phone) {
        phones.add(phone);
    }

    public List<String> getPhones() {
        return phones;
    }
}

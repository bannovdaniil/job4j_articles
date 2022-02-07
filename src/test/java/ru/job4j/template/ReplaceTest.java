package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReplaceTest {
    @Ignore
    public void whenTwoChange() {
        Generator generator = new Replace();
        String result = generator.produce("I am a ${name}, Who are ${subject}? ",
                Map.of("name", "Petr Arsentev",
                        "subject", "you"));
        String expected = "I am a Petr Arsentev, Who are you? ";
        assertThat(result, is(expected));
    }

    @Ignore
    public void whenOneWordChange() {
        Generator generator = new Replace();
        String result = generator.produce("I am a ${name}, Who are ${subject}? ",
                Map.of("name", "Petr Arsentev"));
        String expected = "I am a Petr Arsentev, Who are ? ";
        assertThat(result, is(expected));
    }

    @Ignore
    public void whenThreeWordChange() {
        Generator generator = new Replace();
        String result = generator.produce("I am a ${name}, Who are ${subject}? ",
                Map.of("name", "Petr Arsentev",
                        "subject", "you",
                        "answer", "I"));
        String expected = "I am a Petr Arsentev, Who are you? ";
        assertThat(result, is(expected));
    }

}
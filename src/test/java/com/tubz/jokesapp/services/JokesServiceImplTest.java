package com.tubz.jokesapp.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JokesServiceImplTest {

    @InjectMocks
    private JokesServiceImpl jokesService;

    @Mock
    private ChuckNorrisQuotes chuckNorrisQuotes;

    @Test
    void shouldGetRandomJoke() {
        String expectedJoke = "Some joke";
        when(chuckNorrisQuotes.getRandomQuote()).thenReturn(expectedJoke);

        String result = jokesService.getJoke();
        verify(chuckNorrisQuotes).getRandomQuote();
        assertNotNull(result);
        assertEquals(expectedJoke, result);
    }
}
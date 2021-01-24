package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitalizeTest {
    TextTransformer transform;
    @BeforeEach
    public void setup(){
        transform = new TextTransformer(new String[]{"capital"});
    }

    @Test
    public void testMale(){
        assertEquals("Przykładowy Tekst", transform.transform("przykładowy tekst"));
    }

    @Test
    public void testDuze(){
        assertEquals("Przykładowy Tekst", transform.transform("PRZYKŁADOWY TEKST"));
    }

    @Test
    public void testMieszane(){
        assertEquals("Przykładowy Tekst" , transform.transform("PrZyKłAdOwY tEkSt"));
    }

}
package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToShortcutTest {
    TextTransformer transform;
    @BeforeEach
    public void setup(){
        transform = new TextTransformer(new String[]{"str2short"});
    }

    @Test
    public void testPojedynczy(){
        assertEquals("np. Cola", transform.transform("na przykład Cola"));
    }

    @Test
    public void testKilku(){
        assertEquals("np. Cola itp.", transform.transform("na przykład Cola i tym podobne"));
    }

    @Test
    public void testNierozpoznany(){
        assertEquals("np. Cola itp" , transform.transform("na przykład Cola itp"));
    }


}
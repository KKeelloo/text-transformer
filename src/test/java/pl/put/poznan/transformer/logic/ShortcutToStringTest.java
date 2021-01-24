package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ShortcutToStringTest {
    ShortcutToString transform;
    @BeforeEach
    public void setup(){
        transform = new ShortcutToString(new String[]{"short2str"},1);
    }

    @Test
    public void testPojedynczy(){
        assertEquals("na przykład", transform.transform("np."));
    }

    @Test
    public void testKilku(){
        assertEquals("na przykład Cola i tym podobne", transform.transform("np. Cola itp."));
    }

    @Test
    public void testNierozpoznany(){
        assertEquals("na przykład Cola itp", transform.transform("np. Cola itp"));
    }

    @Test
    public void testMock(){
        Upper up = mock(Upper.class);
        when(up.transform(anyString())).thenReturn("np. Cola");
        transform.setTransformation(up);
        assertEquals("na przykład Cola", transform.transform("np. Cola itp"));
        verify(up).transform(anyString());
    }



}
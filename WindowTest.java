package snakegametest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import snakegame.Window;

public class WindowTest {

    @Test
    public void testWindow() {
        Window window = new Window();

        assertEquals(20, window.width);
        assertEquals(20, window.height);

    }

}
package snakegametest;

import snakegame.ThreadsController;
import java.awt.Button;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import snakegame.KeyboardListener;


public class KeyboardListenerTest {

    private KeyboardListener keyboardListener;
    @BeforeEach
    public void setUp() {
        keyboardListener = new KeyboardListener();

    }

    @Test
    public void testRightKey() {
        Button key = new Button();
        // Simulate a key press event for the right arrow key (key code 39)
        KeyEvent e = new KeyEvent(key, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        ThreadsController.directionSnake = 1; // Set an initial direction
        keyboardListener.keyPressed(e);
        assertEquals(1, ThreadsController.directionSnake);
    }

    @Test
    public void testLeftKey() {
        Button key = new Button();
        // Simulate a key press event for the right arrow key (key code 39)
        KeyEvent e = new KeyEvent(key, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        ThreadsController.directionSnake = 2; // Set an initial direction
        keyboardListener.keyPressed(e);
        assertEquals(2, ThreadsController.directionSnake);
    }
    @Test
    public void testTopKey() {
        Button key = new Button();
        // Simulate a key press event for the right arrow key (key code 39)
        KeyEvent e = new KeyEvent(key, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
        ThreadsController.directionSnake = 3; // Set an initial direction
        keyboardListener.keyPressed(e);
        assertEquals(3, ThreadsController.directionSnake);
    }

    @Test
    public void testBottomKey() {
        Button key = new Button();
        // Simulate a key press event for the right arrow key (key code 39)
        KeyEvent e = new KeyEvent(key, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);
        ThreadsController.directionSnake = 4; // Set an initial direction
        keyboardListener.keyPressed(e);
        assertEquals(4, ThreadsController.directionSnake);
    }
}

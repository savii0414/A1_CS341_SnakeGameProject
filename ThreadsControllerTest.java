package snakegametest;
        
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import snakegame.ThreadsController;
import snakegame.Tuple;



public class ThreadsControllerTest {
    ThreadsController controller;

    @Test
    public void testMoveInterne1() {
        Tuple initialPosition = new Tuple(10, 10);
        controller = new ThreadsController(initialPosition);

        controller.moveInterne(1);
        controller.moveInterne(2);
        controller.moveInterne(3);
        controller.moveInterne(4);

    }

    @Test
    public void testMoveInterne2() {
        Tuple initialPosition = new Tuple(-5, -5);
        controller = new ThreadsController(initialPosition);

        controller.moveInterne(2);
        controller.moveInterne(3);

    }

    @Test
    public void testDeleteTail() {
        Tuple initialPosition = new Tuple(10, 10);
        controller = new ThreadsController(initialPosition);

        // Add positions to ArrayList
        controller.positions.add(new Tuple(10, 10));
        controller.positions.add(new Tuple(10, 11));
        controller.positions.add(new Tuple(10, 12));

        controller.sizeSnake = 3;


        //This method allows to use private methods while testing
        Method deleteTailMethod = null;
        try {
            deleteTailMethod = ThreadsController.class.getDeclaredMethod("deleteTail");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        deleteTailMethod.setAccessible(true);


        //invoking the private method
        try {
            deleteTailMethod.invoke(controller);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }


        assertEquals(3, controller.positions.size());

    }

    @Test
    public void testGetValAleaNotInSnake() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Create a ThreadsController with an initial position
        Tuple initialPosition = new Tuple(10, 10);
        ThreadsController controller = new ThreadsController(initialPosition);

        controller.positions.add(new Tuple(10, 10));
        controller.positions.add(new Tuple(10, 12));
        controller.positions.add(new Tuple(10, 13));


        Method getValAleaNotInSnakeMethod = null;

        getValAleaNotInSnakeMethod = ThreadsController.class.getDeclaredMethod("getValAleaNotInSnake");

        getValAleaNotInSnakeMethod.setAccessible(true);


        Tuple random = (Tuple) getValAleaNotInSnakeMethod.invoke(controller);
        boolean isPositionInSnake = false;

        for (Tuple t : controller.positions) {
            if (t.equals(random)) {
                isPositionInSnake = true;
                break;
            }
        }


        assertFalse(isPositionInSnake);
    }

    @Test
    public void testCheckCollision() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Tuple initialPosition = new Tuple(10, 10);
        ThreadsController controller = new ThreadsController(initialPosition);
        ThreadsController controller2 = new ThreadsController(initialPosition);
        Method checkCollisionMethod = null;

        checkCollisionMethod = ThreadsController.class.getDeclaredMethod("checkCollision");

        checkCollisionMethod.setAccessible(true);

        controller.positions.add(new Tuple(10, 10));
        controller.positions.add(new Tuple(10, 11));
        controller.positions.add(new Tuple(10, 12));

        controller2.foodPosition = new Tuple(10, 10);
        checkCollisionMethod.invoke(controller2);


        Tuple posCritique = (Tuple) checkCollisionMethod.invoke(controller);;

        for (Tuple t : controller.positions) {
            if (t.equals(posCritique)) {
                controller.stopTheGame();
                break;
            }
        }
        assertEquals(4, controller2.sizeSnake);
    }
}
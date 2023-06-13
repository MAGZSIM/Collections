package netology.ru.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void firstPlayerStronger() {
        Game game = new Game();
        Player max = new Player(1, "Max", 120);
        Player alex = new Player(2, "Alex", 100);

        game.register(max);
        game.register(alex);

        int actual = game.round("Max", "Alex");
        int expected = 1;

        assertEquals(expected, actual);

    }

    @Test
    public void secondPlayerStronger() {
        Game game = new Game();
        Player max = new Player(1, "Max", 100);
        Player alex = new Player(2, "Alex", 120);

        game.register(max);
        game.register(alex);

        int actual = game.round("Max", "Alex");
        int expected = 2;

        assertEquals(expected, actual);

    }


    @Test
    public void forceAreEqual() {
        Game game = new Game();
        Player max = new Player(1, "Max", 100);
        Player alex = new Player(2, "Alex", 100);

        game.register(max);
        game.register(alex);

        int actual = game.round("Max", "Alex");
        int expected = 0;

        assertEquals(expected, actual);

    }


    @Test
    public void firstPlayerNotFound() {
        Game game = new Game();
        Player max = new Player(1, "Max", 100);
        Player alex = new Player(2, "Alex", 120);

        game.register(max);
        game.register(alex);

        assertThrows(NotRegisteredException.class, ()-> {
            game.round("Anton", "Alex");
        });

    }

    @Test
    public void secondPlayerNotFound() {
        Game game = new Game();
        Player max = new Player(1, "Max", 100);
        Player alex = new Player(2, "Alex", 120);

        game.register(max);
        game.register(alex);

        assertThrows(NotRegisteredException.class, ()-> {
            game.round("Max", "Anton");
        });

    }

    @Test
    public void playersNotFound() {
        Game game = new Game();
        Player max = new Player(1, "Max", 100);
        Player alex = new Player(2, "Alex", 120);

        game.register(max);
        game.register(alex);

        assertThrows(NotRegisteredException.class, ()-> {
            game.round("Anton", "Anton");
        });

    }


}
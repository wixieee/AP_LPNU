package menu;

import bouquet.Bouquet;
import command.DisplayBouquetCommand;
import command.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Menu menu;
    private Command command;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        Bouquet bouquet = new Bouquet();
        menu = new Menu();
        command = new DisplayBouquetCommand(bouquet);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testAddCommand() {
        menu.addCommand(6, command);
        assertEquals(command, menu.getCommands().get(6));
    }

    @Test
    public void testExecuteCommand_DisplayBouquet() {
        menu.addCommand(6, command);

        System.setIn(new ByteArrayInputStream("6\n7\n".getBytes()));
        menu.showMenu();

        assertTrue(outputStreamCaptor.toString().contains("Не знайдено букет"));
    }

    @Test
    public void testInvalidOptionHandling() {
        System.setIn(new ByteArrayInputStream("99\n7\n".getBytes()));
        menu.showMenu();

        assertTrue(outputStreamCaptor.toString().contains("Невірний вибір. Спробуйте ще раз."));
    }
}
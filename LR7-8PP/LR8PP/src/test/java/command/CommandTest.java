package command;

import accessory.Card;
import bouquet.Bouquet;
import flower.Daisy;
import flower.Rose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandTest {
    private Bouquet bouquet;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        bouquet = new Bouquet();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testAddRemoveFlowerCommandIncorrectOption() {
        AddRemoveFlowerCommand addRemoveFlowerCommand = new AddRemoveFlowerCommand(bouquet);

        System.setIn(new ByteArrayInputStream("99\n".getBytes()));
        addRemoveFlowerCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Некоректний ввід"));
    }

    @Test
    public void testAddRoseCommand() {
        AddRemoveFlowerCommand addRemoveFlowerCommand = new AddRemoveFlowerCommand(bouquet);

        System.setIn(new ByteArrayInputStream("1\n1\n".getBytes()));
        addRemoveFlowerCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Добавлено квітку: Троянда"));
    }

    @Test
    public void testAddDaisyCommand() {
        AddRemoveFlowerCommand addRemoveFlowerCommand = new AddRemoveFlowerCommand(bouquet);

        System.setIn(new ByteArrayInputStream("1\n2\n".getBytes()));
        addRemoveFlowerCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Добавлено квітку"));
    }

    @Test
    public void testAddTulipCommand() {
        AddRemoveFlowerCommand addRemoveFlowerCommand = new AddRemoveFlowerCommand(bouquet);

        System.setIn(new ByteArrayInputStream("1\n3\n".getBytes()));
        addRemoveFlowerCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Добавлено квітку"));
    }

    @Test
    public void testAddFlowerCommandIncorrectFlower() {
        AddRemoveFlowerCommand addRemoveFlowerCommand = new AddRemoveFlowerCommand(bouquet);

        System.setIn(new ByteArrayInputStream("1\n99\n".getBytes()));
        addRemoveFlowerCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Некоректний ввід"));
    }

    @Test
    public void testRemoveFlowerCommand() {
        AddRemoveFlowerCommand addRemoveFlowerCommand = new AddRemoveFlowerCommand(bouquet);

        bouquet.addFlower(new Rose());
        System.setIn(new ByteArrayInputStream("2\n1\n".getBytes()));
        addRemoveFlowerCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Видалено квітку"));
    }

    @Test
    public void testRemoveFlowerCommandEmpty() {
        AddRemoveFlowerCommand addRemoveFlowerCommand = new AddRemoveFlowerCommand(bouquet);

        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        addRemoveFlowerCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Не знайдено квітів"));
    }



    @Test
    public void testAddRemoveAccessoryCommandIncorrectOption() {
        AddRemoveAccessoryCommand addRemoveAccessoryCommand = new AddRemoveAccessoryCommand(bouquet);

        System.setIn(new ByteArrayInputStream("99\n".getBytes()));
        addRemoveAccessoryCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Некоректний ввід"));
    }

    @Test
    public void testAddRibbonCommand() {
        AddRemoveAccessoryCommand addRemoveAccessoryCommand = new AddRemoveAccessoryCommand(bouquet);

        System.setIn(new ByteArrayInputStream("1\n1\n".getBytes()));
        addRemoveAccessoryCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Добавлено аксесуар"));
    }

    @Test
    public void testAddWrapperCommand() {
        AddRemoveAccessoryCommand addRemoveAccessoryCommand = new AddRemoveAccessoryCommand(bouquet);

        System.setIn(new ByteArrayInputStream("1\n2\n".getBytes()));
        addRemoveAccessoryCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Добавлено аксесуар"));
    }

    @Test
    public void testAddCardCommand() {
        AddRemoveAccessoryCommand addRemoveAccessoryCommand = new AddRemoveAccessoryCommand(bouquet);

        System.setIn(new ByteArrayInputStream("1\n3\n".getBytes()));
        addRemoveAccessoryCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Добавлено аксесуар"));
    }

    @Test
    public void testAddAccessoryCommandIncorrectAccessory() {
        AddRemoveAccessoryCommand addRemoveAccessoryCommand = new AddRemoveAccessoryCommand(bouquet);

        System.setIn(new ByteArrayInputStream("1\n99\n".getBytes()));
        addRemoveAccessoryCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Некоректний ввід"));
    }

    @Test
    public void testRemoveAccessoryCommand() {
        AddRemoveAccessoryCommand addRemoveAccessoryCommand = new AddRemoveAccessoryCommand(bouquet);

        bouquet.addAccessory(new Card());
        System.setIn(new ByteArrayInputStream("2\n1\n".getBytes()));
        addRemoveAccessoryCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Видалено аксесуар: Листівка"));
    }

    @Test
    public void testRemoveAccessoryCommandEmpty() {
        AddRemoveAccessoryCommand addRemoveAccessoryCommand = new AddRemoveAccessoryCommand(bouquet);

        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        addRemoveAccessoryCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Не знайдено аксесуарів"));
    }

    @Test
    public void testCalculateBouquetPriceCommandFilled() {
        CalculateBouquetCommand calculateBouquetPriceCommand = new CalculateBouquetCommand(bouquet);
        bouquet.addFlower(new Rose());
        bouquet.addAccessory(new Card());
        calculateBouquetPriceCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Загальна вартість букета: 45.0 грн."));
    }

    @Test
    public void testCalculateBouquetPriceCommandEmpty() {
        CalculateBouquetCommand calculateBouquetPriceCommand = new CalculateBouquetCommand(bouquet);
        calculateBouquetPriceCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Не знайдено букет"));
    }

    @Test
    public void testSortByFreshnessCommandEmpty() {
        SortByFreshnessCommand sortByFreshnessCommand = new SortByFreshnessCommand(bouquet);

        sortByFreshnessCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Не знайдено букет"));
    }

    @Test
    public void testSortByFreshnessCommandFilled() {
        SortByFreshnessCommand sortByFreshnessCommand = new SortByFreshnessCommand(bouquet);
        bouquet.addFlower(new Rose());
        bouquet.addFlower(new Daisy());
        sortByFreshnessCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Квіти відсортовано за свіжістю:"));
    }

    @Test
    public void testFindFlowerByStemLengthCommandFalse() {
        FindFlowerByStemLengthCommand findFlowerByStemLengthCommand = new FindFlowerByStemLengthCommand(bouquet);

        System.setIn(new ByteArrayInputStream("6\n7\n".getBytes()));
        findFlowerByStemLengthCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Не знайдено квітів в діапазоні"));
    }

    @Test
    public void testFindFlowerByStemLengthCommandTrue() {
        FindFlowerByStemLengthCommand findFlowerByStemLengthCommand = new FindFlowerByStemLengthCommand(bouquet);

        bouquet.addFlower(new Rose());
        System.setIn(new ByteArrayInputStream("10\n30\n".getBytes()));
        findFlowerByStemLengthCommand.execute();

        assertTrue(outputStreamCaptor.toString().contains("Знайдені квіти в діапазоні(10 - 30):"));
    }

    @Test
    public void testDisplayBouquetCommandEmpty() {
        DisplayBouquetCommand displayBouquetCommand = new DisplayBouquetCommand(bouquet);

        displayBouquetCommand.execute();

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Не знайдено букет"));
    }

    @Test
    public void testDisplayBouquetCommandWithFlower() {
        DisplayBouquetCommand displayBouquetCommand = new DisplayBouquetCommand(bouquet);
        bouquet.addFlower(new Rose());
        displayBouquetCommand.execute();

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Квіти у букеті:"));
    }

    @Test
    public void testDisplayBouquetCommandWithAccessory() {
        DisplayBouquetCommand displayBouquetCommand = new DisplayBouquetCommand(bouquet);
        bouquet.addAccessory(new Card());
        displayBouquetCommand.execute();

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Аксесуари у букеті:"));
    }
}

package accessory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccessoryTest {

    @Test
    void testCardProperties() {
        Card card = new Card();
        assertEquals("Листівка", card.getName());
        assertEquals(20, card.getPrice());
        assertEquals("Вітаю!", card.getMessage());
        assertEquals("День Народження", card.getOccasion());
    }

    @Test
    void testCardToString() {
        Card card = new Card();
        String expected = "Товар: Листівка, Вартість: 20.0, Подія: День Народження, Повідомлення: Вітаю!";
        assertEquals(expected, card.toString());
    }

    @Test
    void testRibbonProperties() {
        Ribbon ribbon = new Ribbon();
        assertEquals("Стрічка", ribbon.getName());
        assertEquals(10, ribbon.getPrice());
        assertEquals("Рожевий", ribbon.getColor());
        assertEquals(15, ribbon.getLengthCm());
    }

    @Test
    public void testRibbonToString() {
        Ribbon ribbon = new Ribbon();
        String expected = "Товар: Стрічка, Вартість: 10.0, Колір: Рожевий, Довжина: 15.0 сантиметрів";
        assertEquals(expected, ribbon.toString());
    }

    @Test
    void testWrapperProperties() {
        Wrapper wrapper = new Wrapper();
        assertEquals("Упаковка", wrapper.getName());
        assertEquals(30, wrapper.getPrice());
        assertEquals("Папір", wrapper.getMaterial());
        assertEquals("Середній", wrapper.getSize());
    }

    @Test
    public void testWrapperToString() {
        Wrapper wrapper = new Wrapper();
        String expected = "Товар: Упаковка, Вартість: 30.0, Матеріал: Папір, Розмір: Середній";
        assertEquals(expected, wrapper.toString());
    }
}

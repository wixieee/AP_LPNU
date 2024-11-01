package flower;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    @Test
    void testDaisyProperties() {
        Daisy daisy = new Daisy();
        assertEquals("Ромашка", daisy.getName());
        assertEquals(7, daisy.getFreshness());
        assertEquals(5, daisy.getStemLengthCm());
        assertEquals(2.0, daisy.getPrice());
        assertEquals("Жовтий", daisy.getCenterColor());
        assertEquals("Овал", daisy.getLeafShape());
    }

    @Test
    void testDaisyToString() {
        Daisy daisy = new Daisy();
        String expected = "Назва: Ромашка, Cвіжість: 7/10, Довжина Стебла: 5 сантиметрів, Ціна: 2.0 грн., Колір середини: Жовтий, Форма пелюсток: Овал";
        assertEquals(expected, daisy.toString());
    }

    @Test
    void testRoseProperties() {
        Rose rose = new Rose();
        assertEquals("Троянда", rose.getName());
        assertEquals(10, rose.getFreshness());
        assertEquals(30, rose.getStemLengthCm());
        assertEquals(25.0, rose.getPrice());
        assertEquals(1, rose.getThornLengthCm());
        assertEquals(7, rose.getFragranceLevel());
    }

    @Test
    void testRoseToString() {
        Rose rose = new Rose();
        String expected = "Назва: Троянда, Cвіжість: 10/10, Довжина Стебла: 30 сантиметрів, Ціна: 25.0 грн., Довжина шипів: 1 сантиметрів, Аромат: 7/10";
        assertEquals(expected, rose.toString());
    }

    @Test
    void testTulipProperties() {
        Tulip tulip = new Tulip();
        assertEquals("Тюльпан", tulip.getName());
        assertEquals(9, tulip.getFreshness());
        assertEquals(7, tulip.getStemLengthCm());
        assertEquals(15.0, tulip.getPrice());
        assertEquals("Велика", tulip.getBulbSize());
        assertEquals("Загострена", tulip.getPetalShape());
    }

    @Test
    void testTulipToString() {
        Tulip tulip = new Tulip();
        String expected = "Назва: Тюльпан, Cвіжість: 9/10, Довжина Стебла: 7 сантиметрів, Ціна: 15.0 грн., Розмір цибулини: Велика, Форма пелюсток: Загострена";
        assertEquals(expected, tulip.toString());
    }
}
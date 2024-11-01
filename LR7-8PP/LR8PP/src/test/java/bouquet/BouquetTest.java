package bouquet;

import accessory.Card;
import flower.Daisy;
import flower.Flower;
import flower.Rose;
import flower.Tulip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BouquetTest {
    private Bouquet bouquet;

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
    }

    @Test
    void testAddFlower(){
        Rose rose = new Rose();
        bouquet.addFlower(rose);
        assertTrue(bouquet.getFlowers().contains(rose));
    }

    @Test
    void testRemoveFlower(){
        Rose rose = new Rose();
        bouquet.addFlower(rose);
        bouquet.removeFlower(0);
        assertFalse(bouquet.getFlowers().contains(rose));
    }

    @Test
    void testAddAccessory(){
        Card card = new Card();
        bouquet.addAccessory(card);
        assertTrue(bouquet.getAccessories().contains(card));
    }

    @Test
    void testRemoveAccessory(){
        Card card = new Card();
        bouquet.addAccessory(card);
        bouquet.removeAccessory(0);
        assertFalse(bouquet.getAccessories().contains(card));
    }

    @Test
    void testCalculatePrice(){
        bouquet.addFlower(new Rose());
        bouquet.addAccessory(new Card());
        double expectedPrice = 45.0;
        assertEquals(expectedPrice, bouquet.calculatePrice());
    }

    @Test
    void testFindFlowerByStemLength(){
        Rose rose = new Rose();
        Tulip tulip = new Tulip();
        Daisy daisy = new Daisy();
        bouquet.addFlower(rose);
        bouquet.addFlower(tulip);
        bouquet.addFlower(daisy);
        ArrayList <Flower> expected = new ArrayList<>();
        expected.add(tulip);
        assertEquals(expected, bouquet.findFlowerByStemLength(6,7));
    }

    @Test
    void testSortByFreshness(){
        Rose rose = new Rose();
        Tulip tulip = new Tulip();
        Daisy daisy = new Daisy();
        bouquet.addFlower(tulip);
        bouquet.addFlower(daisy);
        bouquet.addFlower(rose);
        ArrayList <Flower> expected = new ArrayList<>();
        expected.add(rose);
        expected.add(tulip);
        expected.add(daisy);
        assertEquals(expected, bouquet.sortByFreshness());
    }

    @Test
    void testSortByFreshnessEmptyBouquet() {
        assertTrue(bouquet.sortByFreshness().isEmpty());
    }

    @Test
    void testSortByFreshnessOneFlower() {
        Rose rose = new Rose();
        bouquet.addFlower(rose);
        ArrayList<Flower> expected = new ArrayList<>();
        expected.add(rose);
        assertEquals(expected, bouquet.sortByFreshness());
    }
}
// c2 = 0 - List
//  c3 = 2 - Двозв’язний список

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Empty doubly list
        DoublyLinkedList<Flower> emptyList = new DoublyLinkedList<>();
        System.out.println("Empty list:");
        emptyList.display();

        // Doubly list with one element
        Flower rose = new Rose(90, 40, 15.0);
        DoublyLinkedList<Flower> singleItemList = new DoublyLinkedList<>(rose);
        System.out.println("\nDoubly list with one flower:");
        singleItemList.display();

        // Doubly list form collection
        List<Flower> flowers = Arrays.asList(
                new Rose(90, 40, 15.0),
                new Tulip(85, 35, 10.0),
                new Lily(80, 25, 8.0)
        );
        DoublyLinkedList<Flower> flowerList = new DoublyLinkedList<>(flowers);
        System.out.println("\nDoubly list with a collection of flowers:");
        flowerList.display();

        DoublyLinkedList<Flower> bouquet = new DoublyLinkedList<>();
        Flower tulip = new Tulip(85, 35, 10.0);
        Flower daisy = new Lily(80, 25, 8.0);

        // Insert flowers into the list
        bouquet.insertAtBeginning(rose);
        bouquet.insertAtEnd(tulip);
        bouquet.insertAtPosition(daisy, 2);

        // Display the bouquet
        System.out.println("\nBouquet:");
        bouquet.display();

        // Remove a flower
        bouquet.deleteAtPosition(2);
        System.out.println("\nAfter removing a flower at position 2:");
        bouquet.display();

        // Display size
        System.out.println("\nSize of the bouquet: " + bouquet.size());
    }
}

/**
 * Represents a rose flower.
 */
class Rose extends Flower {
    private final String name;

    public Rose(int freshness, double length, double price) {
        super(freshness, length, price);
        this.name = "Rose";
    }

    @Override
    public String toString() {
        return String.format(
                "%s - Freshness: %d, Length: %.2f cm, Price: %.2f UAH",
                name, this.getFreshness(), this.getLength(), this.getPrice()
        );
    }
}

/**
 * Represents a tulip flower.
 */
class Tulip extends Flower {
    private final String name;

    public Tulip(int freshness, double length, double price) {
        super(freshness, length, price);
        this.name = "Tulip";
    }

    @Override
    public String toString() {
        return String.format(
                "%s - Freshness: %d, Length: %.2f cm, Price: %.2f UAH",
                name, this.getFreshness(), this.getLength(), this.getPrice()
        );
    }
}

/**
 * Represents a lily flower.
 */
class Lily extends Flower {
    private final String name;

    public Lily(int freshness, double length, double price) {
        super(freshness, length, price);
        this.name = "Lily";
    }

    @Override
    public String toString() {
        return String.format(
                "%s - Freshness: %d, Length: %.2f cm, Price: %.2f UAH",
                name, this.getFreshness(), this.getLength(), this.getPrice()
        );
    }
}

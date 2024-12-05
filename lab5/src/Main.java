import java.util.List;

// C13 = 0
// Визначити ієрархію квітів. Створити кілька об'єктів-квітів.
// Зібрати букет (використовуючи аксесуари) з визначенням його вартості.
// Провести сортування квітів у букеті за рівнем свіжості.
// Знайти квітку в букеті, що відповідає заданому діапазону довжин.
public class Main {
    public static void main(String[] args) {
        try {
            Flower rose1 = new Rose(80, 50.0, 30.99);
            Flower tulip1 = new Tulip(50, 33.5, 35.80);
            Flower lily1 = new Lily(95, 50.5, 49.99);

            Bouquet bouquet = new Bouquet(20.0);
            bouquet.addFlower(rose1);
            bouquet.addFlower(tulip1);
            bouquet.addFlower(lily1);

            System.out.println("Bouquet before sort by flower freshness:\n" + bouquet + "\n");

            bouquet.sortFlowersByFreshness();

            System.out.println("Bouquet after sort by flower freshness:\n" + bouquet + "\n");

            System.out.println("Bouquet total cost is " + bouquet.calculateTotalCost() + " UAH\n");

            System.out.println("Flowers with a stem length from 30 to 50 cm:");
            List<Flower> foundFlowers = bouquet.findFlowersByLengthRange(30, 50);
            for (Flower flower : foundFlowers) {
                System.out.println(flower);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
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
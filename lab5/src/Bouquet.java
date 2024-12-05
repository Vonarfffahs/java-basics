import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Bouquet class for working with bouquets
 */
public class Bouquet implements Iterable<Flower> {
    private List<Flower> flowers = new ArrayList<Flower>();
    private double accessoryCost;

    public Bouquet(double accessoryCost) {
        if (accessoryCost < 0) {
            throw new IllegalArgumentException("Accessory cost cannot be negative");
        }
        this.accessoryCost = accessoryCost;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public String toString() {
        StringBuilder flowersString = new StringBuilder();
        for (Flower flower : this) {
            flowersString.append(flower.toString()).append("\n");
        }
        return String.format("Bouquet has such flowers:\n%sBouquet's accessory cost is %.2f UAH", flowersString, this.accessoryCost);
    }

    public void addFlower(Flower flower) {
        if (flower == null) {
            throw new IllegalArgumentException("Flower cannot be null");
        }
        flowers.add(flower);
    }

    public void removeFlower(Flower flower) {
        if (flower == null) {
            throw new IllegalArgumentException("Flower cannot be null");
        }
        flowers.remove(flower);
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (Flower flower : flowers) {
            totalCost += flower.getPrice();
        }
        totalCost += accessoryCost;
        return totalCost;
    }

    public void sortFlowersByFreshness() {
        flowers.sort(Flower::compareTo);
    }

    public List<Flower> findFlowersByLengthRange(int minLength, int maxLength) {
        if (minLength < 0 || maxLength < 0 || minLength > maxLength) {
            throw new IllegalArgumentException("Incorrect stem length range");
        }

        List<Flower> result = new ArrayList<>();
        for (Flower flower : this) {
            if (flower.getLength() >= minLength && flower.getLength() <= maxLength) {
                result.add(flower);
            }
        }

        return result;
    }

    @Override
    public Iterator<Flower> iterator() {
        return flowers.iterator();
    }
}

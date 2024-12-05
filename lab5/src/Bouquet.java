import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Bouquet class for working with bouquets
 */
public class Bouquet implements Iterable<Flower> {
    private final List<Flower> flowers = new ArrayList<Flower>();
    private final double accessoryCost;

    /**
     * Constructs a Bouquet object.
     * @param accessoryCost the cost of additional accessories in this bouquet.
     *                      Must be positive.
     * @throws IllegalArgumentException if accessoryCost is negative.
     */
    public Bouquet(double accessoryCost) {
        if (accessoryCost < 0) {
            throw new IllegalArgumentException("Accessory cost cannot be negative");
        }
        this.accessoryCost = accessoryCost;
    }

    /**
     * Returns a list of flowers in the bouquet.
     * @return a list of {@link Flower} objects.
     */
    public List<Flower> getFlowers() {
        return flowers;
    }

    /**
     * Returns a string representation of this bouquet.
     * Includes details about each flower and the cost of accessories.
     * @return a string describing this bouquet.
     */
    @Override
    public String toString() {
        StringBuilder flowersString = new StringBuilder();
        for (Flower flower : this) {
            flowersString.append(flower.toString()).append("\n");
        }
        return String.format("Bouquet has such flowers:\n%sBouquet's accessory cost is %.2f UAH", flowersString, this.accessoryCost);
    }

    /**
     * Adds a flower to this bouquet.
     * @param flower the {@link Flower} object to be added.
     * @throws IllegalArgumentException if the flower is null.
     */
    public void addFlower(Flower flower) {
        if (flower == null) {
            throw new IllegalArgumentException("Flower cannot be null");
        }
        flowers.add(flower);
    }

    /**
     * Removes a flower from this bouquet.
     * @param flower the {@link Flower} object to be removed.
     * @throws IllegalArgumentException if the flower is null.
     */
    public void removeFlower(Flower flower) {
        if (flower == null) {
            throw new IllegalArgumentException("Flower cannot be null");
        }
        flowers.remove(flower);
    }

    /**
     * Calculates the total cost of the bouquet, including flowers and accessories.
     * @return the total cost of this bouquet.
     */
    public double calculateTotalCost() {
        double totalCost = 0;
        for (Flower flower : flowers) {
            totalCost += flower.getPrice();
        }
        totalCost += accessoryCost;
        return totalCost;
    }

    /**
     * Sorts the flowers in this bouquet by their freshness in ascending order.
     */
    public void sortFlowersByFreshness() {
        flowers.sort(Flower::compareTo);
    }

    /**
     * Finds all flowers in this bouquet with stem lengths with a wanted range.
     * @param minLength the minimum stem length (including).
     * @param maxLength the maximum stem length (including).
     * @return a list of {@link Flower} objects with specified length range.
     * @throws IllegalArgumentException if the length range is invalid.
     */
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

    /**
     * Returns an iterator over the flowers in the bouquet.
     * @return an {@link Iterator} of {@link Flower} objects.
     */
    @Override
    public Iterator<Flower> iterator() {
        return flowers.iterator();
    }
}

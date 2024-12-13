/**
 * An abstract Flower class that defines the basic properties of a flower
 */
public abstract class Flower implements Comparable<Flower> {
    private final int freshness;
    private final double length;
    private final double price;

    /**
     * Flower constructor
     * @param freshness freshness of this flower (1-100);
     *                  {@code 1} - the worst freshness;
     *                  {@code 100} - the best freshness.
     * @param length length of a stem this flower.
     * @param price price of this flower.
     */
    public Flower(int freshness, double length, double price) {
        this.freshness = freshness;
        this.length = length;
        this.price = price;
    }

    /**
     * Returns freshness of this flower
     * @return freshness of this flower
     */
    public int getFreshness() {
        return freshness;
    }

    /**
     * Length of a stem this flower
     * @return flower stem length
     */
    public double getLength() {
        return length;
    }

    /**
     * Price of this flower
     * @return flower price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns Flower as a string
     * @return string representation of Flower instance
     */
    @Override
    public String toString() {
        return String.format("Freshness: %d, Length: %.2f cm, Price: %.2f UAH", freshness, length, price);
    }

    /**
     * Compares two Flower instances
     * @param other the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Flower other) {
        if (other == null) {
            throw new NullPointerException("Flower cannot be null");
        }
        return this.freshness - other.freshness;
    }
}

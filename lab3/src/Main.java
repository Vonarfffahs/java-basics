import java.util.Arrays;
import java.util.Comparator;

// C11 = 4 - Визначити клас одяг, який складається як мінімум з 5-и полів.
/**
 * The main class for work demonstration with classes {@link Clothing}.
 * Creates an array of {@link Clothing} class objects, sorts them by size and price,
 * then searches for the given element in the array of {@link Clothing}.
 */
public class Main {
    /**
     * App's entry point
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        Clothing[] clothes = {
                new Clothing("Jumper", "COS", "M", "dark red", 49.99),
                new Clothing("Jacket", "The North Face", "M", "brown", 99.99),
                new Clothing("T-shirt", "Puma", "L", "black", 38.99),
                new Clothing("Jeans", "Levi's", "S", "blue", 29.99),
                new Clothing("T-shirt", "Nike", "L", "black", 39.99),
                new Clothing("T-shirt", "Nike", "L", "black", 39.99),
        };

        System.out.println("Before sorting by size and price");
        for (Clothing clothing : clothes) {
            System.out.println(clothing);
        }

        Arrays.sort(clothes, new Clothing.PriceAndSizeComparator());

        System.out.println("\nAfter sorting by size and price");
        for (Clothing clothing : clothes) {
            System.out.println(clothing);
        }

        Clothing cl1 = new Clothing("T-shirt", "Nike", "L", "black", 39.99);
        System.out.println("\n" + findClothing(cl1, clothes));
    }

    /**
     * Returns information about the number of instances of the {@link Clothing} object
     * in the {@code clothes} array, which are identical to the given one.
     * @param cl {@link Clothing} object whose identical objects are searched in the array {@code clothes}
     * @param clothes array of {@link Clothing} objects in which the search is happening
     * @return message with the number of instances of given {@link Clothing} object found
     * @throws IllegalArgumentException if array {@code clothes} or {@code cl} is null
     */
    public static String findClothing(Clothing cl, Clothing[] clothes) {
        if (cl == null || clothes == null) {
            throw new IllegalArgumentException("Clothing object or array cannot be null.");
        }

        int count = 0;
        for (Clothing clothing : clothes) {
            if (clothing.equals(cl)) {
                count++;
            }
        }

        if (count == 0) {
            return "There is no such clothing as " + cl + " in Clothing[] Array";
        } else if (count == 1) {
            return "There is " + count + " instance of " + cl + " in Clothing[] Array";
        }
        return "There are " + count + " instances of " + cl + " in Clothing[] Array";
    }
}

/**
 * {@link Clothing} class which represents an item of clothing with type,
 * brand, size, color and price information.
 */
class Clothing {
    private final String type;
    private final String brand;
    private final String size;
    private final String color;
    private double price;

    /**
     * {@link Clothing} class constructor.
     * @param type  type of clothing
     * @param brand brand of clothing
     * @param size  size of clothing
     * @param color color of clothing
     * @param price price of clothing
     * @throws IllegalArgumentException if any of the parameters is null or the price is less than 0
     */
    public Clothing(String type, String brand, String size, String color, double price) {
        if (type == null || brand == null || size == null || color == null || price < 0) {
            throw new IllegalArgumentException("Parameters cannot be null or price cannot be less than 0");
        }

        this.type = type;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    /**
     * Returns the clothing type
     *
     * @return type of this {@link Clothing} instance
     */
    public String getType() {return type;}

    /**
     * Returns the clothing brand
     *
     * @return brand of this {@link Clothing} instance
     */
    public String getBrand() {return brand;}

    /**
     * Returns the clothing size
     *
     * @return size of this {@link Clothing} instance
     */
    public String getSize() {return size;}

    /**
     * Returns the clothing color
     *
     * @return color of this {@link Clothing} instance
     */
    public String getColor() {return color;}

    /**
     * Returns the clothing price
     *
     * @return price of this {@link Clothing} instance
     */
    public double getPrice() {return price;}

    /**
     * Sets the new price for this {@link Clothing} instance
     *
     * @param price new price of this {@link Clothing} instance
     */
    public void setPrice(double price) {this.price = price;}

    /**
     * Returns the text representation of the {@link Clothing} object.
     * @return text representation of the {@link Clothing} object.
     */
    @Override
    public String toString() {
        return "Clothing {" +
                "type=" + type +
                ", brand=" + brand +
                ", size=" + size +
                ", color=" + color +
                ", price=" + price +
                '}';
    }

    /**
     * Compares two {@link Clothing} objects for equality by all fields.
     * @param obj object to compare with the current object
     * @return {@code true} if the objects are equal; {@code false} otherwise
     * @throws IllegalArgumentException if a parameter object is null
     *         or not an instance of {@link Clothing} object
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Parameter cannot be null");
        }
        if (!(obj instanceof Clothing)) {
            throw new IllegalArgumentException("Parameter object must be an instance of Clothing object.");
        }

        Clothing other = (Clothing) obj;

        return (
                this.getType().equals(other.getType()) &&
                this.getBrand().equals(other.getBrand()) &&
                this.getSize().equals(other.getSize()) &&
                this.getColor().equals(other.getColor()) &&
                (this.getPrice() == other.getPrice())
        );
    }

    /**
     * Static method which returns a comparator {@link PriceAndSizeComparator}
     * to sort objects by price and size.
     * @return comparator to sort
     */
    static Comparator<Clothing> priceAndSizeComparator() {
        return new PriceAndSizeComparator();
    }

    /**
     * {@link Comparator} class for comparing {@link Clothing} objects by price
     * and size.
     */
    static class PriceAndSizeComparator implements Comparator<Clothing> {
        private final String[] sizes = {"XS", "S", "M", "L", "XL"};

        /**
         * Compares two {@link Clothing} objects by size (in ascending order)
         * and price (in descending order)
         * @param cl1 the first object {@link Clothing} to be compared.
         * @param cl2 the second object {@link Clothing} to be compared.
         * @return {@code -1} if {@code cl1} is less than {@code cl2};
         *         {@code 1} value if {@code cl1} is greater than {@code cl2};
         *         {@code 0} if equal
         * @throws IllegalArgumentException if given compared {@link Clothing} objects are null
         */
        @Override
        public int compare(Clothing cl1, Clothing cl2) {
            if (cl1 == null || cl2 == null) {
                throw new IllegalArgumentException("Clothing objects for comparison cannot be null.");
            }

            int index1 = findIndexInStringArray(sizes, cl1.getSize());
            int index2 = findIndexInStringArray(sizes, cl2.getSize());

            if (index1 < index2) {
                return -1;
            } else if (index1 > index2) {
                return 1;
            } else {
                if (cl1.getPrice() > cl2.getPrice()) {
                    return -1;
                }
                else if (cl1.getPrice() < cl2.getPrice()) {
                    return 1;
                }
                else { // cl1.getPrice() == cl2.getPrice()
                    return 0;
                }
            }
        }

        /**
         * Finds the index of the given {@link String} in the given array of {@code Strings}
         * @param arr    array of {@link String}
         * @param target {@link String} whose index is searched in a {@code String[]} array
         * @return index of given {@link String} in a {@code String[]} array
         *         or {@code -1} if not found
         * @throws IllegalArgumentException if searched String or array is null
         */
        private int findIndexInStringArray(String[] arr, String target) {
            if (target == null || arr == null) {
                throw new IllegalArgumentException("Target String or array cannot be null.");
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals(target)) {
                    return i;
                }
            }
            return -1;
        }
    }
}

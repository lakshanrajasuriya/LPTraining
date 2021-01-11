import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws QuantityException {
        int stockAvailable = 0;
        int userNeed = 0;
        stockAvailable = getCount();
        try {
            userNeed = getUserAmount();
            reduceStock(stockAvailable, userNeed);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getUserAmount() {
        int amount = 0;
        System.out.print("Enter the item count: ");
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextInt();
        if (amount < 0)
            throw new RuntimeException("Invalid User stock amount");
        return amount;
    }

    public static int getCount() {
        int data = 0;
        try {
            File file = new File("stock.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data = scanner.nextInt();
            }
            scanner.close();

        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return data;
    }

    public static void reduceStock(int avail, int need) throws QuantityException {
        if (need> avail)
            throw new QuantityException("There are not enough stocks!");
        int updatedValue  = avail - need;
        saveNewStock(updatedValue);
    }

    public static void saveNewStock(int newStock) throws QuantityException {
        System.out.println("Available Stock is "+newStock);
        System.out.println("Save New Stock");

        if (newStock < 0) {
            throw new QuantityException("value cannot be less than 0");
        }

        try {
            FileWriter fileWriter = new FileWriter("stock.txt");
            fileWriter.write(newStock + "");
            fileWriter.close();
        } catch (IOException ioException) {
            System.out.println("Cannot find stock file to save new amount!");
        }
    }

}

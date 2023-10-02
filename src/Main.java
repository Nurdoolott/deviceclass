import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the number of devices to create (between 1 and 20): ");
        int numDevices = scanner.nextInt();

        if (numDevices < 1 || numDevices > 20) {
            System.out.println("Invalid input. Please enter a number between 1 and 20.");
            return;
        }

        ArrayList<Device> devices = new ArrayList<>();

        for (int i = 0; i < numDevices; i++) {
            String[] deviceTypes = {"Smartphone", "Laptop", "Tablet"};
            String randomType = deviceTypes[random.nextInt(deviceTypes.length)];
            double randomPrice = 100 + random.nextDouble() * 1900;
            double randomWeight = 100 + random.nextDouble() * 900;

            if (randomType.equals("Smartphone")) {
                double randomScreenSize = 3 + random.nextDouble() * 5;
                int randomCameraResolution = 5 + random.nextInt(16);
                devices.add(new Smartphone(randomType, randomPrice, randomWeight, randomScreenSize, randomCameraResolution));
            } else if (randomType.equals("Laptop")) {
                String[] processors = {"Intel i5", "Intel i7", "AMD Ryzen 5"};
                String randomProcessor = processors[random.nextInt(processors.length)];
                int randomRamSize = 4 + random.nextInt(13);
                devices.add(new Laptop(randomType, randomPrice, randomWeight, randomProcessor, randomRamSize));
            } else if (randomType.equals("Tablet")) {
                String[] brands = {"Apple", "Samsung", "Microsoft"};
                String randomBrand = brands[random.nextInt(brands.length)];
                boolean randomHasStylus = random.nextBoolean();
                devices.add(new Tablet(randomType, randomPrice, randomWeight, randomBrand, randomHasStylus));
            }
        }

        // Calculate and display information
        System.out.println("\nDevices created:");
        for (Device device : devices) {
            System.out.println("Type: " + device.getType() + ", Price: $" + device.getPrice() + ", Weight: " + device.getWeight() + "g");
        }

        // Calculate the number of distinct device types
        int distinctTypes = (int) devices.stream().map(Device::getType).distinct().count();
        System.out.println("\nNumber of distinct device types created: " + distinctTypes);

        // Calculate the total price of all devices
        double totalPrice = devices.stream().mapToDouble(Device::getPrice).sum();
        System.out.println("Total price of all devices: $" + totalPrice);

        // Calculate the total weight of all devices
        double totalWeight = devices.stream().mapToDouble(Device::getWeight).sum();
        System.out.println("Total weight of all devices: " + totalWeight + "g");
    }
}


import java.util.Scanner;

/***************************************************************
 * Filename     : BMICalculator.java
 * Description  : A console-based BMI Calculator with unit options
 * Author       : Saloni Rupeja
 ***************************************************************/

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input weight
        System.out.print("Enter your weight in kg: ");
        double weight = sc.nextDouble();

        // Unit selection for height
        System.out.println("Select height unit:");
        System.out.println("1. Meters");
        System.out.println("2. Centimeters");
        System.out.println("3. Feet");
        System.out.print("Enter your choice: ");

        // Validate height unit choice
        if (!sc.hasNextInt()) {
            System.out.println("❌ Please enter a valid number for unit choice!");
            sc.close();
            return;
        }
        int choice = sc.nextInt();

        double heightMeters = 0;

        // Get height based on chosen unit
        switch (choice) {
            case 1:
                System.out.print("Enter height in meters: ");
                heightMeters = sc.nextDouble();
                break;
            case 2:
                System.out.print("Enter height in centimeters: ");
                double heightCm = sc.nextDouble();
                heightMeters = heightCm / 100;
                break;
            case 3:
                System.out.print("Enter height in feet: ");
                double heightFeet = sc.nextDouble();
                heightMeters = heightFeet * 0.3048;
                break;
            default:
                System.out.println("❌ Invalid unit choice! Please restart the program.");
                sc.close();
                return;
        }

        // Validate height input
        if (heightMeters <= 0) {
            System.out.println("❌ Height must be greater than zero!");
            sc.close();
            return;
        }

        // Calculate BMI
        double bmi = weight / (heightMeters * heightMeters);

        // Display BMI result
        System.out.printf("Your BMI is: %.2f%n", bmi);

        // Display BMI category
        if (bmi < 18.5) {
            System.out.println("You are Underweight");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("You are Normal weight");
        } else if (bmi >= 25 && bmi < 29.9) {
            System.out.println("You are Overweight");
        } else {
            System.out.println("You are Obese");
        }

        sc.close();
    }
}

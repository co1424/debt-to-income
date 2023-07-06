import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user's after-tax income
        System.out.print("Enter your after-tax income: ");
        double income = scanner.nextDouble();

        // Calculate maximum loan amount based on a debt-to-income ratio
        double debtToIncomeRatio = 0.4; // Assuming a debt-to-income ratio of 40%
        double maxLoanAmount = income * debtToIncomeRatio;

        // Display the maximum loan amount
        System.out.println("Based on your after-tax income, you can borrow up to $" + maxLoanAmount);

        // Ask user for loan amount
        System.out.print("Enter the desired loan amount: ");
        double loanAmount = scanner.nextDouble();

        // Check if the loan amount is within the allowed limit
        if (loanAmount <= maxLoanAmount) {
            System.out.println("Congratulations! Your loan has been approved.");
        } else {
            System.out.println("Sorry, your loan application has been rejected.");
        }

        // Calculate monthly payment based on loan amount and interest rate
        double interestRate = 0.05; // Assuming an interest rate of 5%
        int loanTermInMonths = 12; // Assuming a loan term of 12 months
        double monthlyInterestRate = interestRate / loanTermInMonths;
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -loanTermInMonths));

        // Display the monthly payment amount rounded to two decimal places
        System.out.printf("Your monthly payment amount is $%.2f%n", monthlyPayment);


        // Provide an option to calculate a new loan
        System.out.print("Do you want to calculate another loan? (yes/no): ");
        String calculateAnotherLoan = scanner.next();

        // Loop to calculate multiple loans if desired by the user
        while (calculateAnotherLoan.equalsIgnoreCase("yes")) {
            System.out.print("Enter your after-tax income: ");
            income = scanner.nextDouble();
            maxLoanAmount = income * debtToIncomeRatio;

            System.out.println("Based on your after-tax income, you can borrow up to $" + maxLoanAmount);

            System.out.print("Enter the desired loan amount: ");
            loanAmount = scanner.nextDouble();

            if (loanAmount <= maxLoanAmount) {
                System.out.println("Congratulations! Your loan has been approved.");
            } else {
                System.out.println("Sorry, your loan application has been rejected.");
            }

            monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -loanTermInMonths));

            System.out.println("Your monthly payment amount is $" + monthlyPayment);

            System.out.print("Do you want to calculate another loan? (yes/no): ");
            calculateAnotherLoan = scanner.next();
        }

        System.out.println("Thank you for using the Loan Calculator. Goodbye!");
        scanner.close();
    }
}

package cinema;
import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        String[][] seatArray = new String[rows+1][seats+1];
        seatArray = seatCinemaVisualisation(seatArray);
        int rowsChoosen = 0;
        int seatsNumberInRowChoosen = 0;
        int currentIncome = 0;
        int purchasedTicket = 0;
        boolean cinema_on = true;

        while (cinema_on){
            System.out.println("");
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    seatArray = seatNumberVisualisation(seatArray);
                    break;
                case 2:
                    while (true) {
                        System.out.println("");
                        System.out.println("Enter a row number:");
                        rowsChoosen = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seatsNumberInRowChoosen = scanner.nextInt();
                        if ((rowsChoosen < 1 || rowsChoosen > rows) ||  (seatsNumberInRowChoosen < 1 || seatsNumberInRowChoosen > seats)){
                            System.out.println("Wrong input!");
                            continue;
                        }
                        if (seatArray[rowsChoosen][seatsNumberInRowChoosen] == "B") {
                            System.out.println("That ticket has already been purchased!");
                        } else {
                            seatArray[rowsChoosen][seatsNumberInRowChoosen] = "B";
                            System.out.println("Ticket price $" + seatTicket(rows,seats,rowsChoosen));
                            currentIncome += seatTicket(rows,seats,rowsChoosen);
                            purchasedTicket += 1;
                            break;
                        }
                    }
                    break;
                case 3:
                    statistics(rows, seats, currentIncome, purchasedTicket);
                    break;
                case 0:
                    cinema_on = false;
                    break;
            }
        }
    }

    static void statistics(int rows, int seats, int currentIncome, int purchasedTicket) {
        System.out.println("");
        System.out.println("Number of purchased tickets: " + purchasedTicket);
        double percentagePurchasedTicket = (1.0 * purchasedTicket) / (rows * seats) * 100.00;
        System.out.printf("Percentage: %.2f%%%n",percentagePurchasedTicket);
        System.out.println("Current income: $" +currentIncome);
        System.out.println("Total income: $" +profitCalculation(rows, seats));
    }


    static int profitCalculation(int rows, int seats) {
        // profit calculation
        int priceTicket = 10;
        int discountTicket = 8;
        int profit = 0;
        int totalSeats = rows * seats;
        if (totalSeats <= 60) {
            profit = priceTicket * totalSeats;
        } else {
            int halfRow = rows/2;
            profit = (halfRow * seats)*priceTicket + ((rows - halfRow) * seats ) * discountTicket;
        }
        return profit;
    }

    static int seatTicket(int rows, int seats, int rowsChoosen) {
        // profit calculation
        int priceSeatTicket;
        int totalSeats = rows * seats;
        if (totalSeats <= 60) {
            priceSeatTicket = 10;
        } else {
            int halfRow = rows/2;
            if (rowsChoosen <= halfRow) {
                priceSeatTicket = 10;
            } else {
                priceSeatTicket = 8;
            }
        }
        return priceSeatTicket;
    }

    static String[][] seatCinemaVisualisation(String seatArray[][]) {
        // cinema visualisation
        for (int y = 0; y < seatArray.length; y++) {
            for (int x = 0; x < seatArray[y].length; x++) {
                seatArray[y][x] ="S";
                if (y==0) {
                    seatArray[y][x] = String.valueOf(x);
                }
                if (x==0) {
                    seatArray[y][x] = String.valueOf(y);
                }
            }
        }
        seatArray[0][0] = " ";
        return seatArray;
    }

    static String[][] seatNumberVisualisation(String seatArray[][]) {
        // seat visualisation
        System.out.println("");
        System.out.println("Cinema:");

        for ( int i = 0; i < seatArray.length; ++i) {
            for( int j = 0; j < seatArray[i].length; ++j) {
                System.out.print(seatArray[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        return seatArray;
    }
}
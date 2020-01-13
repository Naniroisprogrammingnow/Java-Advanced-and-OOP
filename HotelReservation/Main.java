package HotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        double price = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        Season season = Season.valueOf(tokens[2].toUpperCase());
        DiscountType discount = DiscountType.valueOf(tokens[3].toUpperCase());
        Reservation reservation = new Reservation(price, days, season, discount);
        double priceTotal  = PriceCalculator.caclculate(reservation);
        System.out.printf("%.2f%n", priceTotal);
    }
}

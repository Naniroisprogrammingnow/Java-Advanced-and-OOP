package HotelReservation;

public class PriceCalculator {
    public static double caclculate(Reservation reservation){
        double basePrice = reservation.getPricePerDay() * reservation.getNumberOfDays()
                * reservation.getSeason().getMulriplyer();
        double percentDiscount = 1-(reservation.getDiscountType().getPercentDiscount()/100);
        return basePrice*percentDiscount;
    }
}

package HotelReservation;

public enum  DiscountType {
    VIP(20),
    SECOND_VISIT(10),
    NONE(0);
    private double percentDiscount;

    public double getPercentDiscount() {
        return percentDiscount;
    }

    DiscountType(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }
}

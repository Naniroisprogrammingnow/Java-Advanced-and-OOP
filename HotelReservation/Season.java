package HotelReservation;

public enum Season {
    AUTUMN (1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int mulriplyer;
    Season(int mulriplyer){
        this.mulriplyer = mulriplyer;
    }

    public int getMulriplyer() {
        return mulriplyer;
    }
}

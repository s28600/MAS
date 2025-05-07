package s28600_MP4.Own;

import java.time.LocalDate;

public class CarReservation {
    private static int MinAgeToReserve = 18;
    private int reserveAge;
    private LocalDate reserveDateFrom;
    private LocalDate reserveDateTo;

    public CarReservation(int reserveAge, LocalDate reserveDateFrom, LocalDate reserveDateTo) {
        setReserveAge(reserveAge);
        setReserveDateFrom(reserveDateFrom);
        setReserveDateTo(reserveDateTo);
    }

    public static int getMinAgeToReserve() {
        return MinAgeToReserve;
    }

    public int getReserveAge() {
        return reserveAge;
    }

    private void setReserveAge(int reserveAge) {
        if (reserveAge < MinAgeToReserve)
            throw new IllegalArgumentException("Reservation age must be at least " + MinAgeToReserve);
        this.reserveAge = reserveAge;
    }

    public LocalDate getReserveDateFrom() {
        return reserveDateFrom;
    }

    private void setReserveDateFrom(LocalDate reserveDateFrom) {
        if (reserveDateFrom == null)
            throw new IllegalArgumentException("Reservation Date cannot be null");
        this.reserveDateFrom = reserveDateFrom;
    }

    public LocalDate getReserveDateTo() {
        return reserveDateTo;
    }

    private void setReserveDateTo(LocalDate reserveDateTo) {
        if (reserveDateTo == null)
            throw new IllegalArgumentException("Reservation Date cannot be null");
        if (reserveDateTo.isBefore(reserveDateFrom))
            throw new IllegalArgumentException("Reservation end date cannot be before reservation beginning date");
        this.reserveDateTo = reserveDateTo;
    }
}

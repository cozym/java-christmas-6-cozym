package christmas.model;

public class Date {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private final int date;

    public Date(String date) throws IllegalArgumentException {
        this.date = validateNumber(date);
    }

    private int validateNumber(String date) throws IllegalArgumentException {
        try {
            int dateNum = Integer.parseInt(date);
            validateRange(dateNum);
            return dateNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.invalidDate());
        }
    }

    private void validateRange(int date) throws IllegalArgumentException {
        if (date < MIN_DATE || date > MAX_DATE) {
            throw new IllegalArgumentException(ErrorMessage.invalidDate());
        }
    }

}

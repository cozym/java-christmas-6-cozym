package christmas.model;

public enum Menus {
    MUSHROOM_SOUP("양송이수프",6000,"Appetizer"),
    TAPAS("타파스",5500,"Appetizer"),
    CAESAR_SALAD("시저샐러드",8000,"Appetizer"),
    TBONE_STEAK("티본스테이크",55000,"MainDish"),
    BBQ_RIBS("바비큐립",54000,"MainDish"),
    SEAFOOD_PASTA("해산물파스타",35000,"MainDish"),
    CHRISTMAS_PASTA("크리스마스파스타",25000,"MainDish"),
    CHOCOLATE_CAKE("초코케이크",15000,"Dessert"),
    ICECREAM("아이스크림",5000,"Dessert"),
    ZERO_COLA("제로콜라",3000,"Beverage"),
    RED_WINE("레드와인",60000,"Beverage"),
    CHAMPAGNE("샴페인",25000,"Beverage");


    private String name;
    private int price;
    private String Classification;

    private Menus(String name,int price, String Classification) {
        this.name = name;
        this.price = price;
        this.Classification = Classification;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public String getClassification() {
        return this.Classification;
    }
}

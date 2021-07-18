public class Phone {

    private int price;
    private int performance;

    public Phone() {

    }

    public Phone(int price, int performance) {
        this.price = price;
        this.performance = performance;
    }

    public String phoneInfo() {
        String result = String.format("Стоимость телефона = %d, а его производительность = %d", price, performance);
        return result;
    }
}

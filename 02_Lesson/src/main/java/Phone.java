public class Phone {

    private int price;
    private int performance;

    public Phone() {

    }

    public Phone(int price, int performance) {
        this.price = price;
        this.performance = performance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public String phoneInfo() {
        String result = String.format("Стоимость телефона = %d, а его производительность = %d", price, performance);
        return result;
    }

    @Override
    public String toString() {
        String result = String.format("Объект класса Phone со стоимостью = %d, и производительностью = %d", price, performance);
        return result;
    }
}

public class Product implements IProducer {
    public void sale(Float money) {
        System.out.println("销售"+money);
    }

    public void aftersale(Float money) {
        System.out.println("售后"+money);
    }
}

package Classes;

/**
 * Класс Продукт
 */
public class Product {
    /**
     * @param Имя продукта
     */
    private String nameProduct;
    /**
     * @param Цена продукта
     */
    private int priceProduct;
    /**
     * @param Количество продуктов
     */
    private int countProduct;

    public Product(String nameProduct, int priceProduct, int countProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.countProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public int getPriceProduct() {
        return priceProduct;
    }
    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }
    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }


    @Override
    public String toString() {
        return nameProduct + ", стоимость: " + priceProduct + " рублей";
    }
}

import Classes.Buyer;
import Classes.Market;
import Classes.Order;
import Classes.Product;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Product water = new Product("Минеральная вода", 50, 20);
        Product bread = new Product("Хлеб", 45, 10);
        Product chips = new Product("Русский картофель", 59, 25);
        Product snickers = new Product("Сникерс", 70, 42);
        Product berry = new Product("Клубника", 250, 20);
        Product сucumber = new Product("Огурец", 60, 10);

        ArrayList<Product> marketList = new ArrayList<>();
        marketList.add(water);
        marketList.add(bread);
        marketList.add(chips);
        marketList.add(snickers);
        marketList.add(berry);
        marketList.add(сucumber);

        Buyer anton = new Buyer("Антон", null);
        Buyer anna = new Buyer("Анна", null);
        Buyer german = new Buyer("Герман", null);
        Buyer genady = new Buyer("Геннадий", null);

        ArrayList<Buyer> queue = new ArrayList<>();
        queue.add(anton);
        queue.add(anna);
        queue.add(german);
        queue.add(genady);

        Market market = new Market();
        market.marketWork(queue, marketList);

    }
}
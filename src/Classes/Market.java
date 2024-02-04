package Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Market {

    private ArrayList<Buyer> queue;
    private ArrayList<Product> marketList = new ArrayList<Product>();

    public ArrayList<Product> getMarketList() {
        return marketList;
    }

    public void setMarketList(ArrayList<Product> marketList) {
        this.marketList = marketList;
    }

    /**
     *
     * @param queue очередь, в которую встают покупатели, чтобы сделать заказ
     * @param marketList общий список товаров, представленных в магазине
     * @throws IOException исключение, обрабатывающее неверно введенный номер товара
     * Метод, описывающий работу магазина: покупатель приходит в магазин, встает в очередь, делает заказ, уходит, новый покупатель делает заказ. В конце выводится список заказов.
     */
    public void marketWork (ArrayList<Buyer> queue, ArrayList<Product> marketList) throws IOException {
        for(Buyer buyer: queue)
        {
            System.out.println(buyer + " пришел(ла) в магазин");

            buyer.setOrder(buy(marketList));
            System.out.println(buyer.toString2());
            System.out.println("=====================================");
        }
        System.out.println("Все посетители покинули магазин");
        System.out.println("Список покупок: ");
        readFile();
    }

    /**
     *
     * @param order очередь, в которую встают покупатели, чтобы сделать заказ
     * Метод, записывающий данные о сделанных заказах в файл (создает новый, если файл отсутствует)
     */
    public void whriteInFile(ArrayList<Product> order)
    {
        try {
            FileWriter writer = new FileWriter("BuyList.txt", true);
            writer.write(order.toString() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    /**
     * Метод, читающий данные из файла.
     */
    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("BuyList.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    /**
     *
     * @param marketList общий список товаров, представленных в магазине
     * @return возвращает заказ, сделанный покупателем
     * Метод воспроизводит алгоритм заказа товаров в магазине. Обрабатывает исключения в случае некорректно введенного номера товара.
     */
    public Order buy (ArrayList<Product> marketList)
    {
        ArrayList<Product> order = new ArrayList<Product>();
        System.out.println("Сделайте заказ!");
        for(Product product: marketList)
        {
            if (product.getCountProduct() > 0)
            {
                System.out.println(marketList.indexOf(product)+ 1 + " " + product.toString());
            }
        }

        System.out.println("Выберите продукт, введя его номер в консоль.");
        Scanner in = new Scanner(System.in);
        String numberProduct;
        while (true) {
            try {
                numberProduct = in.next();
                if (Integer.parseInt(numberProduct) > 0 && Integer.parseInt(numberProduct) <= marketList.size()) {
                    order.add(marketList.get(Integer.parseInt(numberProduct) - 1));
                    break;
                } else {
                    System.out.println("Выбранного товара не существует, попробуйте еще раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка, введен некорректный номер товара, попробуйте еще раз.");
            }
        }
        while (true) {
            for (Product product : marketList) {
                if (product.getCountProduct() > 0) {
                    System.out.println(marketList.indexOf(product) + 1 + " " + product.toString());
                }
            }
            System.out.println("Выберите еще продукт, введя его номер в консоль. Если все товары выбраны, нажмите 0");
            try {
                numberProduct = in.next();
                if(Integer.parseInt(numberProduct) >= 0 && Integer.parseInt(numberProduct) <= marketList.size()) {
                    if (Integer.parseInt(numberProduct) >= 0 && Integer.parseInt(numberProduct) <= marketList.size()) {
                        if (Integer.parseInt(numberProduct) == 0) {
                            Order newOrder = new Order(order);
                            return newOrder;
                        } else {
                            order.add(marketList.get(Integer.parseInt(numberProduct) - 1));
                        }
                        whriteInFile(order);
                    }
                }
                else {
                    System.out.println("Выбранного товара не существует, попробуйте еще раз.");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Ошибка, введен некорректный номер товара, попробуйте еще раз.");
            }
        }
    }
}


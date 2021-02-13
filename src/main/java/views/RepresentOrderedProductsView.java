package views;

import models.Product;
import repositories.ProductRepository;
import utils.ConsoleReadWrite;
import utils.PropertyReader;

public class RepresentOrderedProductsView extends View {
    public RepresentOrderedProductsView() {
        super(PropertyReader.getProperty("represent.ordered.products.view"));
    }

    @Override
    public View interact() {
        ConsoleReadWrite.clearConsole();
        showNavigationMessage();
        Object[][] arrProductTotalOrder = ProductRepository.getOrderedProductsWithTotalQuantity();

        for (Object[] objects : arrProductTotalOrder) {
            Product product = (Product) objects[0];
            showNavigationMessage("     " + product.getName() + "           " +
                    product.getPrice() + "              " +
                    product.getStatus() + "      " + objects[1]);
        }

        showNavigationMessage(PropertyReader.getProperty("enter.something"));
        ConsoleReadWrite.readConsoleInput();
        return new HomeView();
    }
}

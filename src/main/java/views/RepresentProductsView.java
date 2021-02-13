package views;

import models.Product;
import repositories.ProductRepository;
import utils.ConsoleReadWrite;
import utils.PropertyReader;

import java.util.List;

public class RepresentProductsView extends View {
    public RepresentProductsView() {
        super(PropertyReader.getProperty("represent.products.view"));
    }

    @Override
    public View interact() {
        ConsoleReadWrite.clearConsole();
        showNavigationMessage();
        List<Product> products = ProductRepository.getAllProducts();

        for (Product product : products) {
            showNavigationMessage("       " + product.getName() + "           "
                    + product.getPrice() + "          " + product.getStatus());
        }

        showNavigationMessage(PropertyReader.getProperty("enter.something"));
        ConsoleReadWrite.readConsoleInput();
        return new HomeView();
    }
}

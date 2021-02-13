package views;

import models.Order;
import utils.ConsoleReadWrite;
import utils.PropertyReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RepresentOrdersView extends View {
    private final List<Order> orders;

    public RepresentOrdersView(List<Order> orders) {
        super(PropertyReader.getProperty("represent.orders.view"));
        this.orders = orders;
    }

    @Override
    public View interact() {
        ConsoleReadWrite.clearConsole();
        showNavigationMessage();

        for (Order order : orders) {
            showNavigationMessage("         " + order.getId() + "              " + order.calculateTotalPrice() +
                    "                  " + order.calculateTotalItemsQuantity() + "          " +
                    order.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        }

        showNavigationMessage(PropertyReader.getProperty("enter.something"));
        ConsoleReadWrite.readConsoleInput();
        return new HomeView();
    }
}

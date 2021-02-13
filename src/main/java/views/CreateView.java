package views;

import utils.ConsoleReadWrite;
import utils.PropertyReader;

public class CreateView extends View{
    public CreateView() {
        super(PropertyReader.getProperty("create.view.message"));
    }

    @Override
    public View interact() {
        ConsoleReadWrite.clearConsole();
        View nextView;
        showNavigationMessage();
        String input = ConsoleReadWrite.readConsoleInput();

        switch (input) {
            case "1":
                nextView = new CreateProductView();
                break;
            case "2":
                nextView = new CreateOrderView();
                break;
            case "3":
                nextView = new HomeView();
                break;
            case "4":
                System.exit(0);
            default:
                ConsoleReadWrite.showErrorMessageWithTimePause(PropertyReader.getProperty("wrong.input.simple"));
                nextView = this;
        }

        return nextView;
    }
}

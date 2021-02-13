package views;

import utils.ConsoleReadWrite;
import utils.PropertyReader;

public class HomeView extends View {
    public HomeView() {
        super(PropertyReader.getProperty("home.view.message"));
    }

    @Override
    public View interact() {
        ConsoleReadWrite.clearConsole();
        View nextView;
        showNavigationMessage();
        String input = ConsoleReadWrite.readConsoleInput();

        switch (input) {
            case "1":
                nextView = new CreateView();
                break;
            case "2":
                nextView = new RemoveView();
                break;
            case "3":
                nextView = new RepresentView();
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

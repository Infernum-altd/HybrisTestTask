import views.HomeView;
import views.View;

public class Main {
    public static void main(String[] args) {
        View view = new HomeView();
        while (true) {
            view = view.interact();
        }
    }
}

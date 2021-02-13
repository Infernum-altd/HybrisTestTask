package views;

import lombok.Data;

@Data
public abstract class View {
    protected String navigationMessage;
    public abstract View interact();

    public View(String navigationMessage) {
        this.navigationMessage = navigationMessage;
    }

    protected void showNavigationMessage() {
        System.out.println(navigationMessage);
    }

    protected void showNavigationMessage(String navigationMessage) {
        System.out.println(navigationMessage);
    }
}

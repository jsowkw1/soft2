package Asiq2;

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created a macOS button.");
    }
}

class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created a macOS checkbox.");
    }
}

class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created a Windows button.");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created a Windows checkbox..");
    }
}

public class App {
    private final GUIFactory factory;

    public App(GUIFactory factory) {
        this.factory = factory;
    }

    public void createUI() {
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {
        System.out.println("Using the macOS Factory:");
        GUIFactory macFactory = new MacOSFactory();
        App macApp = new App(macFactory);
        macApp.createUI();

        System.out.println("\n--------------------------\n");

        System.out.println("Using Windows Factory:");
        GUIFactory winFactory = new WindowsFactory();
        App winApp = new App(winFactory);
        winApp.createUI();
    }
}
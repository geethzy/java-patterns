import java.util.*;

public class Main {
    public static void main(String[] args) {

        NameStoreAdapter nameStoreAdapter = NameStoreFactory.create(args);
        UI ui = UIFactory.create(nameStoreAdapter, args);
        //UI ui = new GUI(nameStoreAdapter);
        ui.show();
    }
}

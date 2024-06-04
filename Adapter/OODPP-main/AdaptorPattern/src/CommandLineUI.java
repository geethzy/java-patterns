import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CommandLineUI implements UI{

    private final Scanner input = new Scanner(System.in);
    private final List<String> allowedOperations = Arrays.asList("store", "read", "exit");

    private final NameStoreAdapter nameStoreAdapter;

    public CommandLineUI(NameStoreAdapter nameStoreAdapter) {
        this.nameStoreAdapter = nameStoreAdapter;
    }

    @Override
    public void show() {
        while(true) {
            System.out.print("Enter the operation (store/read/exit) : ");
            String response = input.nextLine();

            if (!allowedOperations.contains(response.toLowerCase(Locale.ROOT))) {
                System.out.println("Operation " + response + " is not permitted.");
                continue;
            }

            if(response.equals("store")) {
                System.out.print("Enter the id : ");
                String id = input.nextLine();
                System.out.print("Enter the name : ");
                String name = input.nextLine();

                nameStoreAdapter.store(id, name); //different
                System.out.println("id = " + id + ", name = " + name + " added successfully.");
            } else if (response.equals("read")) {
                System.out.print("Enter the id :");
                String id = input.nextLine();

                String name = nameStoreAdapter.read(id);  // different
                System.out.println("The name is " + name);
            }
            else if (response.equals("exit")) {
                break;
            }
        }
    }
}

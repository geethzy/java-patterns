import java.util.Locale;

public class UIFactory {
    public static UI create(NameStoreAdapter nameStoreAdapter, String[] args) {
        if(isFlagExist(args,"-gui")) {
            return new GUI(nameStoreAdapter);
        } else {
            return new CommandLineUI(nameStoreAdapter);
        }
    }

    private static boolean isFlagExist(String[]  args, String flag) {
        for (String arg : args) {
            return arg.toLowerCase(Locale.ROOT).contains(flag.toLowerCase(Locale.ROOT));
        }

        return false;
    }
}

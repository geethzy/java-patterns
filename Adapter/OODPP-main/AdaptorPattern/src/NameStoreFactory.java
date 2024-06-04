import java.util.Arrays;
import java.util.Locale;

public class NameStoreFactory {
    public static NameStoreAdapter create(String[] args) {
        if(Arrays.stream(args).anyMatch(a -> a.toLowerCase(Locale.ROOT).equals("-dryrun"))) {
            return new InMemoryNameStore();
        } else {
            return new FileNameStore();
        }
    }
}

import java.util.HashMap;
import java.util.Map;

public class InMemoryNameStore implements NameStoreAdapter {

    Map<String, String> map = new HashMap<>();

    @Override
    public void store(String id, String name) {
        map.put(id, name);
    }

    @Override
    public String read(String id) {
        return map.get(id);
    }
}

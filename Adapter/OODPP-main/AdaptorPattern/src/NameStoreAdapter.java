public interface NameStoreAdapter {
    void store(String id, String name);
    String read(String id);
}

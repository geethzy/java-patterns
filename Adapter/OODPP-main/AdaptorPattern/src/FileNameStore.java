import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileNameStore implements NameStoreAdapter{

    private static final String FILE_NAME = "name_store.txt";

    @Override
    public void store(String id, String name) {

        Path filePath = Path.of(FILE_NAME);
        try {
            Files.writeString(filePath, id + ',' + name + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new StorageException("Cannot write "+ id + ", " + name + " to the file "+ filePath, e);
        }
    }

    @Override
    public String read(String id) {
        Path filePath = Path.of(FILE_NAME);
        try {
            List<String> lines = Files.readAllLines(filePath);
            return lines.stream()
                    .filter(l -> l.startsWith(id + ","))
                    .map(l -> l.split(",")[1])
                    .findFirst()
                    .orElseThrow(() -> new EntryNotFoundException("The entry with id " + id + " is not found."));
        } catch (IOException e) {
            throw new StorageException("File " + filePath + " reading failed for the id = " + id, e);
        }
    }
}

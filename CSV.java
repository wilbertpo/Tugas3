import java.nio.file.Path;
import java.util.List;

public interface CSV<T> {
	void write(Path path, List<T> items);
	List<T> read(Path path);
}
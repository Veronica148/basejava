import java.util.NoSuchElementException;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    int arraySize = 0;

    void clear() {
        for (int i = 0; i < arraySize; i++) {
            storage[i] = null;
        }
        arraySize = 0;
    }

    void save(Resume r) {
        storage[arraySize] = r;
        arraySize++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < arraySize; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < arraySize; i++) {
            if (storage[i].toString().equals(uuid)) {
                storage[i] = null;
                System.out.println("Element " + uuid + " was deleted");
                for (int j = i; j < arraySize; j++) {
                    storage[j] = storage[j+1];
                }
                arraySize--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] curStorage = new Resume[arraySize];
        for (int i = 0; i < arraySize; i++) {
            curStorage[i] = storage[i];
        }
        return curStorage;
    }

    int size() {
        return arraySize;
    }
}

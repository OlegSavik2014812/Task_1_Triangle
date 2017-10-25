package by.epam.util;

import java.io.File;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public final class FileUtils {

    private FileUtils() {
    }

    public static File openFile(String pathOfFile) {
        if (pathOfFile == null || pathOfFile.isEmpty()) {
            return null;
        }
        File f = new File(pathOfFile);
        if (f.canRead()) {
            return f;
        }
        return null;
    }
}

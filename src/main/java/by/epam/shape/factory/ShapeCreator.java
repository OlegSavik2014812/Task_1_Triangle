package by.epam.shape.factory;

import by.epam.exception.CouldNotCreateShapeException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Oleg Savik on 08.10.2017.
 */

public abstract class ShapeCreator {

    public void createFromFile(File file,String delimiter) throws CouldNotCreateShapeException {
        //
        if (file == null) {
         throw new CouldNotCreateShapeException("link is empty");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                create(line,delimiter);
            }
        } catch (IOException e) {
            throw new CouldNotCreateShapeException("Bad File: " + file, e);
        }
    }

    public abstract void create(String line,String delimiter) throws CouldNotCreateShapeException;
}

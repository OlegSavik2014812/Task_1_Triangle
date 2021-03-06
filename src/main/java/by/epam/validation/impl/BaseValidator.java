package by.epam.validation.impl;

import by.epam.shape.model.Triangle;
import by.epam.validation.Validator;

import java.awt.*;
import java.util.List;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public abstract class BaseValidator<T> implements Validator<T> {
    private Validator<T> next;

    @Override
    public Validator<T> setNext(Validator<T> validator) {
        this.next = validator;
        return validator;
    }

    boolean validateNext(T item) {
        if (next == null) {
            return true;
        }
        return next.validate(item);
    }
}

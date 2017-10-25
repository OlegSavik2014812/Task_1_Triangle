package by.epam.validation;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public interface Validator<T> {

  Validator<T> setNext(Validator<T> v);

  boolean validate(T type);

}

package by.epam.validation;

/**
 * Created by Oleg Savik on 08.10.2017.
 */
public abstract class BaseValidator<T> implements Validator<T> {

  private Validator<T> next;

  @Override
  public Validator<T> setNext(Validator<T> next) {
    this.next = next;
    return next;
  }

  protected boolean validateNext(T item) {
    if (next == null) {
      return true;
    }
    return next.validate(item);
  }

}

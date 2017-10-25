package by.epam.action.result;


/**
 * Created by Oleg Savik on 08.10.2017.
 */
public class Result {
    private String message;
    private String actionName;
    private Object entity;

    protected Result(String message, String actionName, Object entity) {
        this.message = message;
        this.actionName = actionName;
        this.entity = entity;
    }

    public Result(String message, String actionName) {
        this.message = message;
        this.actionName = actionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (actionName != null ? !actionName.equals(result.actionName) : result.actionName != null) return false;
        return entity != null ? entity.equals(result.entity) : result.entity == null;
    }

    @Override
    public int hashCode() {
        int result = actionName != null ? actionName.hashCode() : 0;
        result = 31 * result + (entity != null ? entity.hashCode() : 0);
        return result;
    }

    public String getResultMessage() {
        String.format("Result for action '%s': %s", actionName, message);
        return String.format("Result for action '%s': %s", actionName, message);
    }

    public Object getResultValue() {
        return entity;
    }

    @Override
    public String toString() {
        return getResultMessage();
    }

}


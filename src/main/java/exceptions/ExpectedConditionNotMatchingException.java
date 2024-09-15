package exceptions;

/**
 * @author Nagarjun Chittyala
 */
public class ExpectedConditionNotMatchingException extends RuntimeException {

    public ExpectedConditionNotMatchingException() {
        System.err.println("Expected Condition is not met");
    }

    public ExpectedConditionNotMatchingException(String message) {
        System.err.println(message);
    }

    public ExpectedConditionNotMatchingException(String expected, String actual) {
        System.err.printf("Expected value (%s) is not equals to actual value (%s)%n", expected, actual);
    }
}

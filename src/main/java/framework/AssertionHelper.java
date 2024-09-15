package framework;

import exceptions.ExpectedConditionNotMatchingException;

/**
 * @author Nagarjun Chittyala
 * helper class for assertion functionality
 */
public class AssertionHelper {

    /**
     * Method to check whether two values are equal else throw exception
     * @param expected Expected Value
     * @param actual Actual Value
     */
    public void assertEquals(String expected, String actual){
        if(!expected.equals(actual)){
            throw new ExpectedConditionNotMatchingException(expected, actual);
        }
    }

    /**
     * Method to check whether given condition is true else throw exception
     * @param condition Boolean condition
     */
    public void assertTrue(boolean condition){
        if(!condition)
            throw new ExpectedConditionNotMatchingException();
    }

    /**
     * Method to check whether given condition is true else throw exception
     * @param condition Boolean condition
     * @param message Assertion message
     */
    public void assertTrue(boolean condition, String message){
        if(!condition)
            throw new ExpectedConditionNotMatchingException(message);
    }

    /**
     * Method to check whether given condition is false else throw exception
     * @param condition Boolean condition
     */
    public void assertFalse(boolean condition){
        if(condition)
            throw new ExpectedConditionNotMatchingException();
    }

    /**
     * Method to check whether given condition is false else throw exception
     * @param condition Boolean condition
     * @param message Assertion message
     */
    public void assertFalse(boolean condition, String message){
        if(condition)
            throw new ExpectedConditionNotMatchingException(message);
    }
}

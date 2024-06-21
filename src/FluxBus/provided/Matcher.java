package FluxBus.provided;

/**
 * a matcher interface.
 * <p>
 * implementing classes match objects to some pattern.
 *
 * @param <T> the type of the object to match
 * @author TeM
 * @ProgrammingProblem.Hint provided
 */
public interface Matcher<T> {

    /**
     * checks whether some object matches the pattern of this matcher.
     *
     * @param t the object to match
     * @return true if t matches, false otherwise
     */
    boolean match(T t);
}

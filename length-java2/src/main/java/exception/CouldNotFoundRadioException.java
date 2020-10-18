package exception;

import unit.Unit;

/**
 * @author sunjing
 */
public final class CouldNotFoundRadioException extends RuntimeException{

    private static final String MESSAGE = "%s to %s radio, colud not found!";

    public CouldNotFoundRadioException(Unit source, Unit target) {
        super(String.format(MESSAGE, source, target));
    }

}

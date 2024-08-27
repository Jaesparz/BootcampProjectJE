package Model;

public class InputValidator {
    public InputValidator() {
    }

    public static void validateWordInput(String input) throws NotAWordException {
        if (isNumeric(input)) {
            throw new NotAWordException("Is not Allowed to enter numbers. Please, enter a Word.");
        }
    }

    public static void validateNumberInput(String input) throws NotANumberException {
        if (!isNumeric(input)) {
            throw new NotANumberException("Is not Allowed to enter Words. Please, enter a number.");
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException var2) {
            return false;
        }
    }
}

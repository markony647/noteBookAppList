import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {

    public static boolean isCharactersOnly(String name) {

        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void shouldReturnTrueForAllCharacters() {
        assertEquals(isCharactersOnly("Simon"), true);
    }

    @Test
    public void shouldReturnFalseForNonNumericString(){
        assertEquals(isCharactersOnly("1245"), false);
    }

    @Test
    public void shouldReturnFalseForCharactersAndNonCharacters(){
        assertEquals(isCharactersOnly("Simon44"), false);
    }

    public static boolean isNumeric(String age) {
        try {
            Converter.convertFromStringToInt(age);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Test
    public void shouldReturnTrueForNumericChars() {
        assertEquals(isNumeric("123456789"), true);
    }

    @Test
    public void shouldReturnFalseForNonNumeric() {
        assertEquals(isNumeric("fifteen"), false);
    }

    @Test
    public void shouldReturnFalseForNumericAndNonNumeric(){
        assertEquals(isNumeric("12three,4"), false);
    }

    public static boolean isCorrectAgeRange(String ageValue){
        return (Converter.convertFromStringToInt(ageValue) > 4 && Converter.convertFromStringToInt(ageValue) < 100);
    }

    @Test
    public void shouldReturnTrueForCorrectAgeRange() {
        String age = "28";
        assertEquals(isCorrectAgeRange(age), true);
    }

    @Test
    public void shouldReturnTrueForLowerBoundary() {
        String lowerBoundaryAge = "5";
        assertEquals(isCorrectAgeRange(lowerBoundaryAge), true);
    }

    @Test
    public void shouldReturnTrueForUpperBoundary() {
        String upperBoundaryAge = "99";
        assertEquals(isCorrectAgeRange(upperBoundaryAge), true);
    }

    @Test
    public void shouldReturnFalseForIncorrectBoundary() {
        String incorrectBoundaryAge = "100";
        assertEquals(isCorrectAgeRange(incorrectBoundaryAge), false);
    }

    public static boolean isValidPerson(String name, String age) {
        return ((isCharactersOnly(name) && isNumeric(age)) && (isCorrectAgeRange(age)));
    }

    @Test
    public void shouldReturnTrueForNameAndAge() {
        boolean validPerson = isValidPerson("Sam", "44");
        assertEquals(validPerson, true);
    }

    @Test
    public void shouldReturnFalseForIncorrectName() {
        boolean inValidPerson = isValidPerson("Sam25", "44");
        assertEquals(inValidPerson, false);
    }

    @Test
    public void shouldReturnFalseForIncorrectAgeRange() {
        boolean inValidPerson = isValidPerson("Sam", "4454");
        assertEquals(inValidPerson, false);
    }

    @Test
    public void shouldReturnFalseForBothIncorrectParameters() {
        boolean inValidPerson = isValidPerson("Sam7832@#$", "fifty five");
        assertEquals(inValidPerson, false);
    }

    public static boolean isValidEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\." +
                "[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    @Test
    public void shouldReturnTrue() {
        boolean email = isValidEmail("example@gmail.com");
        assertEquals(email, true);
    }

    @Test
    public void shouldReturnFalseWithoutAtSignInEmail() {
        boolean email = isValidEmail("example.gmail.com");
        assertEquals(email, false);
    }

    @Test
    public void shouldReturnFalseWithoutDot() {
        boolean email = isValidEmail("example@gmailcom");
        assertEquals(email, false);
    }

    @Test
    public void shouldReturnFalseNotEmailFormat() {
        boolean email = isValidEmail("examplegmailcom");
        assertEquals(email, false);
    }
}

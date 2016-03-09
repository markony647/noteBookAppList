import java.util.regex.*;

public class Validator {

    public static boolean isCharactersOnly(String name) {

        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNumeric(String age) {
        try {
            Converter.convertFromStringToInt(age);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isCorrectAgeRange(String ageValue){
        return (Converter.convertFromStringToInt(ageValue) > 4 && Converter.convertFromStringToInt(ageValue) < 100);
    }


    public static boolean isValidPerson(String name, String age, String email) {
        return ((isCharactersOnly(name) && isNumeric(age)) && (isCorrectAgeRange(age)) && (isValidEmail(email)));
    }

    public static boolean isValidEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\." +
                            "[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

}
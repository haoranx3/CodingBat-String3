public class String3 {

    /**Given a string, count the number of words ending in 'y' or 'z'
     * so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive).
     * We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it.
     * (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * @param str not null
     * @return number of words ending in 'y' or 'z'
     */
    public int countYZ(String str) {
        int count = 0;
        for(int n = 0; n < str.length(); n++) {
            if (n <= str.length() - 2 && (str.toLowerCase().charAt(n) == 'y'
                    || str.toLowerCase().charAt(n) == 'z') && !Character.isLetter(str.charAt(n+1))) {
                count++;
            }
            else if( n == str.length() - 1 && (str.toLowerCase().charAt(n) == 'y'
                    || str.toLowerCase().charAt(n) == 'z')) {
                count++;
            }
        }
        return count;
    }

    /** Given two strings, base and remove,
     * return a version of the base string where all instances
     * of the remove string have been removed (not case sensitive).
     * You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * @param base not null
     * @param remove not null
     * @return the base string where all instances
     * of the remove string have been removed
     */
    public String withoutString(String base, String remove) {
        String str = "";
        for (int n = 0; n < base.length(); n++) {
            if (n > base.length() - remove.length()) {
                str += base.substring(n, base.length());
                break;
            }
            else{
                if (base.toLowerCase().substring(n, n+remove.length()).equals(remove.toLowerCase())) {
                    n += remove.length() -1;
                }
                else {
                    str += base.charAt(n);
                }
            }
        }
        return str;
    }

    /**Given a string, return true if the number of appearances of
     * "is" anywhere in the string is equal to the number of
     * appearances of "not" anywhere in the string (case sensitive).
     * @param str not null
     * @return return true if the number of appearances of
     * "is" anywhere in the string is equal to the number of
     * appearances of "not" anywhere in the string
     */
    public boolean equalIsNot(String str) {
        int countIs = 0;
        int countNot = 0;
        for (int n = 0; n < str.length(); n++) {
            if (n + 2 > str.length()) {
                break;
            }
            else {
                if (str.substring(n, n+2).equals("is")) {
                    countIs++;
                }
            }
        }
        for (int n = 0; n < str.length(); n++) {
            if (n + 3 > str.length()) {
                break;
            }
            else {
                if(str.substring(n, n+3).equals("not")) {
                    countNot++;
                }
            }
        }
        return countIs == countNot;
    }

    /**We'll say that a lowercase 'g' in a string is "happy"
     * if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * @param str not null
     * @return true if all the g's in the given string are happy.
     */
    public boolean gHappy(String str) {
        if (str.equals("g")) {
            return false;
        }
        for (int n = 0; n < str.length(); n++) {
            if (str.charAt(n) == 'g') {
                if (n > 0 && n < str.length()-1) {
                    if (str.charAt(n+1) != 'g' && str.charAt(n-1) != 'g') {
                        return false;
                    }
                }
                else if (n == 0) {
                    if (str.charAt(n+1) != 'g') {
                        return false;
                    }
                }
                else if(n == str.length() -1){
                    if (str.charAt(n-1) != 'g') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * @param str not null
     * @return the number of triples in the given string.
     */
    public int countTriple(String str) {
        int count = 0;
        for (int n = 0; n < str.length(); n++) {
            if (n + 3 > str.length()) {
                break;
            }
            else {
                if (str.charAt(n) == str.charAt(n+1) && str.charAt(n+1) == str.charAt(n+2)) {
                    count++;
                }
            }
        }
        return count;
    }

    /** Given a string, return the sum of the digits 0-9 that appear in the string,
     * ignoring all other characters. Return 0 if there are no digits in the string.
     * (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
     * Integer.parseInt(string) converts a string to an int.)
     * @param str not null
     * @return the sum of the digits 0-9 that appear in the string
     */
    public int sumDigits(String str) {
        int sum = 0;
        for (int n = 0; n < str.length(); n++) {
            if (Character.isDigit(str.charAt(n))) {
                sum += Integer.parseInt(str.substring(n,n+1));
            }
        }
        return sum;
    }

    /** Given a string, return the longest substring that appears at both the beginning
     * and end of the string without overlapping.
     * For example, sameEnds("abXab") is "ab".
     * @param str not null
     * @return the longest substring that appears at both the beginning
     * and end of the string without overlapping.
     */
    public String sameEnds(String str) {
        for (int n = str.length()/2; n >= 0; n--) {
            if (str.endsWith(str.substring(0, n))) {
                return str.substring(0, n);
            }
        }
        return "";
    }

    /**Given a string, look for a mirror image (backwards) string at both the beginning
     * and end of the given string. In other words, zero or more characters at
     * the very begining of the given string, and at the very end of the
     * string in reverse order (possibly overlapping). For example,
     * the string "abXYZba" has the mirror end "ab".
     * @param str not null
     * @return a mirror image (backwards) string at both the beginning
     * and end of the given string
     */
    public String mirrorEnds(String str) {
        for (int n = 0; n < str.length(); n++) {
            if (str.charAt(n) != str.charAt(str.length()-1-n)) {
                return str.substring(0,n);
            }
        }
        return str;
    }

    /**Given a string, return the length of the largest "block"
     * in the string. A block is a run of adjacent chars that are the same.
     * @param str not null
     * @return the length of the largest "block"
     */
    public int maxBlock(String str) {
        int count1 = 1;
        int count2 = 0;
        for (int n = 1; n < str.length(); n++) {
            if (str.charAt(n) == str.charAt(n-1)) {
                count1++;
                count2 = Math.max(count2, count1);
            }
            else {
                count2 = Math.max(count2, count1);
                count1 = 1;
            }
        }
        return count2;
    }

    /**Given a string, return the sum of the numbers appearing in the string,
     * ignoring all other characters. A number is a series of 1 or more digit
     * chars in a row. (Note: Character.isDigit(char) tests if a char is
     * one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
     * @param str not null
     * @return the sum of the numbers appearing in the string
     */
    public int sumNumbers(String str) {
        String string = "";
        int sum = 0;
        for(int n = 0; n < str.length(); n++) {
            if (Character.isDigit(str.charAt(n))) {
                if (n < str.length() - 1 && Character.isDigit(str.charAt(n+1))) {
                    string += str.charAt(n);
                }
                else {
                    string += str.charAt(n);
                    sum += Integer.parseInt(string);
                    string = "";
                }
            }
        }
        return sum;
    }


}

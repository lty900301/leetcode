/**
 * Valid Number
 * 
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 * 
 * @author Josh Luo
 *
 */

public class ValidNumber {
	
	// The following method is what I wrote by myself.
	// Awkward though. I hate to consider all these edge cases
	// But it is a great practices.
	public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        s = s.trim(); // remove the spaces in the beginning and end
        
        if(s.length() == 0) return false;
        
        if(s.charAt(0) == '+' || s.charAt(0) == '-') // remove the '+' and '-', which are valid
            s = s.substring(1);
        
        /* verify if the first occured number is valid */
        String current = s;
        s = removeValid(s);
        if(s.length() > 0 && s.charAt(0) == '.'){
            s = s.substring(1);
            s = removeValid(s);
            // This means the only thing found here is '.'
            if(current.length() - s.length() == 1) return false;
        }
        // This means there is no valid number found
        if(current.length() - s.length() == 0) return false; 
        
        if(s.length() > 0 && s.charAt(0) == 'e'){
            s = s.substring(1);
            // remove the '+' and '-', which are valid
            if(s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-')) s = s.substring(1);
            /* verify if the number occured after e is valid */
            current = s;
            s = removeValid(s);
            if(current.length() - s.length() == 0) return false;
        }
        
        // All the chars are validated.
        if(s.length() == 0) return true;
        
        return false;
    }
    
    private String removeValid(String s){
        while(s.length() > 0){
            if(s.charAt(0) >= '0' && s.charAt(0) <= '9'){
                s = s.substring(1);
            }
            else break;
        }
        return s;
    }
    
    // This method is using regex
    // To learn more about regex, please visit: 
    // https://github.com/lty900301/leetcode/blob/master/helper_docs/davechild_regular-expressions.pdf
    public boolean isNumber2(String s){
        return s.matches("^\\s*[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?\\s*$");
    }
    
    // There is a method using state machine or finite automata (awesome!)
    // To learn more about it, please visit:
    // http://discuss.leetcode.com/questions/241/valid-number?page=1&focusedAnswerId=768#768
}

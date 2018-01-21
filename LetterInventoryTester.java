/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Number of slip days I am using:
 */

public class LetterInventoryTester {
    public static void main(String[] args) {
        LetterInventory lets1 = new LetterInventory("");
        Object expected = 0;
        Object actual = lets1.size();
        showTestResults(expected, actual, 1, " size on empty LetterInventory");
        
        expected = "";
        actual = lets1.toString();
        showTestResults(expected, actual, 2, " toString on empty LetterInventory");
        
        expected = 0;
        actual = lets1.get('A');
        showTestResults(expected, actual, 3, " get on empty LetterInventory");   
        
        expected = 0;
        actual = lets1.get('z');
        showTestResults(expected, actual, 4, " get on empty LetterInventory");  
        
        expected = true;
        actual = lets1.isEmpty();
        showTestResults(expected, actual, 5, " isEmpty on empty LetterInventory");
        
        lets1.set('M', 5);
        expected = 5;
        actual = lets1.size();
        showTestResults(expected, actual, 6, " set and get methods");
        
        lets1.set('m', 5);
        expected = 5;
        actual = lets1.size();
        showTestResults(expected, actual, 7, " get method");
        
        expected = "mmmmm";
        actual = lets1.toString();
        showTestResults(expected, actual, 8, " LetterInventory toString");  
       
        
        LetterInventory lets2 = new LetterInventory("\"Stanford University\"!! Jr<>(())G");
        expected = "adefgiijnnorrrssttuvy";
        actual = lets2.toString();
        showTestResults(expected, actual, 9, " LetterInventory constructor and toString"); 
        
        expected = 21;
        actual = lets2.size();
        showTestResults(expected, actual, 10, " LetterInventory size");       
        
        expected = false;
        actual = lets2.isEmpty();
        showTestResults(expected, actual, 11, " LetterInventory isEmpty");  
        
        expected = null;
        actual = lets2.subtract(lets1);
        showTestResults(expected, actual, 12, "LetterInventory subtract"); 
        
        lets1 = new LetterInventory("stand ---- ton");
        expected = "efgiijrrrsuvy";
        actual = lets2.subtract(lets1).toString();
        showTestResults(expected, actual, 13, "LetterInventory subtract"); 
        
        expected = 13;
        actual = lets2.subtract(lets1).size();
        showTestResults(expected, actual, 14, "LetterInventory size after subtract"); 
        
        expected = false;
        actual = lets2.isEmpty();
        showTestResults(expected, actual, 15, "LetterInventory isEmpty after subtract"); 
        
        expected = null;
        actual = lets1.subtract(lets2);
        showTestResults(expected, actual, 16, "LetterInventory subtract"); 
        
        expected = false;
        actual = lets1.equals(lets2);
        showTestResults(expected, actual, 17, "LetterInventory equals");  
        
        lets1 = new LetterInventory("Ol33vIA33");
        expected = "aadefgiiijlnnoorrrssttuvvy";
        LetterInventory lets3 = lets1.add(lets2);
        actual = lets3.toString();
        showTestResults(expected, actual, 18, "LetterInventory add");
     
        expected = 26;
        actual = lets3.size();
        showTestResults(expected, actual, 19, "LetterInventory size after add");         
        
        expected = false;
        actual = lets3.isEmpty();
        showTestResults(expected, actual, 20, "LetterInventory isEmpty after add");        
        
        lets3 = lets1.add(lets2);
        LetterInventory lets4 = lets2.add(lets1);  
        showTestResults(lets3, lets4, 21, "LetterInventory add and equals");
        
        expected = false;
        StringBuilder foo = new StringBuilder();
        actual = lets3.equals(foo);
        showTestResults(expected, actual, 22, "LetterInventory equals");       
    }
    
    public static boolean showTestResults(Object expected, Object actual, int testNum, String featureTested) {
        System.out.println("Test Number " + testNum + " testing " + featureTested);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + actual);
        boolean passed = (actual == null && expected == null) || actual.equals(expected);
        if(passed)
            System.out.println("Passed test " + testNum);
        else
            System.out.println("!!! FAILED TEST !!! " + testNum);
        System.out.println();
        return passed;
    }
}

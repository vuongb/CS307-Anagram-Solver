/*  Student information for assignment:
 *
 *  On my honor, Bryan Vuong, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: BKV85
 *  email address: vuong.bryan@gmail.com
 *  Grader name: Oliver Jensen
 *  Number of slip days I am using:
 */

public class LetterInventoryTester {
	
	public static int numTests = 0;
	public static int numPassedTests = 0;

	
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
        
        lets1 = new LetterInventory("!@*$&%^@)!)@($(#&&!&!((");
        runTest(0, lets1.size());
        runTest("", lets1.toString());
        for(char c = 'a'; c <= 'z'; c++) {
        	runTest(0, lets1.get(c));
        }
        for(char c = 'A'; c <= 'Z'; c++) {
        	runTest(0, lets1.get(c));
        }
        runTest(lets2, lets1.add(lets2));
        runTest(null, lets1.subtract(lets2));
        runTest(true, lets1.isEmpty());
        for(char c = 'a'; c <= 'z'; c++)
        	lets1.set(c, 1);
        for(char c = 'a'; c <= 'z'; c++)
        	runTest(1, lets1.get(c));
        for(char c = 'A'; c <= 'Z'; c++)
        	runTest(1, lets1.get(c));
        runTest(26, lets1.size());
        runTest(false, lets1.isEmpty());
        runTest("abcdefghijklmnopqrstuvwxyz", lets1.toString());
        for(char c = 'A'; c <= 'Z'; c++)
        	lets1.set(c, 2);
        for(char c = 'a'; c <= 'z'; c++)
        	runTest(2, lets1.get(c));
        for(char c = 'A'; c <= 'Z'; c++)
        	runTest(2, lets1.get(c));
        runTest(52, lets1.size());
        runTest(false, lets1.isEmpty());
        runTest("aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz", lets1.toString());
        runTest(true, lets1.equals(lets1));
        runTest(lets1, lets1);

        lets1 = new LetterInventory("joe");
        lets2 = new LetterInventory("bob");
        lets4 = new LetterInventory("bobjoe");
        runTest(false, lets1.equals(lets2));
        runTest(false, lets2.equals(lets1));
        runTest(false, lets1.equals(lets4));
        runTest(false, lets4.equals(lets1));
        runTest(false, lets2.equals(lets4));
        runTest(false, lets4.equals(lets2));
        runTest(lets4, lets1.add(lets2));
        runTest(lets1, lets4.subtract(lets2));
        runTest(lets2, lets4.subtract(lets1)); // test 200


        System.out.println();
        System.out.println("Passed " + numPassedTests + "/" + numTests);
        
    }
    
 // Modified a bit from the original method Mike gave us to keep track of # tests & # that pass
    public static boolean showTestResults(Object expected, Object actual, int testNum, String featureTested) {
    	numTests++;
    	System.out.println("Test Number " + testNum + " testing " + featureTested);
    	System.out.println("Expected result: " + expected);
    	System.out.println("Actual result: " + actual);
    	boolean passed = (actual == null && expected == null) || actual.equals(expected);
    	if(passed) {
    		numPassedTests++;
    		System.out.println("Passed test " + testNum);
    	} else
    		System.out.println("!!! FAILED TEST !!! " + testNum);
    	System.out.println();
    	return passed;
    }
    private static void runTest(int expected, int actual) {
    	numTests++;
    	if( expected == actual ) {
    		numPassedTests++;
    		System.out.print("Test " + numTests + " expected value: " + expected + ", actual value: " + actual);
    	} else {
    		System.out.print("FAILURE -- Test " + numTests + " expected value: " + expected + ", actual value: " + actual);
    	}
    	System.out.println();
    }

    private static void runTest(String expected, String actual) {
    	numTests++;
    	if( expected.equals(actual) ) {
    		numPassedTests++;
    		System.out.print("Test " + numTests + " expected value: " + expected + ", actual value: " + actual);
    	} else {
    		System.out.print("FAILURE -- Test " + numTests + " expected value: " + expected + ", actual value: " + actual);
    	}
    	System.out.println();
    }

    private static void runTest(boolean expected, boolean actual) {
    	numTests++;
    	if( expected == actual ) {
    		numPassedTests++;
    		System.out.print("Test " + numTests + " expected value: " + expected + ", actual value: " + actual);
    	} else {
    		System.out.print("FAILURE -- Test " + numTests + " expected value: " + expected + ", actual value: " + actual);
    	}
    	System.out.println();
    }

    private static void runTest(Object expected, Object actual) {
    	numTests++;
    	if( (expected == null && actual == null) || expected.equals(actual) ) {
    		numPassedTests++;
    		System.out.print("Test " + numTests + " expected value: " + expected + ", actual value: " + actual);
    	} else {
    		System.out.print("FAILURE -- Test " + numTests + " expected value: " + expected + ", actual value: " + actual);
    	}
    	System.out.println();
    }
}

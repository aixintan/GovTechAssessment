package Calculator.MavenEclipseProject;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit test for simple Split Calculator.
 */
public class CalculatorTest 
{   
    @Test
    public void testCaseOne() {
    	System.out.println("Test Case Number 1: ");
    	ArrayList<User> userList = new ArrayList<>();
    	userList.add(new User("Alice", 40.105));
    	userList.add(new User("Bob", 40.105));
    	userList.add(new User("Charlie", 10));

    	Calculator.sortUser(userList);
    	System.out.println();
    }
    
    @Test
    public void testCaseTwo() {
    	System.out.println("Test Case Number 2: ");
    	ArrayList<User> userList = new ArrayList<>();
    	userList.add(new User("Alice", 40));
    	userList.add(new User("Bob", 40));
    	userList.add(new User("Charlie", 10));

    	Calculator.sortUser(userList);
    	System.out.println();
    }
    
    @Test
    public void testCaseThree() {
    	System.out.println("Test Case Number 3: ");
    	ArrayList<User> userList = new ArrayList<>();
    	userList.add(new User("Alice", 10));
    	userList.add(new User("Bob", 20));
    	userList.add(new User("Charlie", 0));
    	userList.add(new User("Don", 10));

    	Calculator.sortUser(userList);
    	System.out.println();
    }
    
    @Test
    public void testCaseFour() {
    	System.out.println("Test Case Number 4: ");
    	ArrayList<User> userList = new ArrayList<>();
    	userList.add(new User("Alice", 40));
    	userList.add(new User("Bob", 40));
    	userList.add(new User("Charlie", 10));
    	userList.add(new User("Don", 10));

    	Calculator.sortUser(userList);
    	System.out.println();
    }
    
    @Test
    public void testCaseFive() {
    	System.out.println("Test Case Number 5: ");
    	ArrayList<User> userList = new ArrayList<>();
    	userList.add(new User("Alice", 200));
    	userList.add(new User("Bob", 80));
    	userList.add(new User("Charlie", 50));
    	userList.add(new User("Don", 20));

    	Calculator.sortUser(userList);
    	System.out.println();
    }
    
    @Test
    public void testCaseSix() {
    	System.out.println("Test Case Number 6: ");
    	ArrayList<User> userList = new ArrayList<>();
    	userList.add(new User("Alice", 160));
    	userList.add(new User("Bob", 120));
    	userList.add(new User("Charlie", 50));
    	userList.add(new User("Don", 20));

    	Calculator.sortUser(userList);
    	System.out.println();
    }
    
}
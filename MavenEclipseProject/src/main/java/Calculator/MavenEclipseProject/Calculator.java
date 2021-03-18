package Calculator.MavenEclipseProject;

import java.util.*;
import java.text.DecimalFormat;

public class Calculator {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<User> userList = new ArrayList<User>();

		try {
			int numOfUser = enterNumberOfUser();
			enterAmountSpent(numOfUser, userList);

			sortUser(userList);

		} catch (InputMismatchException e) {
			System.out.println("Invalid input, please try again.");
		}
	}

	public static void sortUser(ArrayList<User> userList) {
		User tempUser;
		ArrayList<User> sortedUserList = new ArrayList<User>();
		double amountUserHasPaid, totalAmountSpent = 0, amountUserHasToPay = 0;

		for (int i = 0; i < userList.size(); i++) {
			totalAmountSpent += userList.get(i).getAmount();
		}

		// Get amount each user must pay
		double mean = totalAmountSpent / userList.size();

		for (int i = 0; i < userList.size(); i++) {
			amountUserHasPaid = userList.get(i).getAmount();
			amountUserHasToPay = mean - amountUserHasPaid;
			userList.get(i).setAmount(amountUserHasToPay);
		}

		while (userList.size() != 0) {
			tempUser = userList.get(0);
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getAmount() <= tempUser.getAmount()) {
					tempUser = userList.get(i);
				}
			}
			sortedUserList.add(tempUser);
			userList.remove(tempUser);
		}
		splitPayments(sortedUserList);
	}

	public static int enterNumberOfUser() {
		int numOfUser = 0;

		while (true) {
			try {
				System.out.println("Enter the number of user:");
				numOfUser = scanner.nextInt();
				scanner.nextLine();

				if (numOfUser < 0) {
					System.out.println("Please enter a positive number!");
				} else if (numOfUser < 2) {
					System.out.println("Please enter a minimum number of 2!");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("Please enter a valid number!");
				scanner.nextLine();
			}
		}

		return numOfUser;
	}

	public static void enterAmountSpent(int numOfUser, ArrayList<User> userList) {
		String username;
		double amountUserHasPaid;

		while (numOfUser != 0) {
			numOfUser--;
			System.out.println("Enter the username:");
			username = scanner.nextLine();
			while (true) {
				try {
					System.out.println("Enter the amount:");
					amountUserHasPaid = scanner.nextDouble();
					scanner.nextLine();

					if (amountUserHasPaid < 0) {
						System.out.println("Please enter a positive amount!");
					} else {
						break;
					}

				} catch (Exception e) {
					System.out.println("Please enter a valid amount!");
					scanner.nextLine();
				}
			}

			User addUser = new User(username, amountUserHasPaid);
			userList.add(addUser);
		}
	}

	public static String checkDecimalPlace(double value) {
		DecimalFormat twoDcPlace = new DecimalFormat("#0.00");

		String output = twoDcPlace.format(value);
		return output;
	}

	public static void splitPayments(ArrayList<User> userList) {
		int numOfTrans = 0;

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getAmount() > 0) {
				for (int k = 0; k < userList.size(); k++) {
					if (userList.get(k).getAmount() < 0 && userList.get(i).getAmount() > 0) {
						numOfTrans++;
						double amountStillOwe = 0;
						double amountPaid = 0;
						if (userList.get(i).getAmount() <= Math.abs(userList.get(k).getAmount())) {
							// Owe Money
							amountPaid = userList.get(i).getAmount();
							userList.get(i).setAmount(0);
							userList.get(k).setAmount(userList.get(k).getAmount() + amountPaid);
						} else {
							// Receive Money
							amountStillOwe = userList.get(i).getAmount() - Math.abs(userList.get(k).getAmount());
							amountPaid = userList.get(i).getAmount() - amountStillOwe;
							userList.get(i).setAmount(amountStillOwe);
							userList.get(k).setAmount(0);
						}
						System.out.println(userList.get(i).getUsername() + " pays " + userList.get(k).getUsername() + " $" +  checkDecimalPlace(Math.abs(amountPaid)) + ".");
					}
				}
			}
		}

		/*
		for (int i = userList.size() - 1; i > -1; i--) {
			if (userList.get(i).getAmount() > 0) {
				for (int k = 0; k < userList.size(); k++) {
					if (userList.get(k).getAmount() < 0 && userList.get(i).getAmount() > 0) {
						numOfTrans++;
						double amountStillOwe = 0;
						double amountPaid = 0;
						// Owe Money
						if (userList.get(i).getAmount() <= Math.abs(userList.get(k).getAmount())) {
							amountPaid = userList.get(i).getAmount();
							userList.get(i).setAmount(0);
							userList.get(k).setAmount(userList.get(k).getAmount() + amountPaid);
						} else {
							// Receive Money
							amountStillOwe = userList.get(i).getAmount() - Math.abs(userList.get(k).getAmount());
							amountPaid = userList.get(i).getAmount() - amountStillOwe;
							userList.get(i).setAmount(amountStillOwe);
							userList.get(k).setAmount(0);
						}
						System.out.println(userList.get(i).getUsername() + " pays " + userList.get(k).getUsername() + " $" +  checkDecimalPlace(Math.abs(amountPaid)) + ".");
					}
				}
			}
		}
		*/
		
		System.out.println("Number of transactions: " + numOfTrans);
	}
}

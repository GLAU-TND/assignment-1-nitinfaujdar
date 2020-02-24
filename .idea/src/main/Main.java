package main;

import contact.Person;
import contactList.ContactList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName;
        String lastName;
        String email;
        ContactList<Person> contactList = new ContactList<>();
        ArrayList<String> names = new ArrayList<>();
        char option;
        while (true) {
            System.out.println("Welcome to Abhishek's Contact List App\n" +
                    "Press 1 to add a new contact\n" +
                    "Press 2 to view all contacts\n" +
                    "Press 3 to search for a contact\n" +
                    "Press 4 to delete a contact\n" +
                    "Press 5 to exit program");
            int choice = scanner.nextInt();
            if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
                switch (choice) {
                    case 1:
                        System.out.println("You have chosen to add a new contact: \n" +
                                "Please enter the name of the Person\n");
                        System.out.print("First Name: ");
                        firstName = scanner.next();
                        System.out.print("Last Name: ");
                        lastName = scanner.next();
                        names.add(firstName + " " + lastName);
                        System.out.print("Phone Number: ");
                        ArrayList<String> phoneNumber = new ArrayList<>();
                        String mobileNumber = scanner.next();
                        phoneNumber.add(mobileNumber);
                        System.out.print("Would you like to add another contact number? (y/n): ");
                        option = scanner.next().charAt(0);
                        while (true) {
                            if (option == 'y' || option == 'Y') {
                                System.out.print("Phone Number: ");
                                mobileNumber = scanner.next();
                                phoneNumber.add(mobileNumber);
                                System.out.print("Would you like to add another contact number? (y/n): ");
                                option = scanner.next().charAt(0);
                            } else if (option == 'n' || option == 'N') {
                                break;
                            }
                        }
                        System.out.print("Email: ");
                        email = scanner.next();
                        Person person = new Person(firstName, lastName, email, phoneNumber);
                        contactList.add(person);
                        break;

                    case 2:
                        if (contactList.size == 0) {
                            System.out.println("NO RESULT FOUND!");
                            break;
                        } else {
                            contactList.view();
                            break;
                        }

                    case 3:
                        System.out.print("You could search for a contact from their first names: ");
                        firstName = scanner.next();
                        int count = 0;
                        for (int i = 0; i < names.size(); i++) {
                            if (names.get(i).contains(firstName)) {
                                count++;
                            }
                        }
                        System.out.println(count + " match Found!");
                        for (int i = 0; i < names.size(); i++) {
                            if (names.get(i).contains(firstName)) {
                                System.out.println(contactList.view(i));
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Here are all your contacts: ");
                        for (int i = 0; i < names.size(); i++) {
                            System.out.println(i + 1 + ". " + names.get(i));
                        }
                        int num = scanner.nextInt();
                        contactList.delete(num - 1);
                        System.out.println(contactList.size);
                        System.out.println(names.get(num - 1) + "'s contact deleted from list!");
                        names.remove(num - 1);
                        break;
                }
            } else if (choice == 5) {
                break;
            }
        }

    }
}
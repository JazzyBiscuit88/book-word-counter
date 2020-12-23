package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    // ignore CASE!
    // put results in a collection to print at the same time
    // txt file with books ready to call for a long printout of examples
    public static void main(String[] args) {

        printApplicationBanner();
        int numberOfBooks = getNumberOfBooksFromUser();

        for (int i = 0; i < numberOfBooks; i++) {
            System.out.print("Please enter a title >>> ");
            Scanner userInput = new Scanner(System.in);
            String title = userInput.nextLine();
            System.out.print("Please enter the author >>> ");
            String author = userInput.nextLine();
            System.out.print("Please enter the file path >>> ");
           try {
               File path = new File(userInput.nextLine());
               Book book = new Book(title, author, path);

               System.out.println(book.getTitle() + " by " + book.getAuthor() + " has " + book.getWords() + " words -> " +
                       book.getUniqueWords() + " of them are unique, a ratio of -> " + book.wordRatio() + "%");
           } catch (FileNotFoundException e) {
               System.err.println("File could not be found!");
           }


        }

        System.exit(1);
    }



    public static void printApplicationBanner() {
        System.out.println("***************");
        System.out.println("WORD COMPARATOR");
        System.out.println("***************");
        System.out.println();
    }

    public static int getNumberOfBooksFromUser() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("How many books do you want to compare? >>> ");

        return Integer.parseInt(userInput.nextLine());
    }
}

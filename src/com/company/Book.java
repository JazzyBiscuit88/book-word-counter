package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Book{
    private String title;
    private String author;
    private File filePath;

    public Book(String title, String author, File filePath) {
        this.title = title;
        this.author = author;
        this.filePath = filePath;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getWords() {
        try {
            Scanner fileScanner = new Scanner(getFilePath());
            int counter = 0;

            while (fileScanner.hasNext()) {
                fileScanner.next();
                counter++;
            }
            return counter;

        } catch (FileNotFoundException e) {
                System.err.println("File could not be found!");
        }

       return -1;
    }

    public File getFilePath() {
        return filePath;
    }

    public int getUniqueWords() throws FileNotFoundException {
        Set<String> totalWords = new HashSet<>();
        Scanner input = new Scanner(this.filePath);

        while (input.hasNext()) {
            totalWords.add(input.next());
        }

        return totalWords.size();
    }

    public int wordRatio() throws FileNotFoundException {
        double test = ((double)getUniqueWords() / (double) getWords()) * 100;
        return  (int) test;
    }




        // check for the existence of a file
//        File inputFile = new File(path);
//        if (!inputFile.exists()) {
//            System.out.println(path + " does not exist");
//            System.exit(1);
//        } else if (!inputFile.isFile()) {
//            System.out.println(path + " is not a file");
//            System.exit(1);
//        }








}

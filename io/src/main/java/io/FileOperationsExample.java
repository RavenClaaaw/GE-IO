package io;

import java.io.File;
import java.io.IOException;

public class FileOperationsExample {
    public static void main(String[] args) {
        FileOperationsExample fileOperation = new FileOperationsExample();
        fileOperation.watch(".");
    }

    public void checkFile(String filename){
        File file = new File(filename);

        if (file.exists()) {
            System.out.println("File Exists.");
        } else {
            System.out.println("No File Found.");
        }
    }

    public void deleteFile(String filename){
        File fileToDelete = new File(filename);

        if (fileToDelete.delete()) {
            System.out.println("File Deleted: " + filename);
        } else {
            System.out.println("Error: Failed To Delete.");
        }

        if (fileToDelete.exists()) {
            System.out.println("DELETION FAILURE");
        } else {
            System.out.println("DELETION SUCCESS");
        }
    }

    public void createDir(String dirname){
        File directory = new File(dirname);
        if (directory.mkdir()) {
            System.out.println("Directory Created.");
        } else {
            System.out.println("Error: FAILURE");
        }
    }

    public void createEmptyFile(String filename){
        File emptyFile = new File(filename);
        try {
            if (emptyFile.createNewFile()) {
                System.out.println("Empty File Created.");
            } else {
                System.out.println("Error: FAILURE");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the empty file.");
            e.printStackTrace();
        }
    }

    public void watch(String dirname){
        File directoryToScan = new File(dirname);
        File[] files = directoryToScan.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println("Directory: " + f.getName());
            } else {
                System.out.println("File: " + f.getName());
            }
            if (f.getName().endsWith(".txt")) {
                System.out.println("Text file: " + f.getName());
            }
        }
    }
}

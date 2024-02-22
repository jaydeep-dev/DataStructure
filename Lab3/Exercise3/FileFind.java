package Lab3.Exercise3;

import java.io.File;

public class FileFind {
    public static void main(String[] args) {
        // Example usage:
        String path = "E:";
        String filename = "FileFind.java";
        find(path, filename);
    }

    public static void find(String path, String filename) {
        File root = new File(path);
        if (!root.exists() || !root.isDirectory()) {
            System.out.println("Invalid path or path is not a directory: " + path);
            return;
        }
        search(root, filename);
    }

    private static void search(File directory, String filename) {
        var files = directory.listFiles();
        if (files != null) {
            for (var file : files) {
                if (file.isDirectory()) {
                    // Recursive call if the current file is a directory
                    search(file, filename);
                } else {
                    // Check if the file matches the given filename
                    if (file.getName().equals(filename)) {
                        // Print the absolute path of the file
                        System.out.println("Found at: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        File file = new File("E:\\Java learning\\Test exersice\\Excersizes\\src\\resources\\my_routes.txt");
        Scanner sc = null;
        Set<String> routes = new HashSet<String>();
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                routes.add(sc.nextLine().toLowerCase());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
//        ArrayList<String> al = new ArrayList<>(routes);
//        for (int i = 0; i < al.size(); i++) {
//            if (!al.get(i).contains("route add")) {
//                al.remove(i--);
//            }
//        }
        try (PrintWriter writer = new PrintWriter(file)) {
            for (String route : routes) {
                writer.println(route);
            }
        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }
        System.out.println(routes);
    }
}
package com.example.myfavoritedogs;

import com.google.gson.Gson;
import org.springframework.data.web.JsonPath;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(123);

    }

    public static Dog jsonDownloadedToClass(String jsonDownloaded) {
        Dog dog = new Gson().fromJson(jsonDownloaded, Dog.class); // zapisanie pól jsona do odpowiednich pól klasy Dog
        System.out.println(dog.toString()); // wyświetenie klasy Dog
        return dog;
    }

    public static String downloadJsonFromURL(String urlText) { //metoda zapisująca jsona do StringBuildera
        try {
            URL myUrl = new URL(urlText);
            StringBuilder jsonText = new StringBuilder();
            try (InputStream myInputStream = myUrl.openStream();
                 Scanner scanner = new Scanner(myInputStream)) {
                while (scanner.hasNextLine()) {
                    jsonText.append(scanner.nextLine());
                }

                while ((jsonText.toString().contains("mp4")) || (jsonText.toString().contains("webm"))) {
                    downloadJsonFromURL("https://random.dog/woof.json");
                }
                return jsonText.toString();
            }
        } catch (IOException e) {
            System.err.println("Can't load data from  " + urlText + " due to the exeption: " + e.getMessage());
            return " ";
        }
    }

}
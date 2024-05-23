package com.Ciscoslahs.Pokedex;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PokedexService {

    public List<String> findByName(String userInput){
        List<String> foundMons = new ArrayList<>();
        String filePath = "src/main/resources/Pokemon.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(userInput.toLowerCase())) {
                    foundMons.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Pokemon.txt file: " + e.getMessage());
            e.printStackTrace();
        }
        return foundMons;
    }

    public List<String> findByStats(int givenStat){
        List<String> foundStats = new ArrayList<>();
        String filePath = "src/main/resources/Pokemon.txt";
        String statPoints = Integer.toString(givenStat);
        Pattern statsOfMon = Pattern.compile("\\b" + statPoints + "\\b");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matchToStats = statsOfMon.matcher(line);
                if (matchToStats.find()) {
                    foundStats.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Pokemon.txt file: " + e.getMessage());
            e.printStackTrace();
        }
        return foundStats;
    }

    public String randomPokemon() {
        String filePath = "src/main/resources/Pokemon.txt";
        List<String> mons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                mons.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading Pokemon.txt file: " + e.getMessage());
            e.printStackTrace();
        }
        return mons.get((int) (Math.random() * mons.size()));
    }
}

package com.inventorymanagementsystem.hkunzler_software1_pa.utils;

public class formatting {
    public static String capitalizeWord(String word) {
        StringBuilder capitalizedWord = new StringBuilder();
        for (char wordCharacter : word.toCharArray()) {
            wordCharacter = word.indexOf(wordCharacter) == 0
                    ? Character.toTitleCase(wordCharacter)
                    : Character.toLowerCase(wordCharacter);
            capitalizedWord.append(wordCharacter);
        }
        return capitalizedWord.toString();
    }
}

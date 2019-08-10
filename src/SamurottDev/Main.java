package SamurottDev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException
    
    {
        System.out.println("Please input the string to OwO-ify:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String toOwo = reader.readLine();
        String OwOified = new String();
        for (var i = 0; i < toOwo.length(); i++){
            String character = toOwo.substring(i, i+1);
            if (character.contains("o")){
                character = "owo";
            }
            if (character.contains("O")){
                character = "OwO";
            }
            if (character.contains("u")){
                character = "uwu";
            }
            if (character.contains("U")){
                character = "UwU";
            }
            OwOified = OwOified + character;
        }
        System.out.println(OwOified);
    }
}

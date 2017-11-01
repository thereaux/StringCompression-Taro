/*
Program follows the Lab 1 guidelines for the three tasks
Created by Dan Taro
On my Honor: Dan Taro
 */

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;

public class StringCompression {

//Task #1
//Write a function in Java or JavaScript that removes all the vowels from a String.

    public String[] a;

    public static String disemvoweling(String inString){
        String[] parsedString = inString.split("");
        String product = "";

        for (int i = 0; i < parsedString.length; i++) {
            if(((parsedString[i].equals("a") && (i < parsedString.length-1 && i > 0) && !(parsedString[i-1].equals(" ") &&
                    parsedString[i+1].equals(" ")))|| parsedString[i].equals("e") || parsedString[i].equals("i")
                || parsedString[i].equals("o") || parsedString[i].equals("u"))){
                parsedString[i] = null;
            } else if ((i < parsedString.length-1 && i > 0) && (parsedString[i].equals("a") || parsedString[i].equals("I")) && (parsedString[i-1].equals(" ") &&
                     parsedString[i+1].equals(" "))
                    ){
                    parsedString[i] = "*";
            }
        }

        for (int i = 0; i < parsedString.length; i++) {
            if(parsedString[i] != null){
                product+= parsedString[i];
            }

        }
        return product;
    }


    //Task #2
    //compresses the string by indicating how many sequential occurrences of a letter there are in a row

    public static String simpleCompression(String inString){
        int counter = 0;
        String output = "";
        for(int i = 0; i < inString.length(); i++){
            if((i < inString.length()-1) && (inString.charAt(i) == inString.charAt(i+1))){
                counter++;
            }  else {
                output += inString.charAt(i)+""+(counter+1);
                counter = 0;
            }
        }
        return output;
    }

    //Task #3 Dictionary Compression
    /*
Given a string of text with repeating words or phrases:

Allows a user to enter a phrase to compress
adds that phrase to the dictionary under a numerical key
displays the text with the key replacing each instance of the phrase
displays the dictionary in a pleasing form
Calculates the compression rate as follows and displays it to the screen: (length of original text - length of compressed text + number of keys in Dict + length of strings Values in Dict) /length of original text
Bonus features:

allow the user to remove keys from the dictionary
allow the user to create a dictionary entry from text that contains a mix of plain text and dictionary keys (think escape characters)
     */

public static String dictionaryCompression(String fullText, String phrase){
    ArrayDictionary a = new ArrayDictionary();

    a.put(a.size(), phrase);

    a.toString();
    String compressedPhrase = "";
    int phraseLength = phrase.length();

    while (fullText.indexOf(phrase) >= 0){
        int index = fullText.indexOf(phrase);
        String start = fullText.substring(index, phraseLength);
        int key = a.size();
        String end = fullText.substring(index+ phraseLength);
        compressedPhrase += start +""+key +""+ end;
        fullText = start + key + end;
    }

    double compressionRate;
    double valueLength = 0;
    for (int i = 0; i < a.size(); i++) {
         valueLength += ((String)((ArrayList)a.values()).get(i)).length();
    }
    compressionRate = (fullText.length() - phraseLength + a.size()+ valueLength) / (1.0*fullText.length());
    System.out.println("Compression Rate: "+compressionRate);
    return compressedPhrase;
}

    //driver
    public static void main(String[] args) {

        //System.out.println("\"pasta is a food in some places\"--> "+disemvoweling("pasta is a food in some places"));
        //System.out.println("aaaabbbbbhhhhttttttrrrrrr should be a4b5h4t6r6 --> " +
                //simpleCompression("aaaabbbbbhhhhhttttttrrrrrr"));
        //System.out.println("ggbb should be g2b2 --> "+ simpleCompression("ggbb"));
        System.out.println("full text: I am a goose, I am a horse, I am an animal, I am a fruit ahhh!");
        System.out.println("phrase: \"I am a \" -->");
        System.out.print(dictionaryCompression("I am a goose, I am a horse, I am an animal, I am a fruit ahhh!",""));
        String fullText;
        //user input the phrase to compress



    }

}
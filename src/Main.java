import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main
{

    //                                 EXERCISE 1:

    // This function determines whether all the characters in the provided string are unique.
    // It returns true if all the characters appear only once in the string, and false otherwise.
    // It uses a set to check if each character is unique
    public static boolean onlyUniqueCharacters(String str)
    {
        if (str.length() == 0)
            return false;

        Set<Character> uniqueChars = new HashSet<>();

        for (char c : str.toCharArray())
        {
            if (uniqueChars.contains(c))
                return false;
            uniqueChars.add(c);
        }

        return true;
    }

    // This function determines whether all the characters in the provided string are unique.
    // It returns true if all the characters appear only once in the string, and false otherwise.
    // It does not use any additional datastructures
    public static boolean onlyUniqueCharactersWithoutExtraDataStructures(String str)
    {
        if (str.length() == 0)
            return false;

        for (int i = 0; i < str.length(); i++)
        {
            for (int j = i + 1; j < str.length(); j++)
            {
                if (str.charAt(i) == str.charAt(j))
                    return false;
            }
        }

        return true;
    }

    //                              EXERCISE 2:

    // This function finds all the unique substrings of a given length within the string,
    // where each substring contains exactly 'num - 1' distinct characters.
    // It returns a list of the unique substrings without any duplicates.
    public static List<String> findSubstrings(String s, int num)
    {
        List<String> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        for (int i = 0; i <= s.length() - num; i++)
        {
            String sub = s.substring(i, i + num);
            if (!seen.contains(sub) && hasNMinusOneDistinctCharacters(sub))
            {
                result.add(sub);
                seen.add(sub);
            }
        }

        return result;
    }

    // This function checks if a given substring contains exactly the given length -1 distinct characters.
    // It returns true if the condition is met, indicating the substring has the required number of unique characters, and false otherwise.
    // Helper the function findSubstrings.
    private static boolean hasNMinusOneDistinctCharacters(String sub)
    {
        Set<Character> chars = new HashSet<>();
        for (char c : sub.toCharArray())
        {
            chars.add(c);
        }
        return chars.size() == sub.length() - 1;
    }

    public static void main(String[] args)
    {
        String string1 = "a";
        String string2 = "abcd";
        String string3 = "abacdef";

        System.out.println("EXERCISE 1:");

        System.out.println();

        System.out.println("Input: " + string1 + ", Output: " + onlyUniqueCharacters(string1));
        System.out.println("Input: " + string2 + ", Output: " + onlyUniqueCharacters(string2));
        System.out.println("Input: " + string3 + ", Output: " + onlyUniqueCharacters(string3));

        System.out.println();

        System.out.println("Input: " + string1 + ", Output: " + onlyUniqueCharactersWithoutExtraDataStructures(string1));
        System.out.println("Input: " + string2 + ", Output: " + onlyUniqueCharactersWithoutExtraDataStructures(string2));
        System.out.println("Input: " + string3 + ", Output: " + onlyUniqueCharactersWithoutExtraDataStructures(string3));

        System.out.println();

        System.out.println("EXERCISE 2:");

        System.out.println();

        String input = "aabbcd";
        int num = 3;
        List<String> substrings = findSubstrings(input, num);
        System.out.println("Input: " + input + " " + num);
        System.out.println("Output: " + String.join(", ", substrings));
    }
}
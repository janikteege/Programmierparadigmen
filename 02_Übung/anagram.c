// Zusammenarbeit von Janik Teege & Nele Hüsemann

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int is_anagram(char* word, char* compared) {
    /*
    * This function checks if two words are anagrams.
    */
    int len1 = strlen(word);
    int len2 = strlen(compared);

    if (len1 != len2) {
        return 0; // not an anagram if lengths are different
    }

    int count[95] = {0}; // all printable ASCII characters

    for (int i = 0; i < len1; i++) {
        // ' ' is the first printable ASCII character
        // so we can use the character as an index
        count[word[i] - ' ']++; 
        count[compared[i] - ' ']--;
    }

    for (int i = 0; i < 95; i++) {
        if (count[i] != 0) {
            return 0; // not an anagram if counts are not equal
        }
    }
    return 1; // anagram
}

void test_cases() {
    // Anagram
    char* str1 = "listen";
    char* str2 = "silent";
    int result = is_anagram(str1, str2);
    printf("Test case 1: %s\n", result ? "Passed" : "Failed");

    // Not anagram
    str1 = "hello";
    str2 = "world";
    result = is_anagram(str1, str2);
    printf("Test case 2: %s\n", !result ? "Passed" : "Failed");

    // Anagram with different case can be 0
    str1 = "Debit Card";
    str2 = "Bad Credit";
    result = is_anagram(str1, str2);
    printf("Test case 3: %s\n", !result ? "Passed" : "Failed");

    // Anagram with special characters
    str1 = "rail safety";
    str2 = "fairy tales";
    result = is_anagram(str1, str2);
    printf("Test case 4: %s\n", result ? "Passed" : "Failed");
}



int main() {
    test_cases();
    return EXIT_SUCCESS;
}
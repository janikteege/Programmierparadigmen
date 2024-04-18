// Zusammenarbeit von Janik Teege & Nele Hüsemann
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char* concat(char* string1, char* string2) {
    size_t result_len = strlen(string1) + strlen(string2) + 1; // add 1 for the null terminator
    char* result = malloc(result_len);
    for (size_t i = 0; i < result_len; i++)
    {
        if (i < strlen(string1))
        {
            result[i] = string1[i];
        }
        else
        {
            result[i] = string2[i - strlen(string1)];
        }
    }
    result[result_len-1] = '\0';
    return result;
}

void test_cases() {
    char* str1 = "Hello ";
    char* str2 = "World";
    char* expected = "Hello World";

    char* result = concat(str1, str2);
    
    if (strlen(result) == strlen(expected)) {
        printf("Test passed: Length is correct\n");
        for (size_t i = 0; i < strlen(result); i++)
        {
            if (result[i] != expected[i]) {
                printf("Test failed: Concatenation is incorrect\n");
                free(result);
                return;
            }
        }
    } else {
        printf("Test failed: Length is incorrect\n");
    }
    printf("Test passed: Concatenation is correct\n");
    free(result);
}


int main() {
   test_cases();
   return EXIT_SUCCESS;
}
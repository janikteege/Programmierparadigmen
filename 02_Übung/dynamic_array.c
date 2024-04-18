// Zusammenarbeit von Janik Teege & Nele Hüsemann
#include <stdlib.h>
#include <stdio.h>

typedef struct {
    char* array;
    int numElems;
    int size;
} Dyn_array_t;

void initArray(Dyn_array_t* array, int desSize) {
    array->array = malloc(desSize * sizeof(char));
    array->numElems = 0;
    array->size = desSize;
}

void resizeArray(Dyn_array_t* array, int newSize) {
    array->array = realloc(array->array, newSize * sizeof(char));
    array->size = newSize;
}

void destroyArray(Dyn_array_t* array) {
    // delete the array, set the pointer to NULL
    free(array->array);
    array->array = NULL;
    array->numElems = 0;
    array->size = 0;
}

void insert(Dyn_array_t* array, char elem) {
    if (array->size == array->numElems) {
        resizeArray(array, (array->size * 3) / 2 + 1);
    }
    array->array[array->numElems] = elem;
    array->numElems++;
}

void printArray(Dyn_array_t* array) {
    printf("numElems: %d", array->numElems);
    printf("   size: %d", array->size);
    printf("   content: [");
    for (int i = 0; i < array->numElems-1; i++) {
        printf("%c ", array->array[i]);
    }
    // print last element without space
    if (array->numElems > 0) {
        printf("%c]", array->array[array->numElems-1]);
    } else {
        printf("]");
    }
    printf("\n");
}

int main() {
    Dyn_array_t array;
    initArray(&array, 1);
    printArray(&array);
    insert(&array, 'a');
    printArray(&array);
    insert(&array, 'b');
    printArray(&array);
    insert(&array, 'c');
    printArray(&array);
    insert(&array, 'd');
    printArray(&array);
    insert(&array, 'e');
    printArray(&array);
    destroyArray(&array);
    printArray(&array);
    return EXIT_SUCCESS;
}
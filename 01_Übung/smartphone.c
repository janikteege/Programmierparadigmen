// Zusammenarbeit von Janik Teege & Nele Hüsemann
#include <stdio.h>

typedef struct {
    char* brand;
    char* model;
    char* color;
    int memory;
} smartphone_t;

void print_smartphone_configuration(smartphone_t phone) {
    printf("Your configuration:\n");
    printf("\tBrand: %s\n", phone.brand);
    printf("\tModel: %s\n", phone.model);
    printf("\tColor: %s\n", phone.color);
    printf("Total Memory: %dGB\n", phone.memory);
}

void add_additional_sd_card(smartphone_t* phone) {
    // Code to add additional SD card
    phone->memory += 128;  // same as (*phone).memory += 128;
}

int main() {
    smartphone_t phone = {"Sumsang", "Milkyway S3", "black", 16};
    print_smartphone_configuration(phone);
    add_additional_sd_card(&phone);
    print_smartphone_configuration(phone);

    return 0;
}
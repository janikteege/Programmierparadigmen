// Zusammenarbeit von Janik Teege & Nele Hüsemann

#include <stdio.h>

void print_tree_char(int height, char symbol) {
    int width = height * 2 - 1;
    for (size_t y = 0; y < height; y++)
    {
        for (size_t x = 0; x < width; x++)
        {
            // left padding && right padding
            if (x >= height - y - 1 && x <= height + y - 1)
            {
                printf("%c", symbol);
            }
            else
            {
                printf(" ");
            }
        }
        printf("\n");
    }
    // trunk
    for (size_t x = 0; x < width / 2; x++)
    {
        printf(" ");
    }
    printf("%c\n", symbol);
}

void print_tree(int height) {
    print_tree_char(height, '*');
}


int main() {
    print_tree(5);
    print_tree_char(5, 'o');
}
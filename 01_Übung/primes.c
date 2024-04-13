// Zusammenarbeit von Janik Teege & Nele Hüsemann

#include <stdio.h>
#include <math.h>


int is_prime(int num) {
    if (num < 2) {
        return 0;
    }
    for (int i = 2; i <= sqrt(num); i++) {
        if (num % i == 0) {
            return 0;
        }
    }
    return 1;
}

int calculate_nth_prime_number(int n) {
    int count = 0;
    int num = 2;
    while (count < n) {
        if (is_prime(num)) {
            count++;
        }
        num++;
    }
    return num - 1;
}


int main() {
    printf("is_prime(1) = %d\n", is_prime(1));
    printf("is_prime(2) = %d\n", is_prime(2));
    printf("is_prime(3) = %d\n", is_prime(3));
    printf("calculate_nth_prime_number(5) = %d\n", calculate_nth_prime_number(5));
    return 0;
}

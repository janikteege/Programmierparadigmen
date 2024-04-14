int main(){
    short truth = 42;
    short halfTruth = 23;

    short* p1 = &truth;
    short** p2 = &p1;
    short* p3 = &halfTruth;
    short* p4 = p1;
    short** p5 = &p3;
    short*** p6 = &p5;
    short*** p7 = &p2;
    short** p8 = *p6;
    short* p9 = *&*&p1;
    short** p10 = *p7;

    
    short test;

    test = *p1; // 42
    test = **p5; // 23
    test = *&*p9; // 42
    test = ***&p2; // 42
    test = ****&p6; // 23
    test = **p8; // 23
    p3 = p9;
    test = **p8; // 42
}
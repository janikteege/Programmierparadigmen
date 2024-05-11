// Zusammenarbeit von Janik Teege & Nele Hüsemann

/*
Kontext und Seiteneffekte


1. Das funktionale Paradigma kennzeichnet sich dadurch, dass es keinen Kontext und keine Seiteneffekte gibt. Was versteht man unter Kontext und Seiteneffekten?

2. Das als Template gegebene Java-Programm NonFunctional besitzt sowohl einen Kontext als auch Seiteneffekte. Geben Sie eine mögliche, semantisch äquivalente Variante Functional an, sodass das Java-Programm dem funktionalen Paradigma folgt!

    Hinweis: Dadurch, dass das Programm etwas auf der Konsole ausgibt, ist es möglich alle Seiteneffekte zu entfernen. Probiert, die Seiteneffekte so weit wie möglich zu bündeln.

## Lösung

# Kontext:
 - globabe Umstände eines Programmes (zB in globalen Variablen, Systemvariablen, Dateien,...)
 - Ergebnisse des Programms sind nicht nur von der Eingabe abhängig
 - gleiche Eingaben liefern nicht zwingend das gleiche Ergebnis

# Seiteneffekt:
 -  Einfluss des Programmes auf den Kontext
 - Veränderung des eigenen Kontextes oder des Kontextes anderer Programme durch
  - Veränderung von globalen Variablen
  - Veränderung von Systemvariablen
  - Speichern von Dateien

*/

public class Functional {

    static void print0(){
        System.out.format("%d\n",0);
    }

    static void printNumberCodecs(int printNumber){
        System.out.format("0b%s\n", Integer.toBinaryString(printNumber));
        System.out.format("0o%s\n",Integer.toOctalString(printNumber));
        System.out.format("%d\n",printNumber);
        System.out.format("0x%s\n",Integer.toHexString(printNumber));
    }

    public static void main(String[] args){
        print0();
        printNumberCodecs(1337);
    }
}
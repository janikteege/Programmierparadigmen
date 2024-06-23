% Zusammenarbeit Janik Teege und Nele Hüsemann

% Aufgabe 1 GGT

% X muss größer als 0 sein, damit der Teiler nicht 0 ist
ggt(X, 0, X) :- X > 0.

% Y muss größer als 0 sein, damit der Teiler nicht 0 ist
ggt(0, Y, Y) :- Y > 0.

% X, Y, G sind Zahlen, G ist der größte gemeinsame Teiler von X und Y
% Euclidischer Algorithmus
ggt(X, Y, G) :- 
    X > 0, Y > 0,
    Z is X mod Y,
    ggt(Y, Z, G).


% Aufgabe 2 - Primzahl

% ist X ein Teiler von Y?
divides(X, Y) :- 0 is Y mod X.

% Start ist größer als End, wenn keine Teiler gefunden wurden
noDivisors(Start, End, N) :- Start > End.

% gibt es keinen Teiler von N in der Range von Start bis End?
noDivisors(Start, End, N) :- Start =< End, \+ divides(Start, N), Next is Start + 1, noDivisors(Next, End, N).

% ist P eine Primzahl?
isPrime(2).
isPrime(P) :- P>2, HalfP is P // 2, noDivisors(2, HalfP, P).
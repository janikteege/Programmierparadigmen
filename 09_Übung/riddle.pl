% Definition von Autos als Fakten
% auto(Marke, Farbe, Beruf, CD, Stadt, Platz)

% Autos ohne spezifische Werte initialisieren
auto(ferrari, rot, _, _, _, _).
auto(_, silber, lehrer, _, _, _).
auto(vw, _, _, madonna, _, _).
auto(bmw, _, _, _, muenchen, _).
auto(_, blau, _, _, _, _).
auto(_, gruen, _, _, hamburg, _).
auto(_, braun, _, _, _, _).
auto(_, _, metzger, abba, _, _).
auto(_, _, _, beatles, _, _).
auto(_, _, notar, _, koeln, _).
auto(smart, _, _, _, _, _).
auto(ford, _, schreiner, _, _, _).
auto(_, _, _, eminem, _, 4).
auto(_, _, baecker, _, _, _).
auto(_, _, _, heino, _, _).

% Definition der "neben" Relation
neben(auto(_, _, _, _, _, P1), auto(_, _, _, _, _, P2)) :- 
    (P1 is P2 + 1; P1 is P2 - 1).

% Hinzufügen der Nebenbedingungen
neben(auto(bmw, _, _, _, muenchen, _), auto(_, blau, _, _, _, _)) :- Auto1 = auto(bmw, _, _, _, muenchen, _), Auto2 = auto(_, blau, _, _, _, _).
neben(Auto1, Auto2) :- Auto1 = auto(_, gruen, _, _, hamburg, _), Auto2 = auto(_, braun, _, _, _, _).
neben(Auto1, Auto2) :- Auto1 = auto(_, _, _, beatles, _, _), Auto2 = auto(_, silber, lehrer, _, _, _).
neben(Auto1, Auto2) :- Auto1 = auto(smart, _, _, _, _, _), Auto2 = auto(_, blau, _, _, _, _).
neben(Auto1, Auto2) :- Auto1 = auto(_, _, _, _, berlin, _), Auto2 = auto(_, _, baecker, _, _, _).

not_neben(Auto1, Auto2) :- Auto1 = auto(_, _, _, _, stuttgart, _), Auto2 = auto(bmw, _, _, _, _, _).

% Definition der solve Regel
solve(Beruf) :-
    auto(_, _, Beruf, heino, _, _),
    auto(ferrari, rot, _, _, _, _),
    auto(_, silber, lehrer, _, _, _),
    auto(vw, _, _, madonna, _, _),
    auto(bmw, _, _, _, muenchen, _),
    auto(_, blau, _, _, _, _),
    auto(_, gruen, _, _, hamburg, _),
    auto(_, braun, _, _, _, _),
    auto(_, _, metzger, abba, _, _),
    auto(_, _, _, beatles, _, _),
    auto(_, _, notar, _, koeln, _),
    auto(smart, _, _, _, _, _),
    auto(ford, _, schreiner, _, _, _),
    auto(_, _, _, eminem, _, 4),
    auto(_, _, baecker, _, _, _),
    neben(auto(bmw, _, _, _, muenchen, _), auto(_, blau, _, _, _, _)),
    neben(auto(_, gruen, _, _, hamburg, _), auto(_, braun, _, _, _, _)),
    neben(auto(_, _, _, beatles, _, _), auto(_, silber, lehrer, _, _, _)),
    neben(auto(smart, _, _, _, _, _), auto(_, blau, _, _, _, _)),
    neben(auto(_, _, _, _, berlin, _), auto(_, _, baecker, _, _, _)),
    not(not_neben(auto(_, _, _, _, stuttgart, _), auto(bmw, _, _, _, _, _))).

% Testen der Regel solve
?- solve(Beruf).

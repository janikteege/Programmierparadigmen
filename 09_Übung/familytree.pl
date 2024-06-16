% Zusammenarbeit Janik Teege & Nele Hüsemann

% Eltern-Kind-Beziehungen (Fakten)
% https://images.edrawmax.com/examples/family-tree-examples/example4.jpg
vater(homer, bart).
vater(homer, lisa).
vater(homer, maggie).
mutter(marge, bart).
mutter(marge, lisa).
mutter(marge, maggie).
vater(abe, homer).
mutter(mona, homer).
vater(clancy, marge).
mutter(jacqueline, marge).
vater(clancy, patty).
mutter(jacqueline, patty).
vater(clancy, selma).
mutter(jacqueline, selma).
vater(abe, herb).
vater(abe, abbey).

% Geschwisterregel
geschwister(X, Y) :-
    vater(V, X), vater(V, Y),
    mutter(M, X), mutter(M, Y),
    X \= Y.

% Großvaterregel
grossvater(X, Y) :-
    vater(X, Z),
    (vater(Z, Y); mutter(Z, Y)).

% Großmutterregel
grossmutter(X, Y) :-
    mutter(X, Z),
    (vater(Z, Y); mutter(Z, Y)).

% Onkelregel
onkel(X, Y) :-
    vater(V, Y), geschwister(X, V), mann(X);
    mutter(M, Y), geschwister(X, M), mann(X).

% Tanteregel
tante(X, Y) :-
    vater(V, Y), geschwister(X, V), frau(X);
    mutter(M, Y), geschwister(X, M), frau(X).

% Cousinregel
cousin(X, Y) :-
    (vater(V1, X); mutter(M1, X)),
    geschwister(V1, V2),
    (vater(V2, Y); mutter(M2, Y)),
    mann(X).

% Cousineregel
cousine(X, Y) :-
    (vater(V1, X); mutter(M1, X)),
    geschwister(V1, V2),
    (vater(V2, Y); mutter(M2, Y)),
    frau(X).

% Geschlechtregeln
mann(homer).
mann(bart).
mann(abe).
mann(clancy).
mann(herb).

frau(marge).
frau(lisa).
frau(maggie).
frau(mona).
frau(jacqueline).
frau(patty).
frau(selma).
frau(abbey).

% Beispielabfragen:
% ?- vater(homer, bart).
% ?- mutter(marge, bart).
% ?- vater(abe, homer).
% ?- geschwister(bart, lisa).
% ?- grossvater(abe, bart).
% ?- grossmutter(mona, bart).
% ?- tante(selma, bart).

% ?- geschwister(X, lisa).

% Halbgeschwisterregel halbgeschwister(X, Y) :- (vater(V, X), vater(V, Y)); (mutter(M, X), mutter(M, Y)), not(geschwister(X, Y)).

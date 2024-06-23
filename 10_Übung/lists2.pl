% Zusammenarbeit Janik Teege und Nele Hüsemann

% Basisfall: Wenn I > J, dann ist die Liste leer
slice(L, I, J, []) :- I > J.

% Entfernt den Kopf der Liste bis I = 0
slice([_|Tail], I, J, R) :-
    I > 0,
    I1 is I - 1,
    J1 is J - 1,
    slice(Tail, I1, J1, R).

% Fügt den Kopf der Liste hinzu
slice([Head|Tail], 0, J, [Head|R]) :-
    J >= 0,
    J1 is J - 1,
    slice(Tail, 0, J1, R).


% Basisfall: Wenn I > J, dann ist die Liste leer
range(I, J, []) :-  I > J.

% Fügt die Zahl I zur Liste hinzu und ruft sich selbst mit I+1 auf
range(I, J, [I|R]) :- 
    I =< J,
    I1 is I + 1,
    range(I1, J, R).

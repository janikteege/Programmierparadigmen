% Zusammenarbeit Janik Teege und Nele Hüsemann
% Definition eines leeren Baums
nil.

% Definition eines Knotens mit einem Element K, einem linken Baum L und einem rechten Baum R
tree(K, L, R).


% AUFGBE 1

contains(tree(K, _, _), X) :- 
    K = X, !. % Wenn das Element gefunden wird, beenden wir die Suche mit cut

contains(tree(_, L, _), X) :- 
    contains(L, X). % Rekursion auf dem linken Teilbaum, falls Element nicht gefunden wurde

contains(tree(_, _, R), X) :- 
    contains(R, X). % Rekursion auf dem rechten Teilbaum, falls Element nicht im linken Teilbaum gefunden wurde

% AUFGABE 2

% ist ganzer Baum kleiner als X?
less_than(nil, _).
less_than(tree(K, L, R), X) :- 
    K < X,
    less_than(L, X), 
    less_than(R, X).

% ist ganzer Baum größer als X?
greater_than(nil, _).
greater_than(tree(K, L, R), X) :- 
    K > X,
    greater_than(L, X),
    greater_than(R, X).

isSearchTree(nil).
isSearchTree(tree(K, L, R)) :- 
    isSearchTree(L),
    less_than(L, K), 
    greater_than(R, K), 
    isSearchTree(R).

example_tree(
    tree(10, 
        tree(5, 
            tree(3, nil, nil), 
            tree(7, nil, nil)), 
        tree(15, 
            tree(12, nil, nil), 
            tree(17, nil, nil))
        )
    ).

not_search_tree(
    tree(10, 
        tree(5, 
            tree(3, nil, nil), 
            tree(12, nil, nil)), % 12 ist größer als 10, daher kein Suchbaum
        tree(15, 
            tree(12, nil, nil), 
            tree(17, nil, nil))
        )
    ).
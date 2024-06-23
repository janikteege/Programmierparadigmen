% Zusammenarbeit Janik Teege und Nele Hüsemann

% siehe https://www.swi-prolog.org/pldoc/man?section=clpfd-n-queens
% und https://stackoverflow.com/questions/53406374/understanding-clpfd-prolog-code-of-n-queens-problem
:- use_module(library(clpfd)).

% nqueens problem
nqueens(N, Qs) :-
    length(Qs, N), % for a NxN board with N queens
    Qs ins 1..N, % Queen must be on the board
    safe(Qs), % check if the queens are safe
    label(Qs). % label the queens, needed to get the solution


% check if the queens are safe
safe([]). % if there are no queens, they are safe
safe([Q|Qs]) :- 
    safe(Qs, Q, 1), % check if queen Q is safe
    safe(Qs). % check if the rest of the queens are safe


safe([], _, _). % if there are no queens, they are safe
% Q is the current queen, Q0 is the previous queen, D0 is the distance between the previous queen and the current queen
safe([Q|Qs], Q0, D0) :-
        Q0 #\= Q, % Q0 is not in the same row as Q
        abs(Q0 - Q) #\= D0, % Q0 is not in the same diagonal as Q (difference in rows is not equal to difference in columns)
        D1 #= D0 + 1, % Increment the distance for the next queen, which is in next column
        safe(Qs, Q0, D1). % check if the rest of the queens are safe
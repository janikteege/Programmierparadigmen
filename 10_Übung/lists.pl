% Zusammenarbeit Janik Teege und Nele Hüsemann

% AUFGABE 1
filter([], _, []). % Liste und Ausgabeliste sind leer

filter([Head|Rest], Element, [HeadA|RestA]) :-
    Head is Element, HeadA is Element, filter(Rest, Element, RestA); % Element ist Head beider Liste, entferne Head
    Head \= Element, filter(Rest, Element, [HeadA|RestA]). % Element ist nicht Head, prüfe Rest der Liste

% fall wenn Ausgabeliste leer ist
filter([Head|Rest], Element, []) :-
    Head \= Element, filter(Rest, Element, []). % Prüfe Rest der Liste

% AUFGABE 2
rotate_left([], []). % Liste ist leer
% Füge Head an Tail an und entferne Head
rotate_left([Head|Tail], TailHead) :- 
    append(Tail, [Head], TailHead). % TailHead ist Tail mit Head am Ende

% AUFGABE 3
isEqual([], []). % Beide Listen sind leer
isEqual([Head1|Tail1], [Head2|Tail2]) :- 
    Head1 = Head2, isEqual(Tail1, Tail2). % Head1 und Head2 sind gleich, prüfe Rest der Listen


trim_ends([], []). % Liste ist leer
trim_ends([_], []). % Liste hat nur ein Element)
trim_ends([_,_|[]], []). % Liste hat genau zwei Elemente
trim_ends([First|Rest], Trimmed) :- 
    append(Middle, [_], Rest), % Entferne letztes Element aus Rest, Middle + [_] = Rest
    isEqual(Trimmed, Middle). % Das Ergebnis ist die Mitte ohne erstes und letztes Element

isNearlyEqual(Liste1, Liste2) :- % Prüfe ob die Listen fast gleich sind
    trim_ends(Liste1, Trimmed1), % Entferne erstes und letztes Element
    trim_ends(Liste2, Trimmed2), % Entferne erstes und letztes Element
    isEqual(Trimmed1, Trimmed2). % Prüfe ob die Listen gleich sind
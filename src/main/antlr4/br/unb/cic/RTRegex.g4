grammar RTRegex;

@rulecatch {
   catch (RecognitionException e) {
    throw e;
   }
}

rt:     expr NEWLINE                            # printExpr
  |     NEWLINE                                 # blank
  ;

expr:   t=('G'|'T') id							# gId
    |	'DM(' expr ')'							# gDecisionMaking
    | 	expr op=',' expr						# gDM
    |	expr op='@' FLOAT						# gRetry
    |   'try(' expr ')' '?' expr ':' expr		# gTry
    |	expr op=(';'|'#') expr					# gTime
    |   SKIPP									# gSkip
    ;
    
id:		FLOAT
	|	FLOAT X
	|	X
	;

FLOAT		: DIGIT+'.'?DIGIT* 	;
SEQ         : ';'				;
INT			: '#'				;
TASK		: 'T'				;
GOAL		: 'G'				;
SKIPP		: 'skip'			;
X			: 'X'				;
NEWLINE 	: [\r\n]+           ;
WS          : [\t]+ -> skip 	;

fragment
DIGIT		: [0-9]				;

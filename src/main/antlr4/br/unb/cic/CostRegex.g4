grammar CostRegex;

@rulecatch {
   catch (RecognitionException e) {
    throw e;
   }
}

cost:	'W' op='=' FLOAT			# gFloat
	|	'W' op='=' FLOAT VAR		# gExpression
	|	'W' op='=' VAR				# gVariable
 	|	NEWLINE						# blank
  	;

FLOAT		: DIGIT+'.'?DIGIT* 			;
VAR     	: ('a'..'z'|'A'..'Z'|'_')+	;
NEWLINE 	: [\r\n]+           		;
WS          : [\t]+ -> skip 			;

fragment
DIGIT		: [0-9]						;

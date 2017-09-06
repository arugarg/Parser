# Parser  
An LR(0) and a LR(1) Parser built as a Course project for Compilers in Java.  
------------------------------------------------------------------------------  
Source Code Package (Source_files) contains 4 source files :  
	•	Grammar.java  
	•	StateTable.java  
	•	Items.java  
	•	Build_LR.java  
Build_LR is the main file which runs the result of parsing the input string in the specified LR parser.  
*if the input string needs to be changed – edit it in the main method of Build_LR.java  

Options for Opening the code:  
	•	Compile the source files  
	•	Or Run the class files  
-------------------------------------------------------------------------------  
Sample Output :  

	•	For LR(0) Parser  
The LR(0) Parser Table :   
 -1 |        i       (       )       +       $       S       E       T  
  0 |       s5      s6       -       -       -       -       1       9  
  1 |        -       -       -      s3      s2       -       -       -  
  2 |   Accept  Accept  Accept  Accept  Accept       -       -       -  
  3 |       s5      s6       -       -       -       -       -       4  
  4 |       r1      r1      r1      r1      r1       -       -       -  
  5 |       r3      r3      r3      r3      r3       -       -       -  
  6 |       s5      s6       -       -       -       -       7       9  
  7 |        -       -      s8      s3       -       -       -       -  
  8 |       r4      r4      r4      r4      r4       -       -       -  
  9 |       r2      r2      r2      r2      r2       -       -       -  

Stack 	 	 	 Input 	 	 	 	 Action  
          $0	 	 	       i+i$ 	 	 		s5  
         $05	 	 	        +i$ 	 	 		r3  
         $09	 	 	        +i$ 	 	 		r2  
         $01	 	 	        +i$ 	 	 		s3  
        $013	 	 	         i$ 	 	 		s5  
       $0135	 	 	          $ 	 	 		r3  
       $0134	 	 	          $ 	 	 		r1  
         $01	 	 	          $ 	 	 		s2  
        $012	 	 	            	 	 		Accept  
--------------------------------------  
	•	For LR(1) Parser
The LR(1) Parser Table : 
 -1 |        i       (       )       +       *       $       S       E       T       F
  0 |       s5      s6       -       -       -       -       -       1       7       4
  1 |        -       -       -      s3       -      s2       -       -       -       -
  2 |        -       -       -       -       -  Accept       -       -       -       -
  3 |       s5      s6       -       -       -       -       -       -      11       4
  4 |        -       -      r4      r4      r4      r4       -       -       -       -
  5 |        -       -      r5      r5      r5      r5       -       -       -       -
  6 |       s5      s6       -       -       -       -       -      10       7       4
  7 |        -       -      r2      r2      s8      r2       -       -       -       -
  8 |       s5      s6       -       -       -       -       -       -       -       9
  9 |        -       -      r3      r3      r3      r3       -       -       -       -
 10 |        -       -     s12      s3       -       -       -       -       -       -
 11 |        -       -      r1      r1      s8      r1       -       -       -       -
 12 |        -       -      r6      r6      r6      r6       -       -       -       -



Stack 	 	            Input 	 	 	  Action
          $0	 	 	      i+i*i$ 	 	 	s5
         $05	 	 	     	+i*i$ 	 	 	r5
         $04	 	 	     	+i*i$ 	 	 	r4
         $07	 	 	    	+i*i$ 	 	 	r2
         $01	 	 	   	  +i*i$ 	 	 	s3
        $013	 	 	      i*i$ 	 	  	s5
       $0135	 	 	       *i$ 	 	 	 r5
       $0134	 	 	       *i$ 	 	 	 r4
      $01311	 	 	       *i$ 	 	 	 s8
     $013118	 	 	        i$ 	 	 	 s5
    $0131185	 	 	         $ 	 	 	 r5
    $0131189	 	 	         $ 	 	 	 r3
     $013111	 	 	         $ 	 	 	 r1
       $0131	 	 	         $ 	 	 	 s2
      $01312	 	 	            	 	 Accept
      
--------------------------------------------------------------------------------------------
Grammar :

Items for LR(0)
  0 | [S->.E$, E->.E+T, E->.T, T->.i, T->.(E)]
  1 | [S->E.$, E->E.+T]
  2 | [S->E$.]
  3 | [E->E+.T, T->.i, T->.(E)]
  4 | [E->E+T.]
  5 | [T->i.]
  6 | [T->(.E), E->.E+T, E->.T, T->.i, T->.(E)]
  7 | [T->(E.), E->E.+T]
  8 | [T->(E).]
  9 | [E->T.]

 Items for LR(1)
  0 | [S->.E$, E->.E+T, E->.T, T->.T*F, T->.F, F->.i, F->.(E)]
  1 | [S->E.$, E->E.+T]
  2 | [S->E$.]
  3 | [E->E+.T, T->.T*F, T->.F, F->.i, F->.(E)]
  4 | [T->F.]
  5 | [F->i.]
  6 | [F->(.E), E->.E+T, E->.T, T->.T*F, T->.F, F->.i, F->.(E)]
  7 | [E->T., T->T.*F]
  8 | [T->T*.F, F->.i, F->.(E)]
  9 | [T->T*F.]
 10 | [F->(E.), E->E.+T]
 11 | [E->E+T., T->T.*F]
 12 | [F->(E).]


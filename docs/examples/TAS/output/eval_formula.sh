#!/bin/bash
CTX_G2_T6_3="1";
CTX_G2_T6_1="1";
CTX_G2_T6_2="1";
CTX_G8_T5_3="1";
CTX_G8_T5_2="1";
CTX_G1="1";
CTX_G4_T2_1="1";
CTX_G8_T5_1="1";
CTX_G2="1";
CTX_G4_T2_2="1";
CTX_G4_T2_3="1";
CTX_G5="1";
R_G6_T3_1="0.99";
R_G3_T1="0.99";
R_G6_T3_2="0.99";
R_G2_T6_3="0.99";
R_G2_T6_1="0.99";
R_G2_T6_2="0.99";
R_G8_T5_3="0.99";
R_G8_T5_2="0.99";
R_G4_T2_1="0.99";
R_G8_T5_1="0.99";
R_G4_T2_2="0.99";
R_G4_T2_3="0.99";
W_G6_T3_1="1";
W_G3_T1="1";
W_G6_T3_2="1";
W_G2_T6_3="1";
W_G2_T6_1="1";
W_G2_T6_2="1";
W_G8_T5_3="1";
W_G8_T5_2="1";
W_G4_T2_1="1";
W_G8_T5_1="1";
W_G4_T2_2="1";
W_G4_T2_3="1";


sed   -e "s/CTX_G2_T6_3/$CTX_G2_T6_3/g" -e "s/CTX_G2_T6_1/$CTX_G2_T6_1/g" -e "s/CTX_G2_T6_2/$CTX_G2_T6_2/g" -e "s/CTX_G8_T5_3/$CTX_G8_T5_3/g" -e "s/CTX_G8_T5_2/$CTX_G8_T5_2/g" -e "s/CTX_G1/$CTX_G1/g" -e "s/CTX_G4_T2_1/$CTX_G4_T2_1/g" -e "s/CTX_G8_T5_1/$CTX_G8_T5_1/g" -e "s/CTX_G2/$CTX_G2/g" -e "s/CTX_G4_T2_2/$CTX_G4_T2_2/g" -e "s/CTX_G4_T2_3/$CTX_G4_T2_3/g" -e "s/CTX_G5/$CTX_G5/g" -e "s/R_G6_T3_1/$R_G6_T3_1/g" -e "s/R_G3_T1/$R_G3_T1/g" -e "s/R_G6_T3_2/$R_G6_T3_2/g" -e "s/R_G2_T6_3/$R_G2_T6_3/g" -e "s/R_G2_T6_1/$R_G2_T6_1/g" -e "s/R_G2_T6_2/$R_G2_T6_2/g" -e "s/R_G8_T5_3/$R_G8_T5_3/g" -e "s/R_G8_T5_2/$R_G8_T5_2/g" -e "s/R_G4_T2_1/$R_G4_T2_1/g" -e "s/R_G8_T5_1/$R_G8_T5_1/g" -e "s/R_G4_T2_2/$R_G4_T2_2/g" -e "s/R_G4_T2_3/$R_G4_T2_3/g" -e "s/W_G6_T3_1/$W_G6_T3_1/g" -e "s/W_G3_T1/$W_G3_T1/g" -e "s/W_G6_T3_2/$W_G6_T3_2/g" -e "s/W_G2_T6_3/$W_G2_T6_3/g" -e "s/W_G2_T6_1/$W_G2_T6_1/g" -e "s/W_G2_T6_2/$W_G2_T6_2/g" -e "s/W_G8_T5_3/$W_G8_T5_3/g" -e "s/W_G8_T5_2/$W_G8_T5_2/g" -e "s/W_G4_T2_1/$W_G4_T2_1/g" -e "s/W_G8_T5_1/$W_G8_T5_1/g" -e "s/W_G4_T2_2/$W_G4_T2_2/g" -e "s/W_G4_T2_3/$W_G4_T2_3/g" $1 |  gawk '{print "scale=20;"$0}' | bc
exit 0;


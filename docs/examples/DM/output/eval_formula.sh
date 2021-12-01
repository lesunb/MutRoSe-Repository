#!/bin/bash
CTX_G1_T1_1="1";
W_G1_T1_1="1";
R_G1_T1_1="0.99";
F_G1_T1_1="0.99";
CTX_G1_T1_2="1";
W_G1_T1_2="1";
R_G1_T1_2="0.99";
F_G1_T1_2="0.99";


sed   -e "s/CTX_G1_T1_1/$CTX_G1_T1_1/g" -e "s/W_G1_T1_1/$W_G1_T1_1/g" -e "s/R_G1_T1_1/$R_G1_T1_1/g" -e "s/F_G1_T1_1/$F_G1_T1_1/g" -e "s/CTX_G1_T1_2/$CTX_G1_T1_2/g" -e "s/W_G1_T1_2/$W_G1_T1_2/g" -e "s/R_G1_T1_2/$R_G1_T1_2/g" -e "s/F_G1_T1_2/$F_G1_T1_2/g" $1 |  gawk '{print "scale=20;"$0}' | bc
exit 0;


#!/bin/bash
W_G1_T1_1="1";
R_G1_T1_1="0.99";
F_G1_T1_1="0.99";
OPT_G1_T1_X="1";
W_G1_T1_X="1";
R_G1_T1_X="0.99";
F_G1_T1_X="0.99";


sed   -e "s/W_G1_T1_1/$W_G1_T1_1/g" -e "s/R_G1_T1_1/$R_G1_T1_1/g" -e "s/F_G1_T1_1/$F_G1_T1_1/g" -e "sOPT_G1_T1_X/$OPT_G1_T1_X/g" -e "s/W_G1_T1_X/$W_G1_T1_X/g" -e "s/R_G1_T1_X/$R_G1_T1_X/g" -e "s/F_G1_T1_X/$F_G1_T1_X/g" $1 |  gawk '{print "scale=20;"$0}' | bc
exit 0;


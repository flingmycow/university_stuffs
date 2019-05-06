//
//  33.c
//  (Attempt) Computer Simulator - #31 of Assignment 2
//  COMP281 - Principles of C & Memory Management
//
//  Created by Fumiko Saito on 3/10/2014.
//  Copyright (c) 2014 Fumi Saito. All rights reserved.

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
    //
    char hexa[257];
    // Pointer to keep track of the file to be opened.
    FILE *filep;
    
    // Opens the file to READ only
    filep = fopen("c:\\input1.bin", "r");

    // To read 256 characters all of which are 1 byte to char array called hexa.
    fread(hexa, 1, 256, filep);
    printf("%s", hexa);
    
}

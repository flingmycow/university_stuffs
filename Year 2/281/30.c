//
//  30.c
//  Decode Program - #30 of Assignment 3
//  COMP281 - Principles of C & Memory Management
//
//  Created by Fumiko Saito on 3/09/2014.
//  Copyright (c) 2014 Fumi Saito. All rights reserved.

#include <stdio.h>
#include <string.h>

int main()
{
    int i, operator, opValue;
    int count = -1;
    int stop = 50;
    int *hexa;
    
    // printf("Enter some hexadecimal values\n");
    // I use malloc to allocate enough space for a 2 digit hexadecimal value in an array which I plan to call hexa.
    // Multiplies by 2 in the statement as I want 2 int digits (for now).
    hexa = (int*)malloc(2*sizeof(int));

    // Loops through until 'FF' or 255 is entered and makes stop = 0 to stop the loop.
    for (i = 0; i < stop; i++)
    {
        scanf("%x", &hexa[i]);
        
        // Since I only allocated 2 Int's worth of memory I need to reallocate enough memory with each iteration until the loop has finished.
        hexa = (int*)realloc(hexa, 2*sizeof(int));
        
        if (hexa[i] == 255)
        {
            stop = 0;
        }
        
        // Count is used for the other loops
        count++;
    }
    
    // To convert the hexadecimal number to decimal by using switch case statements to convert A-F to 10-15 respectively.
    for (i = 0; i < count; i++)
    {
        switch(hexa[i])
        {
            case 'A' : hexa[i] = '10';
                break;
                
            case 'B' : hexa[i] = '11';
                break;
                
            case 'C' : hexa[i] = '12';
                break;
                
            case 'D' : hexa[i] = '13';
                break;
                
            case 'E' : hexa[i] = '14';
                break;
                
            case 'F' : hexa[i] = '15';
                break;
                
            default: hexa[i] = hexa[i];
        }
    }
    
    printf("\n");
    
    // Splitting the decimal numbers into seperate decimal values of the characters.
    for (i = 0; i < count; i++)
    {
        operator = (hexa[i] % 16); // To determine the lower digit AKA operator
        opValue = (hexa[i] / 16); // To determine the upper digit AKA value done by operator.
        
        
        // If the value in operator is between 0-6 it will have either SET, ADD, SUB, MUL, DIV, JMP or REP as a command. If the value in operator is 7 or higher it will not do anything.
        if (operator == 0)
        {
            printf("SET %d\n", opValue);
        }
        
        else if (operator == 1)
        {
            printf("ADD %d\n", opValue);
        }
        
        else if (operator == 2)
        {
            printf("SUB %d\n", opValue);
        }
        
        else if (operator == 3)
        {
            printf("MUL %d\n", opValue);
        }
        
        else if (operator == 4)
        {
            printf("DIV %d\n", opValue);
        }
        
        else if (operator == 5)
        {
            printf("JMP %d\n", opValue);
        }
        
        else if (operator == 6)
        {
            printf("REP %d\n", opValue);
        }
        
        else
        {
            printf("");
        }
    }
}
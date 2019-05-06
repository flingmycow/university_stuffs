
//
//  22.c
//  Delete Character From String - #22 of Assignment 2
//  COMP281 - Principles of C & Memory Management
//
//  Created by Fumiko Saito on 03/03/2014.
//  Copyright (c) 2014 Fumi Saito. All rights reserved.

#include <stdio.h>
#include <stdlib.h> // Required to use the malloc function

int main()
{
    // Declaring all the variables to be used including pointer for the array called string whose size is determined and allocated with user input/malloc.
    int i, j, number;
    char characters;
    char letter;
    char* string;
    
    printf("Enter a value, followed by a string followed by a letter to be removed from the string\n");
    scanf("%d", &number);
    
    if (number > 5000000 || number == 0)
    {
        printf("Please enter a number between 0 and 5000000");
        scanf("%d", &number);
    }
    
    // Requests memory. The statement will allocate whatever number is * int (size of 2 or 4 bytes)
    string = (char*)malloc(number * sizeof(int));
    
    // Iterates through number of times and stores a character into the string array.
    for (i = 0; i <= number; i++)
    {
        scanf("%c", &characters);
        string[i] = characters;
    }
    
    // Scans the last letter and I have used a regular expression (found on the internet) to ensure that the whitespace is not included.
    scanf("%*[ \n\t]%c", &letter);
    
    // Loops through starting from 1 as I know string[0] will have a whitespace/'\n' as the element. Still loops through number amount of times. Checks if the element at that position is the same letter as the end letter and if it is it places a 1 instead.
    for (i = 1; i <= number; i++)
    {
        if (string[i] == letter)
        {
            string[i] = '1';
        }
        
        else {}
    }
    
    // Another loop which checks which elements now have the number 1. If they do, do not print. If they don't, print what's in that array element. Again j = 1 as string[0] will have whitespace stored.
    for (j = 1; j <= number; j++)
    {
        if (string[j] != '1')
        {
            printf("%c",string[j]);
        }
        
        else
        {}
    }

}

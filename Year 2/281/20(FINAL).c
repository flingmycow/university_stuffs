//
//  20.c
//  Multiple String Program - #20 of Assignment 2
//  COMP281 - Principles of C & Memory Management
//
//  Created by Fumiko Saito on 2/29/2014.
//  Copyright (c) 2014 Fumi Saito. All rights reserved.

#include <stdio.h>

// To remove warnings about strlen
#include <string.h>

int main()
{
    
    /* Declare variables and array to be used to store integers */
    int i, value, stop = 100;
    char word[5001];
    char array[5001];
    
    printf("Enter the main string phrase to be matched \n");
    fgets(word, 5001, stdin);
    
    /* If string is < 5 and greater than 5000 then ask user to input a string that fits the requirements */
    while ( strlen(word) < 6 || strlen(word) > 5000 )
    {
        printf("Please enter a string that's greater than 5 characters long\n");
        fgets(word, 5001, stdin);
    }
    
    /* Constantly takes in the strings and stops the loop when the user enters a blank line */
    printf("Now enter a bunch of strings on new lines, and enter a blank line to end input\n");
    for (i = 0; i < stop; i++)
    {
        fgets(array, 5001, stdin);
        
        /* Compares the value taken in by fgets. If the user enters a blank space then when compared to an empty string IE \n it should equal 0. If that's the case, make stop = i to terminate the loop.*/
        if (strcmp(array,"\n") == 0)
        {
            stop = i;
        }
        
        /* If the string taken in doesn't satisfy the first IF statement then move onto the ELSE IF statement which determines if the original string and the most recently inputted string are the same. If they are equal then strcmp should return 0. If that's the case, increment value by one. */
        else if (strcmp(word, array) == 0)
        {
            value++;
        }
        
        else{}
    }
    
    /* After all the loops, prints out the value of 'value' which is the number of strings that did match to the original string. */
    printf("%d", value);
}
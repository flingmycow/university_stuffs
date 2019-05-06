//
//  23.c
//  Minesweeper - #23 of Assignment 2
//  COMP281 - Principles of C & Memory Management
//
//  Created by Fumiko Saito on 3/03/2014.
//  Copyright (c) 2014 Fumi Saito. All rights reserved.

#include <stdio.h>
#include <stdlib.h>

int main()
{
    // Declaring the variables to be used including array where the size is determined by user input and this is achieved using malloc. Also array is a pointer to pointers.
    int i, j, x, y, xCord, yCord, numMines;
    int value = 0;
    int mine = 10;
    int **array;
    
    printf("Enter a value for x and y\n");
    scanf("%d %d", &x, &y);
    
    if (x > 100000 || y > 100000 || x == 0 || y == 0)
    {
        printf("Enter values that's greater than 0 and less than 100000");
        scanf("%d %d", &x, &y);
    }
    
    // Just to allocate extra room on the board.
    x = x + 2;
    y = y + 2;
    
    // Allocating memory y * 2 or 4 bytes for an int. This is for the rows of the array.
    array = malloc(y * sizeof(int *));
    
    // Dynamically allocating the columns of the 2d array for y/row times.
    for(i = 0; i < y; i++)
    {
        array[i] = malloc(x * sizeof(int));
    }
    
    // Getting the number of mines the user wants to put in the program.
    printf("Enter the number of mines\n");
    scanf("%d", &numMines);
    
    // Taking in the coordinates of the mines.
    printf("Now enter the coordinates of the mines with x first.\n");
    
    for (i = 0; i < numMines; i++)
    {
        scanf("%d %d", &xCord, &yCord);
        
        // If the coordinate inputted are outside of the grid, ask user to input valid values. Once proper values are inputted then the mines are recorded by placing a number 10 in the element at the correct position.
        if (xCord > (x - 2) || yCord > (y - 2))
        {
            printf("Cannot place a mine outside the board. Please re-enter coordinates\n");
            scanf("%d %d", &xCord, &yCord);
            array[xCord][yCord] = mine;
        }
        
        else
        {
            array[xCord][yCord] = mine;
        }
    }
    
    // Asks user to input coordinates to see if there's a mine located at it. If not, how many are near it.
    printf("Enter some coordinates (x y) \n");
    scanf("%d %d", &xCord, &yCord);
    
    // If the coordinates entered has a '10' in it, then return "HIT".
    if (array[xCord][yCord] == 10)
    {
        printf("HIT!\n");
    }
    
    // Check the 8 'squares' around it to see if there are any mines in them. If so, increment value.
    else
    {
        for (i = (xCord - 1); i <= (xCord + 1); i++)
        {
            for (j = (yCord - 1); j <= (yCord + 1); j++)
            {
                if (array[i][j] == 10)
                {
                    value++;
                }
                
                else{}
            }
        }
        
        // The 'value' is the number of mines located near the user's coordinates if it isn't a match/HIT.
        printf("%d \n", value);
    }
    
}
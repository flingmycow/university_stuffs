//
//  33.c
//  3D Minesweeper - #33 of Assignment 3
//  COMP281 - Principles of C & Memory Management
//
//  Created by Fumiko Saito on 3/15/2014.
//  Copyright (c) 2014 Fumi Saito. All rights reserved.

#include <stdio.h>
#include <stdlib.h>

int main()
{
    // Declaring the variables to be used. Haven't declared an array this time.
    int i, j, x, y, z, xCord, yCord, zCord, numMines;
    
    printf("Enter a value for x, y and z\n");
    scanf("%d %d %d", &x, &y, &z);
    
    while (x > 100000 || y > 100000 || z > 100000 || x == 0 || y == 0 || z == 0)
    {
        printf("Enter values that's greater than 0 and less than 100000\n");
        scanf("%d %d %d", &x, &y, &z);
    }
    
    // Just to allocate extra room on the board.
    x = x + 2;
    y = y + 2;
    z = z + 2;
    
    // Allocating memory by using an array of pointers to an array of pointers to an array
    int *** array = (int ***)malloc(x * sizeof(int **));
    
    for(i = 0; i < y; i++)
    {
        array[i] = (int **)malloc(y * sizeof(int *));
        
        for (j = 0; j < z; j++)
        {
            array[i][j] = (int *) malloc(z * sizeof(int));
        }
    }
    
    // Getting the number of mines the user wants to put in the program.
    printf("Enter the number of mines\n");
    scanf("%d", &numMines);
    
    // Taking in the coordinates of the mines.
    printf("Now enter the coordinates of the mines with x first.\n");
    
    for (i = 0; i < numMines; i++)
    {
        scanf("%d %d %d", &xCord, &yCord, &zCord);
        
        // If the coordinate inputted are outside of the grid, ask user to input valid values. Once proper values are inputted then the mines are recorded by placing a number 10 in the element at the correct position.
        if (xCord > (x - 2) || yCord > (y - 2) || zCord > (z - 2))
        {
            printf("Cannot place a mine outside the board. Please re-enter coordinates\n");
            scanf("%d %d %d", &xCord, &yCord, &zCord);
        }
        
        else{}
        
        // If the array at these coordinates have a value in them already then increment that value by 1
        if (array[xCord][yCord][zCord] != 0)
        {
            array[xCord][yCord][zCord] += 1;
        }
        
        // Otherwise plant a '1' in that spot.
        else
        {
            array[xCord][yCord][zCord] = 1;
        }
    }
    
    // Asks user to input coordinates to see if there's a mine located at it. If not, how many are near it.
    printf("Enter some coordinates (x y z) \n");
    scanf("%d %d %d", &xCord, &yCord, &zCord);
    
    // Checks if the coordinates at that spot has any integer values which represent the number of mines.
    if (array[xCord][yCord][zCord] >= 0)
    {
        printf("%d", array[xCord][yCord][zCord]);
    }
}
//
//  31.c
//  Price Sorting List - #31 of Assignment 2
//  COMP281 - Principles of C & Memory Management
//
//  Created by Fumiko Saito on 3/10/2014.
//  Copyright (c) 2014 Fumi Saito. All rights reserved.

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Creating a struct called Items. Each item requires a title of 100 character's or less and a price which I have made as a float to include decimal places.
typedef struct
{
    char title[101];
    float price;
    
} items;

// To compare the prices of the items in the list.
int compare_price(items *a, items *b)
{
    // If a is smaller than b return -1
    if (a->price < b->price)
    {
        return -1;
    }
    
    // If a is larger than b return 1
    else if (a->price > b->price)
    {
        return 1;
    }
    
    // If they are equal return 0
    else
    {
        return 0;
    }
}

int compare_title(items *x, items *y)
{
    // If x is smaller than y return -1
    if (strcmp(x->title, y->title) < 0)
    {
        return -1;
    }
    
    // If x is larger than y return 1
    else if (strcmp(x->title,y->title) > 0)
    {
        return 1;
    }
    
    // If they are equal return 0
    else
    {
        return 0;
    }
}

int main()
{
    // Declaring variables including an array of the struct items.
    items item_info[100];
    int n, i;
    int number;
    
    printf("Enter an integer\n");
    scanf("%d", &number);
    
    // Integer entered cannot exceed 500000 or be 0.
    while (number > 500000 || number <= 0)
    {
        printf("Please enter a number between 1 - 500000");
        scanf("%d", &number);
    }
    
    // Takes in user input for the items and their prices.
    printf("Enter %d items and their prices\n", number);
    for (n = 0; n < number; n++)
    {
        scanf("%s %f", item_info[n].title, &item_info[n].price);
        
        // If the price is higher than 1000, re-enter a valid number.
        if (item_info[n].price > 1000)
        {
            printf("Enter a value that's less than 1000\n");
            scanf("%f", &item_info[n].price);
        }
        
        else
        {}
    }
    
    // To sort the items in the list by alphabetical order first
    qsort (&item_info, number, sizeof(items), compare_title);
    printf("\n");
    
    // To sort the items of the same name by their price
    // So if title1 = title2 then carry out qsort otherwise iterate through again
    // FOR some reason it wont sort one item name...
    for (i = 0; i <= number; i++)
    {
        if (strcmp(item_info[i+1].title, item_info[i+2].title) == 0)
        {
            qsort (&item_info, i, sizeof(items), compare_price);
        }
        
    }
    
    printf("\n");
    for (n = 0; n < number; n++)
    {
        printf("%s %.2f\n", item_info[n].title, item_info[n].price);
    }
}
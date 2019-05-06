//
//  21.c
//  Price Lookup - #21 of Assignment 2
//  COMP281 - Principles of C & Memory Management
//
//  Created by Fumiko Saito on 2/31/2014.
//  Copyright (c) 2014 Fumi Saito. All rights reserved.

#include <stdio.h>
#include <string.h>

// Creating a struct called Items. Each item requires a title of 100 character's or less and a price which I have made as a float to include decimal places.
struct items
{
    char title[101];
    float price;
    
};

int main()
{
    // Declaring variables including an array of the struct items.
    struct items item_info[11];
    int n, j, count;
    int total = 0;
    
    printf("Enter 10 items and their prices\n");
    for (n = 0; n < 11; n++)
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
    
    for (j = 0; j < 10; j++)
    {
        // If strings are the same then = 0
        count = strcmp(item_info[10].title, item_info[j].title);
        
        if (count == 0)
        {
            // If the price of the item at point j in the list is less than the budget value, increment total by 1.
            if (item_info[j].price < item_info[10].price)
            {
                total++;
            }
            
            else{}
        }
        else {}
    }
    
    // Prints the total number of items of the required type that costs no more than the budget value.
    printf("%d\n", total);
    
}
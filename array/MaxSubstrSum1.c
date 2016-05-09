/*
 * =====================================================================================
 *
 *       Filename:  MaxSubstrSum1.c
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  05/08/2016 08:25:52 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  YOUR NAME (), 
 *   Organization:  
 *
 * =====================================================================================
 */
#include <stdlib.h>
#include <stdio.h>

int MaxSubArray(int *a, int n){
    int currSum = 0;
    int maxSum = 0;
    int j;
    for(j = 0; j < n; ++j){
        if(currSum >= 0){
            currSum += a[j];
        }
        else
            currSum = a[j];
        if(currSum > maxSum)
            maxSum = currSum;
    }
    return maxSum;
}

int main(void){
    int arr[] = {1, -2, 3, 10, -4, 7, 2, -5};
    int max = MaxSubArray(arr, 8);
    printf("%d\n", max);
    return 0;
}

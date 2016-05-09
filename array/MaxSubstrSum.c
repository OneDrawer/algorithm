/*
 * =====================================================================================
 *
 *       Filename:  MaxSubstrSum.c
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  05/08/2016 07:53:22 PM
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
#include <string.h>

int MaxSubArray(int *A, int n){
    int maxSum = A[0];
    int currSum = 0;
    int i, j, k;
    for(i = 0; i < n; ++i){
        for(j = i; j < n; ++j){
            for(k = i; k <= j; ++k){
                currSum += A[k];
            }
            if(currSum > maxSum)
                maxSum = currSum;
            currSum = 0;
        }
    }
    return maxSum;
}

int main(void){
    int arr[] = {1, -2, 3, 10, -4, 7, 2, -5};
    int max = MaxSubArray(arr, 8);
    printf("%d\n", max);
    return 0;
}

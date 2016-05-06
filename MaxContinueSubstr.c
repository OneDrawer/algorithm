/*
 * =====================================================================================
 *
 *       Filename:  MaxContinueSubstr.c
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  05/06/2016 12:15:38 AM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  YOUR NAME (), 
 *   Organization:  
 *
 * =====================================================================================
 */
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
void *MaxContinueSubstr(char *s){
    int i = 0;
    int Max = 0;
    int k = 1;
    int n = strlen(s);
    while(i < n){
        if(s[i] == s[i+1]){
            k++;
        }
        else{
            if(k > Max)
                Max = k;
            k = 1;
        }
        ++i;
    }
    printf("%d\n",Max);    
}
int main(){
    char *str = "fdsdfffffffffffjklllll";
    MaxContinueSubstr(str);
    return 0;
}

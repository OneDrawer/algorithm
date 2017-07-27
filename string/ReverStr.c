#include <stdlib.h>
#include <string.h>
#include <stdio.h>

char *RerverStr(char *s, size_t len){
    char *start = s;
    char *end = s + len - 1;
    char ch = '\0';
    if(s){
        while(start < end){
            ch = *start;
            *(start++) = *end;
            *(end--) = ch;
        }
    }
    return s;
}

int main(){
    char *str;
    scanf("%s", str);
    size_t n = strlen(str);
    RerverStr(str, n);
    printf("%s\n", str);
    return 0;
}

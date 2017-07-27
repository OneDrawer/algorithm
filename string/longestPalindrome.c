char* longestPalindrome(char* s) {
    int n = strlen(s);
    if(s == 0 || n < 1)
        return NULL;
    int max, start = 0;
    //i为回文的中心位置
    max = 1;
    for(int i = 0; i < n; ++i){
        int begin = i;
        int end = i;
        for(; end < n && s[end] == s[end+1]; ++end)
            ;//具有相同的字母序列
        for (; begin > 0 && end < n && s[begin-1] == s[end+1]; --begin, ++end)
            ;
        if(end-begin+1 > max){
            start = begin;
            max = end-begin+1;
        }
        
    }
    char *substr = (char *)malloc(sizeof(char)*(max+1));
    int k = 0;
    for(; k < max; ++k){
        substr[k] = s[start++];
    }
    substr[k] = '\0';
    return substr;
}

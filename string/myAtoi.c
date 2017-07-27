int myAtoi(char* str) {
    int result = 0;
    bool isnegative = false;
    while((*str == ' ') || (*str == '0'))//丢弃前面的空白符和0
        str++;
    if(*str == '-'){
        isnegative = true;
        str++;
    }
    else{
        if(*str == '+')
            str++;
    }
    while(*str != '\0'){
        if((*str - '0') < 0 || (*str - '0') > 9)
            return isnegative? (-result):(result);
        if(result > (INT_MAX/10))
            return isnegative? (INT_MIN):(INT_MAX);
        result *= 10;
        if((*str -'0') > (INT_MAX - result))//这里要注意式子溢出
            return isnegative? (INT_MIN):(INT_MAX);
        result += *str - '0';
        str++;
    }
    return isnegative? (-result):(result);
}

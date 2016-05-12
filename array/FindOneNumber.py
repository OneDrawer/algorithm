def FindOneNumber(a, l):
    candidate = a[0]
    nTimes = 1
    i = 1
    while i < l:
        if nTimes == 0:
            candidate = a[i]
            nTimes = 1
        else:
            if candidate == a[i]:
                nTimes += 1
            else:
                nTimes -= 1
        i += 1
    return candidate

arr = [1,5,2,5,5,5,3,4,5,6,5,7,5,9,10,5,5,3,5,7,5,99,5,34,5]
Number = FindOneNumber(arr, len(arr))
print Number

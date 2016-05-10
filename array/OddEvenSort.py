def IsOddNumber(x):
    if (x & 1) == 1:
        return True
    else:
        return False

def OddEvenSort(data):
    i = -1
    j = 0
    high = len(data) - 1
    while j < high:
        if IsOddNumber(data[j]):
            i += 1
            tmp = data[i]
            data[i] = data[j]
            data[j] = tmp
        j += 1
    tmp = data[i + 1]
    data[i+1] = data[j]
    data[j] = tmp
    return data

da = [2,1,3,8,7,5,6,4,9,12,13,17,22,44,100,33]
d = OddEvenSort(da)
print d

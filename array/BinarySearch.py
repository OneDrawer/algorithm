def BinarySearch(arr, n, value):
    left = 0
    right = n - 1
    while left <= right:
        middle = left + ((right - left) >> 1)
        if arr[middle] > value:
            right = middle - 1
        else:
             if arr[middle] < value:
                left = middle + 1
             else:
                 return middle
    return -1

array = [1,3,4,6,8,9,12,14,19,23,34,36,74,88,99,123]
index = BinarySearch(array, len(array), 23)
print index

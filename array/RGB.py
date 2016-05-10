
def RGB(rgb):
    current = 0
    begin = 0
    end = len(rgb) - 1
    while current <= end:
        if rgb[current] == 0:
            tmp = rgb[current]
            rgb[current] = rgb[begin]
            rgb[begin] = tmp
            current += 1
            begin += 1
        else:
            if rgb[current] == 1:
                current += 1
            else:
                tmp = rgb[current]
                rgb[current] = rgb[end]
                rgb[end] = tmp
                end -= 1
    return rgb

rgb = [1,2,2,2,1,0,0,2,1,0,0,0,2,2,1,1,1,0,1,2,0,0,2,1,0,0,2,1,1,1,2,1,2,0,0,2,1]
r = RGB(rgb)
print r

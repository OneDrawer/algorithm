# -*- coding:utf-8 -*-

def ZipCompress(strs):
    ans = ""
    counter = 0
    tmp = strs[0]
    for ch in strs:
        if ch == tmp:
            counter += 1
        else:
            if counter == 1:
                ans += str(tmp)
            else:
                ans += str(counter) + str(tmp)
            tmp = ch
            counter = 1
    if counter == 1:
        ans += str(tmp)
    else:
        ans += str(counter) + str(tmp)
    return ans

string = "aaaaaaaaaaffffffffffffddfdfadffffuuuuuu"
s = ZipCompress(string)
print s

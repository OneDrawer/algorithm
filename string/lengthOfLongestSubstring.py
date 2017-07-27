class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        Substr = []
        l = len(s)
        k = 0
        m = 0
        while k < l:
            if s[k] not in Substr:
                Substr.append(s[k])
                k += 1
            else:
                if len(Substr) > m:
                    m = len(Substr)
                index = Substr.index(s[k])
                Substr = Substr[index + 1:]
                Substr.append(s[k])
                k += 1
        if len(Substr) > m:
            m = len(Substr)
        return m

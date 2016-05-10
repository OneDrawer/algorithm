/*--摘自http://blog.csdn.net/morewindows/article/details/7370155*/

//全排列的非递归实现

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void Swap(char *a, char *b)
{
	char t = *a;
	*a = *b;
	*b = t;
}
//反转区间
void Reverse(char *a, char *b)
{
	while (a < b)
		Swap(a++, b--);
}
//下一个排列
bool Next_permutation(char a[])
{
	char *pEnd = a + strlen(a);
	if (a == pEnd)
		return false;
	char *p, *q, *pFind;
	pEnd--;
	p = pEnd;
	while (p != a)
	{
		q = p;
		--p;
		if (*p < *q) //找降序的相邻2数,前一个数即替换数
		{
			//从后向前找比替换点大的第一个数
			pFind = pEnd;
			while (*pFind <= *p)
				--pFind;
			//替换
			Swap(pFind, p);
			//替换点后的数全部反转
			Reverse(q, pEnd);
			return true;
		}
	}
	Reverse(p, pEnd);//如果没有下一个排列,全部反转后返回true
	return false;
}
int QsortCmp(const void *pa, const void *pb)
{
	return *(char*)pa - *(char*)pb;
}
int main()
{
	printf("         全排列的非递归实现\n");
	printf("  --by MoreWindows( http://blog.csdn.net/MoreWindows )--\n\n");
	char szTextStr[] = "abc";
	printf("%s的全排列如下:\n", szTextStr);
	//加上排序
	qsort(szTextStr, strlen(szTextStr), sizeof(szTextStr[0]), QsortCmp);
	int i = 1;
	do{
		printf("第%3d个排列\t%s\n", i++, szTextStr);
	}while (Next_permutation(szTextStr));
	return 0;
}

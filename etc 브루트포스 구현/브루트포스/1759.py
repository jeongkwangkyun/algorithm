# 암호 만들기
# 리스트 -> 문자열 만드는게 쫌 빡셌음
import sys
from itertools import combinations

input=sys.stdin.readline

l,c=map(int,input().split())

lst_str=list(map(str,input().split()))

mo_lst=['a','e','i','o','u']

small_lst=[]
big_lst=[]
# 자, 모 판단

for i in lst_str:
    flag=False
    for j in mo_lst:
        if i==j:
            flag=True
    if flag==True:
        small_lst.append(i)
    else:
        big_lst.append(i)
total=[]
for i in range(2,l):
    big_tmp=list(combinations(big_lst,i))
    small_tmp=list(combinations(small_lst,l-i))

    
    for j in big_tmp:
        a=list(j)
        for k in small_tmp:
            b=list(k)
            tmp=a+b
            tmp.sort()
            s=','.join(tmp)
            s.replace(',','')
            total.append(s)
                
total.sort()
for i in total:
    print(i.replace(',',''))
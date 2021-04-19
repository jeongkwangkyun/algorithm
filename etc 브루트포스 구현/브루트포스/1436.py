# 영화감독 숌
# 브루트포스 문제로 666시리즈 n번째 구하는거
# 문제는 어렵지 않았으나 이해하는데 시간이 걸림...

import sys
input=sys.stdin.readline

n=int(input())
lst=[]
index=0

for i in range(666,sys.maxsize):
    if index==10001:
        break
    cnt=0
    word=str(i)
    for j in range(1,len(word)):
        if word[j]==word[j-1] and word[j]=='6':
            cnt+=1
            if cnt==2:
                lst.append(word)
                index+=1
                break
        else:
            cnt=0

print(lst[n-1])
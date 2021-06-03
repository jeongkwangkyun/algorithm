# 단어 수학
# 흠 딕셔너리랑 리스트를 이용해서 쓰는건 눈치챘는데
# 단어별 자릿수로 abcde 면 a를 10000 b를 1000 하고 높은 숫자부터 9,8,7... 곱해서 더해주면 됨
import sys
input=sys.stdin.readline

n=int(input())
word_lst=[input().rstrip() for _ in range(n)]

ans=0

dic={}

for words in word_lst:
    cnt=len(words)
    for word in words:
        if word not in dic:
            dic[word]=(10**(cnt-1))
        else:
            dic[word]+=(10**(cnt-1))
        cnt-=1
# 딕셔너리 자릿수 값 뽑고 정렬
values_lst=list(dic.values())
values_lst.sort()
values_lst.reverse()
num=9

for i in values_lst:
    ans+=i*num
    num-=1    
print(ans)
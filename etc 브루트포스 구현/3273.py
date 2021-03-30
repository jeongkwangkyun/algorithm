n = int(input())

plus_num=list(map(int,input().split()))
plus_num.sort()

x=int(input())

count=0

start=0
end=len(plus_num)-1

while start != end:
    if plus_num[start]+plus_num[end]==x:
        count+=1
        start+=1
    elif plus_num[start]+plus_num[end]>x:
        end-=1
    else:
        start+=1

print(count)
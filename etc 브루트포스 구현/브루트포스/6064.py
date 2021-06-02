# 카잉달력
# 중국인의 나머지 정리
# m*n+1 까지 범위를 정하고 x부터 시작해서 m 씩 증가하므로 앞에 값은 무조건 성립 뒤에꺼 나머지만 조건문 걸어주기
import sys
input=sys.stdin.readline

tc=int(input())

for i in range(tc):
    m,n,x,y= map(int,input().split())
    x,y=x-1,y-1
    ans=-1
    for i in range(x,m*n+1,m):
        if i%n==y:
            ans=i+1
            
            break
    print(ans)
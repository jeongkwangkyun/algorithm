# 퇴사
# dp 보텀업 상향식
# max pay를 테이블로 써서 해당값 저장
import sys
input=sys.stdin.readline

N=int(input())

max_pay=[0]*N

workday=[list(map(int,input().split())) for _ in range(N)]

for i in range(N-1, -1, -1): #뒤에서부터  다이나믹 프로그래밍
    day = workday[i][0]
    pay = workday[i][1]
    
    if day > N - i: #남은 기간보다 상담일이 길 경우
        if i != N-1:  
            max_pay[i] = max_pay[i+1] #이전 최댓값 저장
        continue
        
    if i == N-1: #마지막 날 하루짜리 상담
        max_pay[i] = pay #뒤에서부터 비교해주므로 다른거 비교값 X

    elif i + day == N: #현재 일을 시작하면 정확히 마지막에 끝나는 경우
        max_pay[i] = max(pay, max_pay[i+1])
    else:
        #현재 일을 맡을 경우 or 맡지 않을 경우
        max_pay[i] = max(pay + max_pay[i + day], max_pay[i+1])

print(max_pay[0])

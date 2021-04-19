# 체스판 다시 칠하기 BF
# for문 접근은 비슷한데 B,W로 시작하는 그래프 생각을 못해서 너무 돌아가다가 못함
#

import sys

input=sys.stdin.readline

n,m=map(int,input().split())
graph=[list(map(str,input().rstrip())) for i in range(n)]
cnt=64

start_B = [['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], 
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], 
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], 
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], 
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B']]

start_W = [['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], 
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], 
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], 
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
           ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], 
           ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W']]

# 자를 보드 생각해서 -7씩
for i in range(n-7):
    for j in range(m-7):
        count1=0
        count2=0
        # 전체 보드를 바탕으로 8*8로 자름
        for x in range(8):
            for y in range(8):
                if graph[i+x][j+y]==start_B[x][y]:
                    count1+=1
                if graph[i+x][j+y]==start_W[x][y]:
                    count2+=1
        cnt=min(cnt,count1,count2)
print(cnt)
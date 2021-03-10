# 뱀
# 처음에 bfs 인줄알고 풀으려했다가 그냥 구현 문제
#
from collections import deque
import sys
input=sys.stdin.readline

n=int(input())
graph=[[0]*n for _ in range(n)]
queue=deque() # 뱀의 방향 변환 정보 담는곳

dx=[0,-1,0,1]
dy=[1,0,-1,0]
snake_queue=deque() #뱀의 현재 머리부터 몸까지의 위치를 담아놓는곳

k=int(input())
for _ in range(k):
    x,y=map(int,input().split())
    graph[x-1][y-1]=1

l=int(input())
for _ in range(l):
    x,y=map(str,input().split())
    x=int(x)
    queue.append([x,y])

def search(x,y):
    time_cnt=0
    snake_queue.append([x,y])
    d=0 
    time_X,time_C=queue.popleft()
    while 1:
        nx=x+dx[d]
        ny=y+dy[d]
        for i in range(len(snake_queue)):
            if nx==snake_queue[i][0] and ny==snake_queue[i][1]:
                # 다음 nx , ny 값을 비교해주는 것이므로 +1
                print(time_cnt+1)
                sys.exit()

        if 0>nx or nx>=n or 0>ny or ny>=n:
            print(time_cnt+1)
            sys.exit()

        elif graph[nx][ny]==1:
            graph[nx][ny]=0  # 사과를 먹으면 다시 0으로 바꿔줘야한다 테스트 케이스에서 재방문 하는 케이스 있어서 틀림
            snake_queue.appendleft([nx,ny])
        
        elif graph[nx][ny]==0:
            snake_queue.appendleft([nx,ny])
            snake_queue.pop()

        time_cnt+=1

        # 방향 바꿔주는 파트
        if time_X==time_cnt:
            if time_C=='L':
                d=d+1
                if d==4:
                    d=0
                
            elif time_C=='D':
                d-=1
                if d==-1:
                    d=3
            if len(queue)==0:
                pass
            else:
                time_X,time_C=queue.popleft()

        x=nx
        y=ny        

search(0,0)
# 플로이드 워셜 n^3 , 
# 다익스트라도 가능 -> 다익스트라는 출발점이 정해진 알고리즘이라 s,a,b과의 거리 비용과 dp를 따로 만들어서 비교해줘야함
# s,a,b 중 가장 가까운 지점을 고르는 문제

#지점갯수
n=6
#출발지점
s=4
#a 목표
a=6
#b 목표
b=2
# x와 y 사이의 요금
fares=[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]	


def solution(n, s, a, b, fares):
    
    graph=[[1000001]*n for _ in range(n)]
    
    for i in range(n):
        graph[i][i]=0

    for x,y,cost in fares:
        graph[x-1][y-1]=cost
        graph[y-1][x-1]=cost
    
    for i in range(n):
        for j in range(n):
            for k in range(n):
                if graph[j][i] + graph[i][k] < graph[j][k]:
                    graph[j][k] = graph[j][i] + graph[i][k]
    
    return min([graph[i][s-1]+graph[i][a-1]+graph[i][b-1] for i in range(n)])
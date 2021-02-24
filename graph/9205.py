import sys

INF=sys.maxsize
input=sys.stdin.readline
tc=int(input())

while tc:
    n=int(input())
    place=[list(map(int,input().split())) for _ in range(n+2)]
    d=[[INF]*(n+2) for _ in range(n+2)]

    for i in range(n+2):
        for j in range(n+2):
            if i==j:
                continue
            temp_di=abs(place[i][0]-place[j][0])+abs(place[i][1]-place[j][1])

            if temp_di<=1000:
                d[i][j]=1

    for k in range(n+2):
        for a in range(n+2):
            for b in range(n+2):

                if d[a][b]>d[a][k]+d[k][b]:
                    d[a][b]=d[a][k]+d[k][b]

    if 0<=d[0][n+1]<INF:
        print('happy')
    else:
        print('sad')
    tc-=1
import sys
input=sys.stdin.readline

def main():
    TC=int(input())

    for i in range(TC):
        N=int(input())
        graph=[[0]*5 for _ in range(5)]
        for j in range(N):
            x,y,dic=list(map(str,input().split()))
            if dic=='E':
                graph[int(x)-1][int(y)-1]=(j,'E')
                graph[int(x)-1][int(y)-2]=(j,'E')
            elif dic=='S':
                graph[int(x)-1][int(y)-1]=(j,'S')
                graph[int(x)-2][int(y)-1]=(j,'S')
            elif dic=='N':
                graph[int(x)-1][int(y)-1]=(j,'N')
                graph[int(x)][int(y)-1]=(j,'N')
            elif dic=='W':
                graph[int(x)-1][int(y)-1]=(j,'W')
                graph[int(x)-1][int(y)]=(j,'W')

    
main()
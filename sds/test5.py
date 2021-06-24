import sys

input=sys.stdin.readline
def main():
    TC=int(input())
    for i in range(TC):
        n,k=map(int,input())
        graph =[[0]*1000000000 for _ in range(1000000000)]

        for _ in range(n):
            x,y,jewely=map(int,input().split())
            graph[x][y]=jewely
            
                        
main()
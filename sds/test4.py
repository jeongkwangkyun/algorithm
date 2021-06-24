import sys

input=sys.stdin.readline
def main():
    TC=int(input())

    for i in range(TC):
        y,x=map(int,input().split())
        graph=[]
        for j in range(x):
            lst=list(input())
            lst.pop()
            lst=list(map(int,lst))
            graph.append(lst)
        min_total=sys.maxsize

        for x_line in range(x):
            total_tmp=0
            for y_now in range(y):
                y_plus=sys.maxsize
                for x_now in range(x):
                    y_tmp=sys.maxsize     
                    if graph[x_now][y_now]==1:
                        y_tmp=min(abs(x_line-x_now),y_tmp)
                        y_tmp=min(x-x_now+x_line,y_tmp)
                    
                    y_plus=min(y_plus,y_tmp)
                total_tmp+=y_plus

            min_total=min(min_total,total_tmp)
        
        print('#'+str(i+1)+' '+str(min_total))    
                        
main()
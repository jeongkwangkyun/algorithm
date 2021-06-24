import sys
from collections import deque

input=sys.stdin.readline

def main():
    tc=int(input())
    
    for i in range(tc):
        n=int(input())
        time=0
        left_lst=deque()
        right_lst=list(map(int,input().split()))
        right_lst.sort()
        right_lst=deque(right_lst)
        if n<=2:
            time+=right_lst.pop()
        else:
            while len(right_lst)!=0:
                if n%2==0:
                    first=right_lst.popleft()
                    second=right_lst.popleft()
                    time+=first
                    time+=second
                    left_lst.append(second)
                    right_lst.appendleft(first)
                    if len(right_lst)==3:
                        time+=right_lst.pop()
                        time+=(left_lst.popleft()*2)
                        break
                    top=right_lst.pop()
                    top_2=right_lst.pop()
                    time+=top
                    left_lst.append(top_2)
                    left_lst.append(top)
                    first=left_lst.popleft()
                    time+=first
                    right_lst.appendleft(first)
                else:
                    if len(right_lst)==3:
                        top=right_lst.pop()
                        top_2=right_lst.pop()
                        time+=top
                        left_lst.append(top_2)
                        left_lst.append(top)
                        return_cnt=left_lst.popleft()
                        time+=(return_cnt*2)

                        break
                    first=right_lst.popleft()
                    second=right_lst.popleft()
                    time+=first
                    time+=second
                    left_lst.append(second)
                    right_lst.appendleft(first)
                    top=right_lst.pop()
                    top_2=right_lst.pop()
                    time+=top
                    left_lst.append(top_2)
                    left_lst.append(top)
                    first=left_lst.popleft()
                    time+=first
                    right_lst.appendleft(first)
                
        print('#'+str(i+1)+' '+str(time))    
        

main()
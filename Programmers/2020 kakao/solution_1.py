numbers=[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	
hand="left"	
from collections import deque

answer=''
graph=[[1,2,3],[4,5,6],[7,8,9],['*',0,'#']]
left_x,left_y=3,0
right_x,right_y=3,2
dx=[0,0,1,-1]
dy=[1,-1,0,0]

def find(lx,ly,number):
    l_dis=0
    queue_l=deque()
    queue_l.append((lx,ly))
    check_l=[[-1]*3 for i in range(4)]
    target_x=5
    check_l[lx][ly]+=1
    while queue_l:
        x,y=queue_l.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<=3 and 0<=ny<=2:
                if graph[nx][ny]==number and check_l[nx][ny]==-1:
                    check_l[nx][ny]=check_l[x][y]+1
                    target_x=nx
                    target_y=ny
                    break
                elif check_l[nx][ny]==-1:
                    check_l[nx][ny]=check_l[x][y]+1
                    queue_l.append((nx,ny))
                
        if target_x!=5:
            l_dis=check_l[target_x][target_y]
            break
    return l_dis

for i in numbers:
    if i==1 :
        left_x=0
        left_y=0
        answer=answer+'L'
    elif i==4:
        left_x=1
        left_y=0
        answer=answer+'L'
    elif i==7:
        left_x=2
        left_y=0
        answer=answer+'L'
    elif i==3:
        right_x=0
        right_y=2
        answer=answer+'R'
    elif i==6:
        right_x=1
        right_y=2
        answer=answer+'R'
    elif i==9:
        right_x=2
        right_y=2
        answer=answer+'R'
    else:
        l_dis=find(left_x,left_y,i)
        r_dis=find(right_x,right_y,i)
        if l_dis>r_dis:
            ret_hand='R'
        elif l_dis<r_dis:
            ret_hand='L'
        elif l_dis==r_dis:
            if hand=='left':
                ret_hand='L'
            else:
                ret_hand='R'
        if i==2:
            target_x=0
            target_y=1
        elif i==5:
            target_x=1
            target_y=1
        elif i==8:
            target_x=2
            target_y=1
        elif i==0:
            target_x=3
            target_y=1

        if ret_hand=='L':
            left_x=target_x
            left_y=target_y
            answer=answer+'L'
        else:
            right_x=target_x
            right_y=target_y
            answer=answer+'R'
    
    
print(answer)
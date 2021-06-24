from collections import deque
places=[["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], 
["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], 
["PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"], 
["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], 
["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]

def find(graph):
    dx=[0,0,1,-1]
    dy=[1,-1,0,0]
    flag=True
    
    for x in range(5):
        for y in range(5):
            if graph[x][y]=='P':
                for i in range(4):
                    nx=x+dx[i]
                    ny=y+dy[i]
                    if 0<=nx<5 and 0<=ny<5:
                        if graph[nx][ny]=='P':
                            flag=False
                            return 0

            elif graph[x][y]=='O':
                P_cnt=0
                for i in range(4):
                    nx=x+dx[i]
                    ny=y+dy[i]
                    if 0<=nx<5 and 0<=ny<5:
                        if graph[nx][ny]=='P':
                            P_cnt+=1
                if P_cnt>=2:
                    return 0
    if flag==True:
        return 1



def solution(places):
    answer = []
    for i in places:
        for j in range(5):
            i[j]=list(i[j])
        answer.append(find(i))


    print(answer)


solution(places)
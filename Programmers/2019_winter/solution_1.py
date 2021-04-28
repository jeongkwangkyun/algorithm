board=[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
moves=[1,5,3,5,1,2,1,4]

answer = 0
tmp=[]
top=-1
n=len(board)
for i in moves:
    doll=0
    for j in range(n):
        if board[j][i-1]!=0:
            doll=board[j][i-1]
            board[j][i-1]=0
            break
    if doll==0:
        continue
    else:
        tmp.append(doll)
        top+=1
        if top>0:
            if tmp[-1]==tmp[-2]:
                tmp.pop()
                tmp.pop()
                top-=2
                answer+=2

        

print(answer)
import sys
input=sys.stdin.readline

n,m,h=map(int,input().split())

if m==0:
    print(0)
    sys.exit()

bridge=[[False]*n for _ in range(h)]
for _ in range(m):
    a,b=map(int,input().split())
    bridge[a-1][b-1]=True
# start는 처음 위치고 k는 사다리 타고 밑으로 내려갔을 때 위치
# 같으면 true 다르면 false
def check():
    for start in range(n):
        k=start
        for i in range(h):
            if bridge[i][k]:
                k+=1
            elif k>0 and bridge[i][k-1]:
                k-=1
            
        if start !=k:
            return False
    return True

def bf(cnt,x,y):
    global ans
    #check True면 cnt 와 ans 값 비교
    if check():
        ans=min(ans,cnt)
        return
    # cnt가 3개고 check 에서 안걸러졌으니 return
    elif cnt==3 or ans<cnt:
        return
    # 재귀로 브루트포스 알고리즘 다리 3개까지만 true
    for i in range(x,h):
        k=y if i==x else 0
        for j in range(k,n-1):
            # i,j 와 i,j+1이 둘다 false면 i,j true
            if not bridge[i][j] and not bridge[i][j+1]:
                bridge[i][j]=True
                # +2 는 j와 j+1을 이어줘서
                bf(cnt+1,i,j+2)
                bridge[i][j]=False

ans=4
bf(0,0,0)
print(ans if ans<4 else -1)
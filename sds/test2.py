import sys
input=sys.stdin.readline
def main():
    tc=int(input())
    for k in range(tc):
        A,B,L=map(list,input().split())
        A= list(map(int,A))
        B= list(map(int,B))
        L= list(map(int,L))
        total=0
        value=list(map(str,input()))
        value.pop()
        minus=0
        if len(A)>len(B):
            minus=len(A)-len(B)
            for i in range(minus):
                B.insert(0,0)

        elif len(A)<len(B):
            minus=len(B)-len(A)
            for i in range(minus):
                A.insert(0,0)
        
        i=0
        sort_num=0
        
        while i!=len(A)-L[0]+1:
            cnt=B[i]-A[i]
            if value[0]=='+':
                flag=1
            elif value[0]=='-':
                flag=-1
            else:
                flag=0    
            
            if cnt>0 and flag==1:
                for j in range(len(value)):
                    val=value[j]
                    if val=='+':
                        if A[i+j]+cnt>=9:
                            A[i+j]=9
                        else :
                            A[i+j]+=cnt
                    elif val=='-':
                        if A[i+j]-cnt<=0:
                            A[i+j]=0
                        else:
                            A[i+j]-=cnt
                    else :
                        pass
                i+=1
                total+=abs(cnt)
                sort_num=0
            
            elif cnt<0 and flag==-1:
                for j in range(len(value)):
                    val=value[j]
                    if val=='+':
                        if A[i+j]-cnt>=9:
                            A[i+j]=9
                        else:
                            A[i+j]-=cnt
                    elif val=='-':
                        if A[i+j]+cnt<=0:
                            A[i+j]=0
                        else:
                            A[i+j]+=cnt
                    else :
                        pass
                i+=1
                total+=abs(cnt)
                sort_num=0
            else: 
                value.reverse()
                sort_num+=1
                if sort_num==2:
                    break


        print('#'+str(k+1),end=' ')
        if A!=B:
            print(-1)
        else:
            print(total)
    
    
main()
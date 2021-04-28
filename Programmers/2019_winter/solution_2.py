s="{{2},{2,1},{2,1,3},{2,1,3,4}}"	

answer=[]

s=s.replace('{','')
s=s.replace('},',' ')
s=s.replace('}','')
a=list(map(str,s.split()))
tmp=[]
for i in a:
    tmp.append(list(map(int,i.split(','))))

cnt=[[0]*2 for _ in range(len(tmp))]        

for i in range(len(tmp)):
    cnt[i][0]=len(tmp[i])
    cnt[i][1]=i
cnt.sort()

for i in range(len(cnt)):
    for j in tmp[cnt[i][1]]:
        flag=True
        for k in answer:
            if j==k:
                flag=False
                break
        if flag==True:
            answer.append(j)
            

print((answer))

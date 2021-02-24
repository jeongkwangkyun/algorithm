import sys
input=sys.stdin.readline

lst=list(map(str,input().strip().split('-')))
total=0
plus=[]
minus=[]
for i in range(len(lst)):
    if i==0:
        if str(lst[i])=='':
            continue
        plus.append((lst[i]).split('+'))
    else:
        minus.append((lst[i]).split('+'))
for i in range(len(plus)):
    for j in range(len(plus[i])):
        total+=int(plus[i][j])
        
for i in range(len(minus)):
    for j in range(len(minus[i])):
        total-=int(minus[i][j])
print(total)

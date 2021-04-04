import sys
input=sys.stdin.readline
s=set()

for i in range(int(input())):

    line=list(map(str,input().split()))
    if len(line)==1:
        l=line[0]
        if l=='all':
            s=set([i for i in range(1,21)])
        else:
            s=set()
        continue 

    x,l=line[1],line[0]
    x=int(x)

    if l == 'add':
        s.add(x)
            
    elif l == 'remove':
        s.discard(x)

    elif l=='check':
        print(1 if x in s else 0)

    elif l =='toggle':
        if x in s:
            s.discard(x)
        else:
            s.add(x)

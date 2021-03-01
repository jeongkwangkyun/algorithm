import sys
num=1

while 1:
    a=list(sys.stdin.readline().strip())
    if a[0]=='-':
        break
    
    stack=0
    cnt=0
    first=0
    second=0
    for i in range(len(a)):
    
        if stack==0 and a[i]=='}':
          cnt+=1
          first+=1
        elif a[i]=='}':
          second-=1
        elif a[i]=='{':
          first+=1
        
    print('{0}. {1}'.format(num,cnt+abs(first-second)/2))
    num+=1
a=int(input())
b=int(input())
c=int(input())
d=list(str(a*b*c))
total=[]
for i in range(10):
  total.append(0)


for i in range(len(d)):
    f=int(d[i])
    total[f]+=1

for i in range(10):
    print(total[i])
a=list(input())
b=list(input())

total=0

a_alpa=[]
b_alpa=[]

for num in range(26):
  a_alpa.append(0)
  b_alpa.append(0)

for i in range(len(a)):
  a[i]=ord(a[i])-97
  a_alpa[a[i]]+=1

for j in range(len(b)):
  b[j]=ord(b[j])-97
  b_alpa[b[j]]+=1


for x in range(26):
  if a_alpa[x]!=b_alpa:
    
    if a_alpa[x]>b_alpa[x]:
      for y in range(a_alpa[x]):
        if a_alpa[x]==b_alpa[x]:
          break
        a_alpa[x]-=1
        total+=1
    
    elif a_alpa[x]<b_alpa[x]:
      for z in range(b_alpa[x]):
        if a_alpa[x]==b_alpa[x]:
          break
        b_alpa[x]-=1
        total+=1


print(total)
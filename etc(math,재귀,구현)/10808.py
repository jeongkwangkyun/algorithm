a = input()

b=[]
for i in range(28):
  b.append(0)

for i in range(len(a)):
  num=ord(a[i])-97
  b[num]+=1

for i in range(26):
  print(b[i],end=' ')
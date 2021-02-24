final=[]
num=0
n,k=map(int,input().split())

arr=[i for i in range(1,n+1)]

for j in range(n):
  num+=k-1
  if num>=len(arr):
    num=num%len(arr)

  final.append(str(arr.pop(num)))
  
print("<"+", ".join(map(str,final))+'>')
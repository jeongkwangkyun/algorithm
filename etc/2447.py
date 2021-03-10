import sys
input=sys.stdin.readline

star=["***","* *","***"]
n=int(input())
k=0

def stars(star):
    matrix=[]
    for i in range(3*len(star)):
        if i//len(star)==1:
            matrix.append(star[i % len(star)] + " "*len(star) +star[i%len(star)])
        else:
            matrix.append(star[i%len(star)]*3)
    return(list(matrix))
while n!=3:
    n=int(n/3)
    k+=1

for i in range(k):
    star=stars(star)

for i in (star):
    print(i)
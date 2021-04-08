import sys
input=sys.stdin.readline

n=list(input().rstrip())

total=0
for i in range(len(n)):
    word=n.pop()

    if word=='A' or word=='B' or word=='C':
        total+=3
    elif word=='D' or word=='E' or word=='F':
        total+=4
    elif word=='G' or word=='H' or word=='I': 
        total+=5
    elif word=='J' or word=='K' or word=='L': 
        total+=6
    elif word=='M' or word=='N' or word=='O':
        total+=7
    elif word=='S' or word=='P' or word=='Q' or word=='R': 
        total+=8
    elif word=='V' or word=='T' or word=='U': 
        total+=9
    else:
        total+=10
print(total)
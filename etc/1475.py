num=list(input())

room=[]
for i in range(10):
  room.append(0)

for j in range(len(num)):
  if int(num[j])==9:
    room[6]+=1
  
  else:
    room[int(num[j])]+=1

max=0
for p in range(10):
  if max<room[p]:
    if p==6:
      continue
    else:
      max=room[p]

if room[6]%2==0:
  if max<room[6]//2:
    max=room[6]//2
else:
  if max<(room[6]//2)+1:
    max=(room[6]//2)+1 

print(max)
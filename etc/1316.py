# 그룹체커
n=int(input())
total=0

for i in range(n):
  word = input()

  for j in range(len(word)):
    if j!=len(word)-1:
      if word[j]==word[j+1]:
        pass
      elif word[j] in word[j+1:]: # aaabbbcccbbb 
        break                     # 이 예시처럼 if 에서 먼저 같은 경우는 걸러줬고 elif에서 b에서 c 넘어가는 구간에서 걸리며 다음 b에서 break
    else:
      total+=1

print(total)
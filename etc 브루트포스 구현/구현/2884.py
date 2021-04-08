# 알람시계
import sys
input=sys.stdin.readline

hour,minute=map(int,input().split())

if minute-45<0:
    if hour==0:
        hour=23
        
    else:
        hour-=1
    minute=minute+15

else:
    minute-=45
print(hour, minute)
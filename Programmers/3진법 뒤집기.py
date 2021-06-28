#프로그래머스 lv1
# 구현
# int로 함수가 3진수, 16진수 그냥 써줄수있는거

def solution(n):
    answer = 0
    lst=[]
    tmp=0
    while 1:
        if n<3:
            lst.append(n)
            break
        tmp=n%3
        lst.append(tmp)
        n=n//3
        
    
    for i in range(len(lst)):
        tmp=lst.pop()
        if i==0:
            answer+=tmp
        else:
            answer+=(3**(i)*tmp)
    return answer

def solution(n):
    answer = ''
    tmp=0
    while 1:
        if n<3:
            answer+=str(n)
            break
        tmp=n%3
        answer+=str(tmp)
        n=n//3
        
            
    return int(answer,3)
solution(n)
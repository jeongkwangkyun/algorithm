# 프로그래머스 카카오 기출
# 다트게임
# 구현(문자열 처리) 
# 고려사항 10점일 경우 -> tmp를 문자일 경우로 나눠서 받기

def solution(dartResult):
    tmp=''
    lst_idx=-1

    lst=[]
    dartResult=list(dartResult)
    for i in range(len(dartResult)):
        if dartResult[i]=='S':
            lst.append(int(tmp))
            lst_idx+=1
            tmp=''
        elif dartResult[i]=='D':
            lst.append(int(tmp)**2)
            lst_idx+=1
            tmp=''
        elif dartResult[i]=='T':
            lst.append(int(tmp)**3)
            lst_idx+=1
            tmp=''
        elif dartResult[i]=='*':
            if lst_idx==0:
                lst[lst_idx]*=2
            else:
                lst[lst_idx-1]*=2
                lst[lst_idx]*=2
        elif dartResult[i]=='#':
            lst[lst_idx]*=-1
        else:
            tmp+=dartResult[i]
            
    return sum(lst)

solution(dartResult)
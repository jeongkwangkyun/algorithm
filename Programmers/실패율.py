# 프로그래머스 lv1 (카카오기출이라 좀 어려움)
# 구현
# 알아가야할거 lambda로 정렬 쉽게하기,,, 기본 구현 능력

N=5
stages=[2,1,2,4,2,4,3,3]

def solution(N, stages):
    answer = []
    N_tmp=len(stages)
    lst=[[0,i+1] for i in range(N)]
    
    if N==1:
        answer.append(1)
    else:
        for i in range(1,N+1):
            if N_tmp==0:
                break
            tmp=i
            cnt=stages.count(tmp)
            if tmp>N:
                continue
            if lst[tmp-1][0]==0:
                lst[tmp-1][0]=(cnt)/N_tmp
                if cnt>=0:
                    N_tmp-=(cnt)
        
        # 인자값 첫번째를 -붙이면 먼저 내림차순 그후 뒤에꺼 오름차순
        lst.sort(key = lambda x: (-x[0], x[1]))
        
        for i in range(len(lst)):
            answer.append(lst[i][1])
    return answer

solution(N,stages)
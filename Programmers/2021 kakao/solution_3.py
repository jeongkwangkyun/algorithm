# 프로그래머스
# 순위검색
# 지원자 조건에 대해서 미리 참이 되는 모든 값을 넣고
# 이분 탐색으로 검색

info=["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]	
query=["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]	

from itertools import combinations
from collections import defaultdict

def solution(info, query):
    answer=[]
    
    # 지원자들 defaultdict 디폴트가 list
    applicant=defaultdict(list)

    # 16형태로 applicant에 딕셔너리 형태로 key는 문장 value는 점수

    for x in info:
        x=x.split()
        keylist=x[:-1]
        score=int(x[-1])
        for i in range(5):
            for c in combinations(keylist,i):
                key=''.join(c)
                applicant[key].append(score)
    
    # value 점수 정렬 -> 이분탐색 위해서
    for key in applicant.keys():
        applicant[key].sort()
    
    # 조건 parsing

    for x in query:
        q=[]
        x=x.split(' ')
        # and,'-'제외해서 
        for y in x:
            if y!='and' and y!='-':
                q.append(y)
        key=''.join(q[:-1])
        score=int(q[-1])

        count=0
        # 이분탐색으로 지원자수 구하기
        if key in applicant.keys():
            value=applicant[key]
            start,end=0,len(value)

            while start<=end and start<len(value):
                mid=(start+end)//2

                if value[mid]<score:
                    start=mid+1
                else:
                    end=mid-1

            count=len(value)-start
        
        answer.append(count)

solution(info, query)
# 프로그래머스


from itertools import combinations
from collections import Counter
orders=["XYZ", "XWY", "WXA"]			
course=[2,3,4]	


def solution(orders, course):
    answer = []
    for i in course:
        lst=[]
        for order in orders:
            order=list(order)
            order.sort()
            order=list(combinations(order,i))
            lst=lst+order
        counter=Counter(lst).most_common()
        
        cnt=0
        if len(counter)==0:
            continue 
        elif counter[0][1]>1:
            for index in range(1,len(counter)):
                if counter[index][1]==counter[index-1][1]:
                    cnt+=1
                else :
                    break
            
            if cnt==0:
                tmp="".join((counter[0][0]))
                answer.append(tmp)
            else:
                for j in range(cnt+1):
                    tmp="".join((counter[j][0]))
                    answer.append(tmp)
    answer.sort() 
    print(answer) 

solution(orders,course)
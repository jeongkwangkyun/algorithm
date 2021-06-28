# 프로그래머스 모의고사 lv1
# 구현 
# 완전탐색
answers=[1, 3, 2, 4, 2]

def solution(answers):
    answer = []
    man_1=[1,2,3,4,5]
    man_2=[2, 1, 2, 3, 2, 4, 2, 5]
    man_3=[3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ans_i=0
    index_1,index_2,index_3=0,0,0

    first=0
    second=0
    third=0
    max_ans=0
    while 1:
        if answers[ans_i]==man_1[index_1]:
            first+=1
        if answers[ans_i]==man_2[index_2]:
            second+=1
        if answers[ans_i]==man_3[index_3]:
            third+=1
        ans_i+=1
        index_1+=1
        index_2+=1
        index_3+=1

        if index_1==5:
            index_1-=5
        if index_2==8:
            index_2-=8
        if index_3==10:
            index_3-=10
        if ans_i==len(answers):
            break
    max_ans=max(first,second,third)
    
    if max_ans==first:
        answer.append(1)
    if max_ans==second:
        answer.append(2)
    if max_ans==third:
        answer.append(3)
    

    return answer
solution(answers)
v=[[1, 4], [3, 4], [3, 10]]	
def solution(v):
    answer = []
    x_point=[]
    y_point=[]
    
    for i in range(3):
        x_point.append(v[i][0])
        y_point.append(v[i][1])
    
    for i in range(3):
        x_ans=x_point.count(x_point[i])
        if x_ans==1:
            answer.append(x_point[i])
            break
    
    for i in range(3):
        y_ans=y_point.count(y_point[i])
        if y_ans==1:
            answer.append(y_point[i])
            break


    return answer
solution(v)
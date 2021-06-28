# 프로그래머스 lv1
# 구현
array=[1, 5, 2, 6, 3, 7, 4]	
commands=[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	

def solution(array, commands):
    answer = []
    for con in commands:
        arr=array[con[0]-1:con[1]]
        arr.sort()
        answer.append(arr[con[2]-1])
    return answer

solution(array,commands)
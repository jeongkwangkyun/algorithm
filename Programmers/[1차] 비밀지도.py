# 프로그래머스 lv1
# 구현

def solution(n, arr1, arr2):
    answer = []
    lst=[]
    for i in range(n):
        Arr1=bin(arr1[i])
        Arr1=list(Arr1[2:])
        while len(Arr1)<n:
            Arr1.insert(0,'0')
        Arr2=bin(arr2[i])
        Arr2=list(Arr2[2:])
        while len(Arr2)<n:
            Arr2.insert(0,'0')
        shap=''
        for j in range(n):
            if Arr1[j]=='1' or Arr2[j]=='1':
                shap+='#'
            else:
                shap+=' '
        answer.append(shap)
            
    return answer
solution(n,arr1,arr2)
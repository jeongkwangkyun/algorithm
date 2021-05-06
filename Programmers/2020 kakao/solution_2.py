# 생각외로 구현 문제인거같다

from itertools import permutations
import copy
# * + - 
expression="100-200*300-500+20"	 
max_size=0

op=['*','-','+']
op=list(permutations(op,3))
tmp=''
lst=[]
for i in expression:
    if i=='*' or i=='-' or i=='+':
        lst.append(tmp)
        lst.append(i)
        tmp=''
    else:
        tmp=tmp+i
lst.append(tmp)

def operation(num1,num2,op):
    if op == '+':
        return str(int(num1) + int(num2))
    if op == '-':
        return str(int(num1) - int(num2))
    if op == '*':
        return str(int(num1) * int(num2))

def calculate(op):
    # cal_tmp는 숫자와 기호 나누기
    cal_tmp=copy.deepcopy(lst)
    
    stack=[]
    result=[]

    # 우선순위 기호에 따라서 우선 기호 만나면 stack에서 맨뒤 pop 과 cal_tmp 맨앞 을 계산 아닐 시 stack append
    # for문 한번 돌 시 result에 값을 넣어주고 cal_tmp=stack와 stack=[] 초기화
    for o in op:
        while True:
            if len(cal_tmp)==0:
                break
            tmp=cal_tmp.pop(0)
            if tmp==o:
                stack.append(operation(stack.pop(-1),cal_tmp.pop(0),o))
            else:
                stack.append(tmp)
        result.append(stack)
        cal_tmp=stack
        stack=[]
    return result[-1]

for i in op:
    max_size=max(max_size, abs(int(calculate(i)[0])))

print(max_size)
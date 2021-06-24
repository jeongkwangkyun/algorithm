from collections import deque

n=8
k=2
cmd=["D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"]	

def solution(n, k, cmd):
    answer = ''
    dic={} 
    delete_lst=[]
    for i in range(n):
        dic[i]='O'
    select=k
    length=len(dic)
    for i in cmd:
        order=list(i.split())
        order_1=order[0]
        order_2=order[-1]
        if order_1=='D':
            if select==length:
                continue

            cnt=0
            while cnt<int(order_2):
                select+=1
                if select==length:
                    break
                if dic[select]=='X':
                    continue
                cnt+=1

                    

        elif order_1=='U':
            if select==0:
                continue
            cnt=0
            while cnt<int(order_2):
                select-=1
                if select==length:
                    break
                if dic[select]=='X':
                    continue
                cnt+=1
                


        elif order_1=='C':
            dic[select]='X'
            delete_lst.append(select)
            flag=False
            for j in range(length-select):
                if dic[select+j]=='O':
                    select=select+j
                    flag=True
                    break
            if flag==False:
                while dic[select]!='O':
                    select-=1
                    
                    
        else :
            dic[delete_lst.pop()]='O'


    answer="".join(list(dic.values()))
    
    return  answer


solution(n, k, cmd)
s="Zbcdefg"	
def solution(s):
    answer=''
    s=list(s)
    big=[]
    small=[]
    for i in s:
        if 'a'<=i<='z':
            small.append(i)
        elif 'A'<=i<='Z':
            big.append(i)
    small.sort(reverse=True)
    
    big.sort(reverse=True)
    
    
    return ''.join(small)+''.join(big)
solution(s)
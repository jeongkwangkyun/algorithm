#날짜계산
# 브루트포스
import sys

year=1

e,s,m=map(int,input().split())

e_tmp,s_tmp,m_tmp=1,1,1

while 1:
    if e==e_tmp and s==s_tmp and m==m_tmp:
        print(year)
        break
    
    e_tmp+=1
    s_tmp+=1
    m_tmp+=1
    year+=1
    if e_tmp==16:
        e_tmp-=15
    if s_tmp==29:
        s_tmp-=28
    if m_tmp==20:
        m_tmp-=19
    
    
        
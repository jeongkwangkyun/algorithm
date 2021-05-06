# 처음 set으로 리스트를 갯수로 했는데 그건 너무 느린가보다 ㅜㅜ

# 딕셔너리로 갯수 세가면서 풀라고함 투포인터도 맞음
# 투포인터로 접근했으나 개념을 잘못 이해해서 last를 증가시키고 first 한번만 증가시켜서 실패


gems=["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]	
answer=[]
gems_len=len((set(gems)))
shortest=len(gems)+1
first=0
last=0

gems_dict={}

# 전범위를 비교해야하므로 last 증가시키고 first 증가,,,, 또 라스트 증가해서 계속 비교해서 shortest 찾기
while last<len(gems):
    if gems[last] not in gems_dict:
        gems_dict[gems[last]]=1
    else:
        gems_dict[gems[last]]+=1
    last+=1

    if len(gems_dict)==gems_len:
        while first<last:
            if gems_dict[gems[first]]>1:
                gems_dict[gems[first]]-=1
                first+=1
            elif shortest>last-first:
                shortest=last-first
                answer=[first+1,last]
                break
            else:
                break


    

print(answer)

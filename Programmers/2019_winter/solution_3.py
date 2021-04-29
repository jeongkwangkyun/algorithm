from itertools import permutations
user_id=["frodo", "fradi", "crodo", "abc123", "frodoc"]	
banned_id=["fr*d*", "*rodo", "******", "******"]
answer=[]

def isMatch(com_set,banned_id):
    for i in range(len(com_set)):
        if len(com_set[i])!=len(banned_id[i]):
            return False
        
        for j in range(len(com_set[i])):
            if banned_id[i][j]=='*':
                continue
            if com_set[i][j]!=banned_id[i][j]:
                return False
    return True



for com_set in permutations(user_id,len(banned_id)):
    if isMatch(com_set,banned_id):
        com_set=set(com_set)
        if com_set not in answer:
            answer.append(com_set)

print(len(answer))
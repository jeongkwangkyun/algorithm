new_id="=.="
# 1단계
new_id=new_id.lower()
# 2단계
for i in new_id:
    if 'a'<=i<='z' or '0'<=i<'9' or i=='-' or i=='_' or i=='.':
        continue
    else:
        new_id=new_id.replace(i,'')
# 3단계
while '..' in new_id:
    new_id=new_id.replace('..','.')

# dot_cnt=new_id.count('.')
# for i in range(dot_cnt):
#     new_id=new_id.replace('..','.')
# 4단계
new_id=new_id.rstrip('.')
new_id=new_id.lstrip('.')
# 5단계
if len(new_id)==0:
    new_id=new_id+'a'
# 6단계
if len(new_id)>=16:
    new_id=new_id[:15]
# 7단계
while len(new_id)<3:
    new_id+=new_id[-1]

# if len(new_id)<=2:
#     while len(new_id)!=3:
#         new_id=new_id+new_id[-1]

print(new_id)
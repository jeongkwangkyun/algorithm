def binary_search(array, target, start, end):
    if start >end:
        return None
    mid =(start+end)//2
    if array[mid]==target:
        return mid
    elif array[mid]>target:
        return binary_search(array,target,start,mid-1)
    else:
        return binary_search(array,target,mid+1,end)


n, target= list(map(int,input().split()))
array=list(map(int,input().split()))

result=binary_search(array,target,0,n-1)
if result==None:
    print("원소가 존재하지 않습니다")
else:
    print(result+1)


target = 25
m_list = [30, 94, 27, 92, 21, 37, 25, 47, 25, 53, 98, 19, 32, 32, 7]
length = len(m_list)

m_list.sort()
left = 0 
right = length-1

while left<=right:
    mid = (left+right)//2
    if m_list[mid] == target:
        print(mid+1)
        break
    elif m_list[mid]>target:
        right = mid-1
    else :
        left = mid+1
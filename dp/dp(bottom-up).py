# 앞서 계산된 결과를 저장하귀 위한 dp테이블 초기화
d=[0]*100

# 첫 번째,두 번째 피보나치 수는 1
d[1]=1
d[2]=1
n=99

# 피보나치 함수 반복문으로 구현(보텀업)
for i in range(3,n+1):
    d[i]=d[i-1]+d[i2]


print(d[n])
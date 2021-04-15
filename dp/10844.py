# dp
# 0~9까지 다음 계단 수를 구하는 문제
# 케이스 0과 9만 한개만 나오고 나머지는 2개씩 나오기 때문에
# dp[i][0]=dp[i-1][1]
# dp[i][9]=dp[i-1][8]과 같다

N = int(input()) 
# 이차원 배열 0~9까지

dp = [[0]*10 for _ in range(N+1)] 
for i in range(1, 10): 
    dp[1][i] = 1 
    MOD = 1000000000 
    for i in range(2, N+1): 
        for j in range(10): 
            if j == 0: 
                dp[i][j] = dp[i-1][1] 
            elif j == 9: 
                dp[i][j] = dp[i-1][8] 
            else: 
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] 
print(sum(dp[N]) % MOD)

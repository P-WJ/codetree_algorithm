n = int(input())
A = list(map(int, input().split()))

# Please write your code here.
answer = 99999999
for i in range(n):
    d = 0
    for j in range(n):
        d += A[j] * abs(i-j)
    answer = min(answer, d)

print(answer)
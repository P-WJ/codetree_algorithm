from collections import Counter

n = int(input())
a = list(map(int, input().split()))

# Please write your code here.
ans = 0

for i in range(1, max(a)):
    cnt = 0

    for j in range(n):
        for k in range(j+1, n):
            if a[j] + a[k] == 2 * i:
                cnt += 1

    ans = max(ans, cnt)
print(ans)
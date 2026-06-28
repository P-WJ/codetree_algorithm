from collections import Counter

n = int(input())
a = list(map(int, input().split()))

# Please write your code here.
ans = 0

for i in range(1, max(a)):
    arr = []
    cnt = 0
    for j in range(n):
        arr.append(abs(i-a[j]))
    for k in Counter(arr).values():
        if k == 2:
            cnt += 1

    ans = max(ans, cnt)

print(ans)
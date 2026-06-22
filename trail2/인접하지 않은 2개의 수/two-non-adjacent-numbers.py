n = int(input())
numbers = list(map(int, input().split()))

# Please write your code here.
ans = 0

for i in range(n):
    s = 0

    for j in range(n):
        if abs(j-i) == 1 or i == j:
            continue
        else:
            s = numbers[i] + numbers[j]
        ans = max(s, ans)

print(ans)
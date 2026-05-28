n = int(input())
x = []
dir = []
for _ in range(n):
    xi, di = input().split()
    x.append(int(xi))
    dir.append(di)

# Please write your code here.
offset = 1000
cur = 1000
arr = [0 for _ in range(2 * offset + 1)]

for i in range(n):
    if dir[i] == "L":
        for j in range(cur, cur - x[i], -1):
            arr[j] += 1
        cur -= x[i]

    elif dir[i] == "R":
        for j in range(cur + 1, cur + x[i] + 1):
            arr[j] += 1
        cur += x[i]

ans = 0
for i in arr:
    if i >= 2:
        ans += 1

print(ans)
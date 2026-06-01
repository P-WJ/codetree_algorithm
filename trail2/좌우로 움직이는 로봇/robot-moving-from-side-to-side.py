n, m = map(int, input().split())

# Process robot A's movements
t = []
d = []
for _ in range(n):
    time, direction = input().split()
    t.append(int(time))
    d.append(direction)

# Process robot B's movements
t_b = []
d_b = []
for _ in range(m):
    time, direction = input().split()
    t_b.append(int(time))
    d_b.append(direction)

# Please write your code here.
arr1 = []
arr2 = []
cur1 = 0
cur2 = 0

for i in range(n):
    if d[i] == "L":
        for j in range(t[i]):
            cur1 -= 1
            arr1.append(cur1)

    else:
        for j in range(t[i]):
            cur1 += 1
            arr1.append(cur1)


for i in range(m):
    if d_b[i] == "L":
        for j in range(t_b[i]):
            cur2 -= 1
            arr2.append(cur2)

    else:
        for j in range(t_b[i]):
            cur2 += 1
            arr2.append(cur2)

if len(arr1) < len(arr2):
    for i in range(len(arr2)-len(arr1)):
        arr1.append(arr1[-1])
elif len(arr1) > len(arr2):
    for i in range(len(arr1)-len(arr2)):
        arr2.append(arr2[-1])

ans = 0
for i in range(1,len(arr1)):
    if arr1[i] == arr2[i] and arr1[i-1] != arr2[i-1]:
        ans += 1

print(ans)
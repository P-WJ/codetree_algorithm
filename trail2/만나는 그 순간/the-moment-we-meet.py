n, m = map(int, input().split())

d = []
t = []
for _ in range(n):
    direction, time = input().split()
    d.append(direction)
    t.append(int(time))

d2 = []
t2 = []
for _ in range(m):
    direction, time = input().split()
    d2.append(direction)
    t2.append(int(time))

# Please write your code here.
pos1 = 0
arr1 = []
for i in range(n):
    if d[i] == "L":
        for j in range(t[i]):
            pos1 -= 1
            arr1.append(pos1)
    else:
        for j in range(t[i]):
            pos1 += 1
            arr1.append(pos1)


pos2 = 0
arr2 = []
for i in range(m):
    if d2[i] == "L":
        for j in range(t2[i]):
            pos2 -= 1
            arr2.append(pos2)
    else:
        for j in range(t2[i]):
            pos2 += 1
            arr2.append(pos2)

for i in range(abs(len(arr2) - len(arr1))):
    if len(arr1) < len(arr2):
        arr1.append(arr1[-1])
    elif len(arr1) > len(arr2):
        arr2.append(arr2[-1])

ans = -1
for i in range(len(arr1)):
    if arr1[i] == arr2[i]:
        ans = i+1
        break

print(ans)
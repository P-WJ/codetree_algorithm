n, m = map(int, input().split())

# Process A's movements
v = []
t = []
for _ in range(n):
    vi, ti = map(int, input().split())
    v.append(vi)
    t.append(ti)

# Process B's movements
v2 = []
t2 = []
for _ in range(m):
    vi, ti = map(int, input().split())
    v2.append(vi)
    t2.append(ti)

# Please write your code here.
arr1, arr2 = [0], [0]

for i in range(n):
    for j in range(t[i]):
        arr1.append(arr1[-1] + v[i])

for i in range(m):
    for j in range(t2[i]):
        arr2.append(arr2[-1] + v2[i])

ans = 0
prev = 0
for i in range(1, len(arr1)):
    if arr1[i] > arr2[i]:
        prev = 1
        break
    elif arr1[i] < arr2[i]:
        prev = 2
        break

for i in range(2, len(arr1)):
    if prev == 1 and arr1[i] < arr2[i]:
        ans += 1
        prev = 2
    elif prev == 2 and arr1[i] > arr2[i]:
        ans += 1
        prev = 1
print(ans)

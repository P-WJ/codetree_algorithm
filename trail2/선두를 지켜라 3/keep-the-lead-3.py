N, M = map(int, input().split())

# Process A's movements
v = []
t = []
for _ in range(N):
    vi, ti = map(int, input().split())
    v.append(vi)
    t.append(ti)

# Process B's movements
v2 = []
t2 = []
for _ in range(M):
    vi, ti = map(int, input().split())
    v2.append(vi)
    t2.append(ti)

# Please write your code here.
d1 = [0]
d2 = [0]

for i in range(N):
    for j in range(t[i]):
        d1.append(d1[-1] + v[i])

for i in range(M):
    for j in range(t2[i]):
        d2.append(d2[-1] + v2[i])

ans = 0
prev = -1
for i in range(1, len(d1)):
    if d1[i] < d2[i]:
        st = 2
    elif d1[i] > d2[i]:
        st = 1
    else:
        st = 0

    if st == prev:
        continue
    else:
        prev = st
        ans += 1
    
print(ans)

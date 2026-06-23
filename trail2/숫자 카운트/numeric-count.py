n = int(input())
a, b, c = [], [], []
for _ in range(n):
    num, cnt1, cnt2 = map(int, input().split())
    a.append(str(num))
    b.append(cnt1)
    c.append(cnt2)

# Please write your code here.
ans = 0

for i in range(1, 10):
    for j in range(1, 10):
        
        if i == j:
            continue

        for k in range(1, 10):

            if j == k or i == k:
                continue

            t = str(i) + str(j) + str(k)
            f = True

            for x in range(n):
                c1 = 0
                c2 = 0

                g = a[x]

                for y in range(3):
                    if t[y] == g[y]:
                        c1 += 1

                    elif g[y] in t:
                        c2 += 1

                if c1 != b[x] or c2 != c[x]:
                    f = False
                    break

            if f:
                ans += 1

print(ans)
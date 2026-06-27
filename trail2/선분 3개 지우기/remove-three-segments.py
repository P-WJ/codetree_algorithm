n = int(input())
l = []
r = []
for _ in range(n):
    left, right = map(int, input().split())
    l.append(left)
    r.append(right)

# Please write your code here.
arr = []
ans = 0

for i in range(n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            
            li = [0 for _ in range(max(r)+1)]
            for m in range(n):
                if m == i or m == j or m == k:
                    continue

                for x in range(l[m], r[m]+1):
                    li[x] += 1
          
            f = True
            for m in range(len(li)):
                if li[m] >= 2:
                    f = False
                    break
    
            
            if f:
                ans += 1
print(ans)
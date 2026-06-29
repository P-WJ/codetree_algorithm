n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x, y = zip(*points)
x, y = list(x), list(y)

# Please write your code here.
ans = 0

for i in range(11):
    for j in range(11):
        for k in range(11):

            f = True
            for x, y in points:
                if x == i or x == j or x == k:
                    continue
                
                f = False
            if f:
                ans = 1
            
            f = True
            for x, y in points:
                if x == i or x == j or y == k:
                    continue
                
                f = False
            if f:
                ans = 1

            f = True
            for x, y in points:
                if x == i or y == j or y == k:
                    continue

                f = False
            if f:
                ans = 1

            f = True
            for x, y in points:
                if y == i or y == j or y == k:
                    continue
                
                f = False
            if f:
                ans = 1

print(ans)
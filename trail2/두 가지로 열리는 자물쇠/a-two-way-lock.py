N = int(input())
a1, b1, c1 = map(int, input().split())
a2, b2, c2 = map(int, input().split())

# Please write your code here.
ans = 0

def f(x, y):
    return (N - abs(x - y)) <= 2 or abs(x - y) <= 2

for i in range(1, N+1):
    for j in range(1, N+1):
        for k in range(1,N+1):

            a = f(i, a1) and f(j, b1) and f(k, c1)
            b = f(i, a2) and f(j, b2) and f(k, c2)

            if a or b:
                ans += 1

print(ans)
a, b, c = map(int, input().split())

# Please write your code here.
k = 11 * 24 * 60 + 11 * 60 + 11
l = a * 24 * 60 + b * 60 + c
if k > l:
    print(-1)
else:
    print(l-k)
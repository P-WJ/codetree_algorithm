n = int(input())
a = [int(input()) for _ in range(n)]

# Please write your code here.
arr = []

for i in range(n):
    s = 0
    for j in range(n):
        
        s += a[j-i] * j

    arr.append(s)

print(min(arr))
N, B = map(int, input().split())

# Please write your code here.
ans = 0
arr = []
while True:
    if N == 0:
        break

    arr.append(N % B)
    N = N // B

for i in range(len(arr)):
    print(arr[::-1][i], end = "")
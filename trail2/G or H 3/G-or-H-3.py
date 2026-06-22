n, k = map(int, input().split())
arr = []

for _ in range(n):
    pos, char = input().split()
    arr.append((int(pos), char))
    

# Please write your code here.
arr.sort()

li = []
if n == 1:
    li.append(arr[0][1])

else:

    for i in range(n-1):
        s = arr[i][1]

        for j in range(i+1, n):
            if abs(arr[j][0] - arr[i][0]) > k:
                continue

            s += arr[j][1]

        li.append(s) 


ans = 0
for string in li:
    x = 0
    for ch in string:
        if ch == "G":
            x += 1
        elif ch == "H":
            x += 2

    ans = max(ans, x)

print(ans)
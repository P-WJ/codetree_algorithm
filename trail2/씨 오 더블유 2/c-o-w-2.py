n = int(input())
S = input()

# Please write your code here.
ans =  0

for i in range(n-2):
    if S[i] != "C":
        continue

    for j in range(i+1, n-1):
        if S[j] != "O":
            continue

        for k in range(j+1, n):
            if S[k] != "W":
                continue

            ans += 1

print(ans)
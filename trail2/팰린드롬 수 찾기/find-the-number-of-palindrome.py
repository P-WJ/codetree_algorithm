X, Y = map(int, input().split())

# Please write your code here.
ans = 0

for i in range(X, Y+1):
    l = len(str(i))
    if l % 2 == 0:
        m = l // 2 - 1
    else:
        m = l // 2

    cnt = 0
    for j in range(m+1):
        if str(i)[j] != str(i)[l-1-j]:
            break
        else:
            cnt += 1
    if cnt == m+1:
        ans += 1

print(ans)
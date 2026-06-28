X, Y = map(int, input().split())

# Please write your code here.
ans = 0

for i in range(X, Y+1):

    num = i
    digit = [0] * 10
    cnt = len(str(i))

    while (num):
        digit[num % 10] += 1
        num //= 10

    interesting = False

    for j in range(10):
        if digit[j] == cnt - 1:
            interesting = True

    if interesting:
        ans += 1

print(ans)
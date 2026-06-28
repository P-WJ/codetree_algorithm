from collections import Counter

X, Y = map(int, input().split())

# Please write your code here.
cnt = 0

for i in range(X, Y+1):

    if len(Counter(str(i))) == 2:
        if Counter(str(i)).most_common(2)[0][1] == 1 or Counter(str(i)).most_common(2)[1][1] == 1:
            cnt += 1

print(cnt)
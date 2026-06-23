import sys

abilities = list(map(int, input().split()))

# Please write your code here.
ans = sys.maxsize

for i in range(4):
    for j in range(i+1, 5):
        for k in range(j+1, 6):

            a = abilities[i] + abilities[j] + abilities[k]
            b = 0
            for l in range(6):
                if l != i and l != j and l != k:
                    b += abilities[l]

            ans = min(ans, abs(a-b))

print(ans)
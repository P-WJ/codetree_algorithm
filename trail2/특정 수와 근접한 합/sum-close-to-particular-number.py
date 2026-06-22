import sys
from itertools import combinations

N, S = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
ans = sys.maxsize

comb = list(combinations(arr, N-2))

for i in range(len(comb)):
    T = sum(comb[i])
    ans = min(ans, abs(T-S))

print(ans)
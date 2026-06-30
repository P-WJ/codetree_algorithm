n, k = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
def f(limit):
    li = []

    for i in range(n):
        if arr[i] <= limit:
            li.append(i)
        
    if not li or li[0] != 0 or li[-1] != n-1:
        return False

    for i in range(1, len(li)):
        if li[i] - li[i-1] > k:
            return False
    
    return True

ans = max(arr)

for limit in range(max(arr) + 1):
    if f(limit):
        ans = min(ans, limit)

print(ans)

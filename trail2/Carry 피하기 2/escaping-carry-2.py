n = int(input())
arr = [int(input()) for _ in range(n)]

# Please write your code here.

def carry(a, b, c):
    
    while a or b or c:
        if a % 10 + b % 10 + c % 10 >= 10:
            return True
        a //= 10
        b //= 10
        c //= 10

    return False
    

ans = -1

for i in range(n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            if not carry(arr[i], arr[j], arr[k]):
                ans = max(ans, arr[i] + arr[j] + arr[k])

print(ans)
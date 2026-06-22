n = int(input())
arr = [int(input()) for _ in range(n)]

# Please write your code here.
ans  = -1

for i in range(n):
    if len(str(arr[i])) <= 6:
        
        arr[i] =  "0"*(6 - len(str(arr[i]))) + str(arr[i])


for i in range(0, n-2):
    s = 0
    for j in range(i+1, n-1):

        for k in range(j+1, n):
            

            if int(arr[i][-1]) + int(arr[j][-1]) + int(arr[k][-1]) >= 10:
                continue

            elif int(arr[i][-2]) + int(arr[j][-2]) + int(arr[k][-2]) >= 10:
                continue
            
            elif int(arr[i][-3]) + int(arr[j][-3]) + int(arr[k][-3]) >= 10:
                continue
            
            elif int(arr[i][-4]) + int(arr[j][-4]) + int(arr[k][-4]) >= 10:
                continue

            elif int(arr[i][-5]) + int(arr[j][-5]) + int(arr[k][-5]) >= 10:
                continue

            elif int(arr[i][-6]) + int(arr[j][-6]) + int(arr[k][-6]) >= 10:
                continue

            s = int(arr[i]) + int(arr[j]) + int(arr[k])

            ans = max(s, ans)

print(ans)

n = int(input())
people = [tuple(input().split()) for _ in range(n)]
people.sort(key = lambda x : int(x[0]))
maxx = int(people[-1][0])

arr = ["0" for _ in range(maxx+1)]
for p in people:
    arr[int(p[0])] = p[1]

# Please write your code here.
ans = 0

for i in range(1, maxx+1):
    for j in range(i, maxx+1):

        if arr[i] == "0" or arr[j] == "0":
            continue

        cnt_g = 0
        cnt_h = 0
    
        for k in range(len(arr[i:j+1])):
            if arr[i:j+1][k] == "G":
                cnt_g += 1
            
            elif arr[i:j+1][k] == "H":
                cnt_h += 1

            
        if cnt_g == cnt_h or (cnt_g == 0 and cnt_h != 0) or (cnt_g != 0 and cnt_h == 0):
            ans = max(ans, abs(j-i))

print(ans)
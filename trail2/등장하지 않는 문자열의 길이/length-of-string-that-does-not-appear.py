N = int(input())
str = input()

# Please write your code here.
for i in range(1, N+1):
    arr = set()
    t = True

    #
    for j in range(N+1-i):
        s = str[j: j + i]
        
        if s in arr:
            t = False
            break

        arr.add(s)

    if t:
        print(i)
        break
        
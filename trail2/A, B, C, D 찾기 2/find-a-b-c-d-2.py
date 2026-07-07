nums = list(map(int, input().split()))

# Please write your code here.
nums.sort()

def f(a,b,c,d):
    arr = [a,b,c,d,a+b,b+c,c+d,d+a,a+c,b+d,a+b+c,a+b+d,a+c+d,b+c+d,a+b+c+d]
    arr.sort()
    if nums == arr:
        return True
    return False

for i in range(1,41):
    for j in range(1,41):
        for k in range(1,41):
            for l in range(1,41):
                if f(i,j,k,l):
                    print(i,j,k,l)
                    flag = True
                    exit()

    

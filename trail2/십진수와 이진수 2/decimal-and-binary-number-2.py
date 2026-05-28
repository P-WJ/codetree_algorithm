N = input()

# Please write your code here.
a = 0
for i in range(len(N)):
    a += int(N[i]) * pow(2, (len(N) - 1 - i))

a *= 17
arr = []
while True:
    if a == 0:
        break
    
    arr.append(a % 2)
    a = a // 2

for i in arr[::-1]:
    print(i, end = "")
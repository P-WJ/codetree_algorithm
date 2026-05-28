a, b = map(int, input().split())
n = input()

# Please write your code here.
x = 0
for i in range(len(n)):
    x += int(n[i]) * pow(a, len(n) - 1 - i)

arr = []
while True:
    if x == 0:
        break
    
    arr.append(x % b)
    x = x // b

for i in arr[::-1]:
    print(i, end = "")
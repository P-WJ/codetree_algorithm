binary = input()

# Please write your code here.
ans = 0

for i in range(len(binary)):
    ans += int(binary[i]) * pow(2, len(binary) - i - 1)

print(ans)
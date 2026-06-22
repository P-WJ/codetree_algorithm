a = list(input())

# Please write your code here.
changed = False
for i in range(len(a)):
    if a[i] == "0":
        a[i] = "1"
        changed = True
        break

if not changed:
    a[-1] = "0"

ans = 0

for i in range(len(a)):
    ans += int(a[i]) * pow(2, len(a)-i-1)

print(ans)

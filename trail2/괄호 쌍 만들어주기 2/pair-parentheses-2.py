A = input()

# Please write your code here.
ans = 0

for i in range(len(A)-1):
    for j in range(i+1, len(A)-1):

        if A[i] == A[i+1] == "(":

            if A[j] == A[j+1] == ")":

                ans +=1

print(ans)
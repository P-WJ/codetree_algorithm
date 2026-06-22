board = [list(map(int, input().split())) for _ in range(19)]

# Please write your code here.
ans = 0
x, y = 0, 0
found = False

for i in range(19):
    if found:
        break
    for j in range(19):

        if board[i][j] != 0:
            
            prev = board[i][j]
            

            if j < 15:
                cnt = 1
                for k in range(j+1, j+5):
                    if board[i][k] == prev:
                        cnt += 1
                    else:
                        break

                if cnt == 5:
                    ans = prev
                    x, y = j+2, i
                    found = True
                    break
                
            if i < 15:
                cnt = 1
                for l in range(i+1, i+5):
                    if board[l][j] == prev:
                        cnt += 1
                    else:
                        break

                if cnt == 5:
                    ans = prev
                    x, y = j, i+2
                    found = True
                    break

            if j < 15 and i < 15:
                cnt = 1
                for m in range(1, 5):
                    if board[i+m][j+m] == prev:
                        cnt += 1
                    else:
                        break

                if cnt == 5:
                    ans = prev
                    x, y = j+2, i+2
                    found = True
                    break

            if j > 3 and i < 15:
                cnt = 1
                for m in range(1, 5):
                    if board[i+m][j-m] == prev:
                        cnt += 1
                    else:
                        break

                if cnt == 5:
                    ans = prev
                    x, y = j-2, i+2
                    found = True
                    break

if ans == 0:
    print(ans)
else:
    print(ans)
    print(y+1, x+1)
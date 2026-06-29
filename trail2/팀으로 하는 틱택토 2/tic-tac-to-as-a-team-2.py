inp = []
for _ in range(3):
    inp.append(list(map(int,input())))
# Please write your code here.
ans = 0
for a in range(1, 9):
    for b in range(a+1, 10):
        f = False
        
        # 가로
        for i in range(3):
            cnt1_a = 0
            cnt1_b = 0
            for j in range(3):
                if a == inp[i][j]:
                    cnt1_a += 1
                if b == inp[i][j]:
                    cnt1_b += 1
            
            if (cnt1_a >= 1 and cnt1_b >= 2) or (cnt1_a >= 2 and cnt1_b >= 1):
                f = True

        # 세로
        for i in range(3):
            cnt2_a = 0
            cnt2_b = 0

            for j in range(3):
                if a == inp[j][i]:
                    cnt2_a += 1
                if b == inp[j][i]:
                    cnt2_b += 1

            if (cnt2_a >= 1 and cnt2_b >= 2) or (cnt2_a >= 2 and cnt2_b >= 1):
                f = True

        # 대각선
        cnt3_a = 0
        cnt3_b = 0
        for i in range(3):
            if a == inp[i][2-i]:
                cnt3_a += 1
            if b == inp[i][2-i]:
                cnt3_b += 1

        if (cnt3_a >= 1 and cnt3_b >= 2) or (cnt3_a >= 2 and cnt3_b >= 1):
            f = True

        cnt4_a = 0
        cnt4_b = 0
        for i in range(3):
            if a == inp[i][i]:
                cnt4_a += 1
            if b == inp[i][i]:
                cnt4_b += 1

        if (cnt4_a >= 1 and cnt4_b >= 2) or (cnt4_a >= 2 and cnt4_b >= 1):
            f = True

        if f:
            ans += 1

print(ans)
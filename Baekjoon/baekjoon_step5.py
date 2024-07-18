# s = input()
# i = int(input())
# print(s[i-1])

# ----------------------------------

# s = input()
# print(len(s))

# -----------------------------------



while (True) :
    try:
        s = input()
        print(s)
        if s[0] == ' ' and s[-1] == ' ':
            break
    except EOFError:
        break

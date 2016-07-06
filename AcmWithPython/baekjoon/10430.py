'''
Created on 2016. 6. 3.

@author: lee
'''

if __name__ == '__main__':
    input = input().split(' ')
    A, B, C = [int(input[0]), int(input[1]), int(input[2])]
    print((A+B) % C)
    print((A % C + B % C) % C)
    print((A*B) % C)
    print((A%C * B%C) % C)
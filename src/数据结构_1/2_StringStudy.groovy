package 数据结构_1

def name = '单引号定义字符串'
println name.class

def name2 = '''使用三个单引号定义字符串--格式化字符串
line one
line two
line three
'''
println("三引号字符串： " + name2)


def name3 = "使用双引号定义字符串--可拓展任意表达式"
println(name3)
def sum = "2 + 3 = ${2 + 3}"
println sum
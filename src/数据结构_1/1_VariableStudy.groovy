package 数据结构_1

/**
 * 基本类型都会有装箱操作
 */
int x = 10
println x.class

//弱类型定义 def 相当于object类型可以随时转换为其他类型

def x_1 = 123
println("x_1 = ${x_1.class}")

def x_2 = 3.21
println("x_2 = ${x_2.class}")


def x_3 = "hello word"
println("x_3 = ${x_3.class}")

//转换为其他数据类型
x_1 = "我的世界"
println "转换后的数据类型为：x_1 = " + x_1.class



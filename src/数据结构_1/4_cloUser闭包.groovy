package 数据结构_1

//定义闭包
def cloUser = { println "Hello 闭包" }
println "闭包调用方式一："
cloUser.call()

println "闭包调用方式二："
cloUser()

/**
 * （1）有参数闭包参数定义形式：
 *
 *   自定义参数：
 *     def 变量名 = {闭包参数->闭包体}
 *   使用默认参数it
 *     def 变量名 = {闭包参数->闭包体}
 *
 * 无参数闭包定义形式
 *   def 变量名 = {闭包体}
 *
 * （2）调用形式：
 *  1.name.call()
 *  2.name()
 *（3）闭包的返回值
 *  1.有return语句返回
 *  2.无返回值类型：返回数值都为null
 *
 */

def name = { String name,String age -> println "闭包参数为：${name} value = ${age}" }
name.call("Hello","123")

def defalut = { println "默认参数it的使用: ${it}"}

defalut("123")

println "闭包返回值类型：有return返回类型"
def age = {def age -> return "我的年龄为:${age}"}
def result = age("123")
println result

println "闭包无返回值类型"
def notReturn = { println "闭包无返回值的结果为："}
def result2 = notReturn()
print result2





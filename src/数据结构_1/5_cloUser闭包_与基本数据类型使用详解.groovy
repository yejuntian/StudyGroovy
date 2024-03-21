package 数据结构_1
/**
 * 注意不知道函数闭包的参数个数
 * 看对应方法中源码所传递参数个数
 */

/**
 * 用来求指定number阶乘
 * @param number
 * @return
 */
int upto(int number) {
    def result = 1
    1.upto(number,
            {
                int num ->
                    result *= num
                    println "${result} *= ${num}"
            }
    )
    return result
}

def res = upto(5)
println "阶乘实现方式一的结果为： res = ${res}"

/**
 * 闭包函数---写在方法外面
 * @param number
 * @return
 */
int downto(int number) {
    def result = 1
    number.downto(1)
            {
                int num ->
                    result *= num
                    println "${result} *= ${num}"
            }
    return result
}

def res2 = downto(5)
println "阶乘实现方式二的结果为： res2 = ${res2}"

def result = 1

int timer(int number) {
    def result = 0
    number.times { num ->
        result += num
        println "${result} += ${num}"
    }
    return result
}

def res3 = timer(3)
println "阶乘实现方式三的结果为： res3 = ${res3}"




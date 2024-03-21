package 数据结构_1
/**
 * 注意不知道函数闭包的参数个数
 * 看对应方法中源码所传递参数个数
 */

/**
 * 1.each 遍历每个字符
 */
def str = "123fdsf456789"

println "使用each方法遍历后的结果："
str.each { s -> println "s = ${s}" }

/**
 * 2.find 查找符合条件的第一个元素
 */
def result = str.find {
    stem -> stem.contains("2")
}
println "使用find方法进行筛选后的结果：${result}"

/**
 * 3.findAll 查找符合条件的所有元素
 */

def all = str.findAll({
    String temp -> temp.isNumber()
})
println "使用findAll方法进行筛选后的结果：${all.toList()}"

/**
 * 4.any 查找符合条件的所有元素,只要某一个符合要求返回true
 */
def result2 = str.any {
    String temp -> temp.isNumber()
}
println "使用any方法遍历符合条件:${result2}"

/**
 * 5.every 查找字符串的每一个元素，是否符合条件，如果某一个不符合就返回false
 */
def result3 = str.every() {
    String temp -> temp.isNumber()
}
println "使用every方法遍历符合条件:${result3}"

/**
 * 6.collect 遍历每个元素，根据条件，把转换后的结果添加到另外一个结合中，返回新的集合
 */
def list2 = str.collect() {
    String s -> s.toUpperCase()
}
println "使用Collect函数后的结果：${list2.toListString()}"



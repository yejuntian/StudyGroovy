package 数据结构_1
/**
 * 1.sort排序
 * 2.find、findAll、any、every
 * 3.min、max 最小、最大值查找
 */

def list = new ArrayList()//java定义集合形势
def list2 = [1, 3, 5, 6, 8]//groovy定义集合方式
def list3 = [2, 5, 6] as int[] //集合转为数组形势
int[] list4 = [1, 4, 6] //直接定义数组

/**
 * 列表排序
 */
println "使用java方式排序："
def list5 = [-1, 3, 4, 7, -9]
Comparator comparable = {
    a, b ->
        a == b ? 0 : Math.abs(a) > Math.abs(b) ? 1 : 1
}
Collections.sort(list5, comparable)
println "排序后的结果：${list5}"

println "使用groovy方式排序："
def sortList = list5.sort() {
    int a, int b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? 1 : -1
}
println "使用groovy排序后的结果：${sortList}"

println "字符列表长度排序："
def strSort = ["java", "hello", "String", "adb"]
strSort.sort() {
    it -> it.size()
}
println "字符列表长度排序结果：${strSort}"

/**
 * find使用
 */
println "列表find方法使用："
def findResult = [1, -3, 2, 4, 8, 9, -10]
def result = findResult.find() {
    it -> return it % 2 == 0
}
println "find方法查找后的结果：${result}"

/**
 * findAll使用
 */
println "列表findAll方法使用："
def findAllResult = [1, -3, 2, 4, 8, 9, -10]
def findAllRes = findAllResult.findAll() {
    it -> return it % 2 != 0
}
println "findAll方法查找后的结果：${findAllRes}"

/**
 * any使用
 */
println "列表any方法使用："
def anyResult = findResult.any() {
    it -> return it == -10
}
println "列表any方法结果：${anyResult}"

/**
 * every使用
 */
println "列表every方法使用："
def everyResult = findResult.every() {
    it -> return it == 2
}
println "列表every方法结果：${everyResult}"

/**
 * min方法使用
 */
println "列表min方法使用："
def minResult = findResult.min() {
    it -> return it.abs()
}
println "列表min方法结果：${minResult}"

/**
 * min方法使用
 */
println "列表max方法使用："
def maxResult = findResult.max() {
    it -> return it.abs()
}
println "列表max方法结果：${maxResult}"

/**
 * count查找方法使用
 */
println "列表count查找方法使用："
def countResult = findResult.count() {
    it -> return it >= 105
}
println "列表count查找方法符合条件个数为：${countResult}"





package 数据结构_1
/**
 * map获取方式
 * （1）索引方式
 *      1.通过[]属性名的方式
 *       map对象['属性名']
 *      2.通过.的形势
 *      map对象.属性名
 * （2）添加、修改元素
 *  map对象.属性名 = 数值
 * （3）遍历map
 *      1.each  ---》通过对象属性.的方式或者key-value形势
 *      2.eachWithIndex ---》通过对象属性.的方式或者key-value形势
 *
 * (4)查找
 *   1.find
 *   2.findAll
 *   3.count：查找符合条件所有个数
 *   4.collect:统计结果作为新的集合
 *   5.group分组
 * (5)排序
 *     1.sort
 */

def map = new HashMap()//java定义map方式
def map2 = [red: "ff0000", green: "00ff00", blue: "0000ff"]//groovy定义map方式

/**
 * 索引方式获取元素对应value值
 */
println "获取方式一--》['属性名']：${map2['red']}"
println "获取方式二--》通过.属性名：${map2.blue}"

/**
 * 添加、修改元素
 */
map2.red = "red"
map2.newColor = "newColor"
println "添加、修改后新的map:${map2.toMapString()}"
/**
 * 添加另外一个map集合
 */
println "map同时添加多个元素"
map2.newMap = ["name": "zhangsan", "age": "20"]
println "新的map为${map2.toMapString()}"

/**
 * map遍历each
 */
def student = [
        1: ['number': "001", 'age': '10'],
        2: ['number': "002", 'age': '11'],
        3: ['number': "003", 'age': '12'],
        4: ['number': "004", 'age': '13']
]
/**
 * each遍历
 */
println "map的遍历方式一each："
student.each() {
    int key, def value ->
        println "key = ${key} value = ${value}"
}

/**
 * eachWithIndex带索引的遍历
 */
println "map的遍历方式二eachWithIndex："
student.eachWithIndex() {
    def temp, int index ->
        println "索引index = ${index} key = ${temp.key} value = ${temp.value}"
}

/**
 * key-value方式遍历
 */
println "通过key-value方式each遍历"
student.each() {
    def key, def value ->
        println "通过key-value遍历 key：${key} value：${value}"
}
println "通过key-value方式eachWithIndex遍历"
student.eachWithIndex() {
    def key, def value, def index ->
        println "通过key-value遍历 index:${index} key：${key} value：${value}"
}

/**
 * map查找find
 */
println "map使用find查找"
def findResult = student.find {
    def stud -> (stud.value.age as Integer) > 12
}
println "使用find查找第一个符合条件的结果为：${findResult}"

/**
 * map查找findAll
 */
println "map使用findAll查找"
def findAllResult = student.findAll {
    def stud -> (stud.value.age as Integer) > 11
}
println "使用findAll查找符合条件的所有结果为：${findAllResult}"

/**
 * map查找符合条件个数：count
 */
println "map使用count查找符合条件个数"
def countResult = student.count {
    def stud -> (stud.value.age as Integer) > 12
}
println "使用count查找符合条件的所有个数为：${countResult}"

/**
 * map查找过滤操作：collect
 */
println "map使用collect进行过滤"
def collectResult = student.findAll {
    def stud -> (stud.value.age as Integer) > 11
}.collect {
    def st -> st.value.number
}
println "map使用collect进行过滤后的集合为：${collectResult}"

/**
 * group分组
 */
println "使用group分组函数"
def groupResut = student.groupBy() {
    def group -> return group.value.age.toInteger() > 11 ? 'good' : 'bad'
}
println "使用分组group结果为：${groupResut.toMapString()}"

/**
 * 排序sort
 */
println "使用sort排序"
def sortResult = student.sort() {
    def stu1, def stu2 ->
        Number age1 = stu1.value.age.toInteger()
        Number age2 = stu2.value.age.toInteger()
        return age1 == age2 ? 0 : age1 > age2 ? -1 : 1
}
println "使用sort从高到低排序结果为：${sortResult.toMapString()}"

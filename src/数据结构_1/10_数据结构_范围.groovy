package 数据结构_1
/**
 * range
 * （1）通过角标index查找
 * 对象[集合下标]
 * （2）包含
 * 对象.contains()
 * (3)起始值、终止值
 * from、to
 * （4）遍历
 * 1.each --》 推荐使用
 * 2.in
 */

def rangResult = 1..11
println "查找元素角标为2的元素：${rangResult[2]}"
println "查找是否包含2的元素,查找结果为：${rangResult.contains(2)}"
println "范围的起始值from = ${rangResult.from} 终止值 to =${rangResult.to}"

println "通过each遍历:"
rangResult.each {
    int it ->
        println "${it}"
}

println "通过in遍历:"
for (def num in rangResult) {
    println num
}


def getGrade(Number number) {
    def result
    switch (number) {
        case 10..<60:
            result = "不及格"
            break
        case 60..<70:
            result = "及格"
            break
        case 70..<80:
            result = "良好"
            break
        case 80..<100:
            result = "优秀"
            break
    }
    return result;
}

println "使用swich case 的结果为：${getGrade(80)}"



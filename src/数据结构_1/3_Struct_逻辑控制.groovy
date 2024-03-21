package 数据结构_1

def result = 1.23

switch (result) {
    case "foot":
        result = "found foot"
        break
    case "bar":
        result = "bar"
        break
    case [1.23, 4, 5, 6, "list"]://列表
        result = "list"
        break
    case 12..23://范围
        result = "range"
        break
    case Integer:
        result = "Integer"
        break
    case BigDecimal:
        result = "BigDecimal"
        break
    default:
        result = "default"
}

println "result = ${result}"

/**
 * 对范围for循环
 */
println "范围for循环"
for (i in 12..16) {
    println i
}
println "对list循环"
for (i in [1, 2, 3, 4, 5, 6, 7]) {
    println i
}

println "对map循环"
for (i in ["lili": 1, "xiaoming": 4, "lisi": "123"]) {
    println "key = ${i.key} value = ${i.value}"
}











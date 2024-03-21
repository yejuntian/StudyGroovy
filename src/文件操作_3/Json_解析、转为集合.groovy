package 文件操作_3

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import 面向对象_2.class1.Person_1

/**
 * --》集合转为json数据
 *   1.JsonOutput.toJson(）
 *   2.打印出带格式的json字符串 JsonOutput.prettyPrint(String str)
 * --》json数据转为object对象
 *   1.创建JsonSlurper对象 JsonSlurper jsonSlurper = new JsonSlurper()
 *   2.解析数据方法：parse()、parseText()
 */

/**
 * 集合对象转为json数据
 */
def list = [new Person_1(name: 'li si', age: 20), new Person_1(name: 'zhang san', age: 10)]
String json = JsonOutput.toJson(list)
println "转为json数据:${json}"
/**
 * 打印带格式字符串
 */
println "打格式的字符串数据"
def preJson = JsonOutput.prettyPrint(json)
println "转为json数据:${preJson}"

/**
 * 使用parseText()
 * 把json数据转为object对象
 */
println "json数据转为object对象"
JsonSlurper jsonSlurper = new JsonSlurper()
List newList = jsonSlurper.parseText(json) as List
println "newList = ${newList}"
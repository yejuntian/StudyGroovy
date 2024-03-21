package 文件操作_3

import groovy.xml.XmlSlurper

/**
 * --》xml解析
 *  1.创建XmlSlurper对象  XmlSlurper xml = new XmlSlurper()
 *  2.解析方法： parseText()、parse() -->默认会把根节点去掉
 *  3.获取xml节点文本内容
 *   text()
 *  4.获取xml某个节点属性值
 * @属性名称
 * 5.遍历
 *  depthFirst（）深度遍历
 *  节点对象.children()广度遍历
 *
 */

String xml = '''
 <value version="1.0" encoding="UTF-8">
   <noteList>
        <note>
            <to>北京1</to>
            <from>建安1</from>
            <heading>Reminder</heading>
            <body  id="123">星期一返回</body>
        </note>
        <note>
            <to>南京</to>
            <from>山西</from>
            <heading>Reminder</heading>
            <body class ='noteClass'>星期二返回</body>
        </note>
   </noteList>
   
      <noteList id ='2'>
        <note>
            <to>南京</to>
            <from>山西1</from>
            <heading>Reminder</heading>
            <body class ='noteClass2'>星期二返回</body>
        </note>
   </noteList>
 </value>

'''

/**
 * 使用XmlSlurper对象的parText()方法
 */
println "使用parseText方法解析xml"
XmlSlurper xmlSlurper = new XmlSlurper()
def response = xmlSlurper.parseText(xml)
/**
 * 1.获取xml节点文本内容
 */
println "解析节点文本结果：${response.noteList[1].note[0].to.text()}"

/**
 * 2.获取xml某个节点属性值
 */
println "解析节点文本属性结果：${response.noteList[0].note[1].body.@class}"

/**
 * 3.对xml子节点进行遍历
 */

def listResult = []
println "对xml子节点进行遍历筛选："
response.noteList.each() {
        //对noteList下面的节点note进行遍历
    def noteLists ->
        //对note下面的子节点进行遍历
        noteLists.note.each() {
            def note ->
                def str = note.from.text()
                if (str.contains('山西')) {
                    listResult.add(str)
                }
        }
}
println "对xml双层遍历筛选的结果：${listResult}"

/**
 * 4.使用depthFirst深度遍历
 */
def depthResult = response.depthFirst().findAll() {
    note ->
        String id = note.body.@id
        id == "123"
}.collect() {
    note -> note.body.text()
}
println "使用depthFirst()筛选的结果：${depthResult}"

/**
 * 5.使用children广度遍历
 */
def childResult = response.noteList.note.children().findAll() {
    node ->
        //节点名称
        String name = node.name()
        //节点下属性名称
        String atr = node.@class
        name == 'body' && atr == 'noteClass2'
}.collect() {
    node -> node.body.text() + " 节点名称：" + node.body.name()
}

println "广度遍历结果:${childResult}"
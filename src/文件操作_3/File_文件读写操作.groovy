package 文件操作_3

import 面向对象_2.class1.Person_1

/**
 * --》文件读取
 *  1.eachLine()读取每一行 readLines()：读取所有行
 *  2.getText() 获取文件所有内容
 *
 *  3.读取文件部分内容
 *  withReader（）
 *  4.向文件中写入对象--》withObjectOutputStream
 *  eg:
 *  writerFile.withObjectOutputStream {out -> out.writeObject(obj)}*
 *  (2)文件读取对象--》withObjectInputStream
 *  eg.
 *  readFile.withObjectInputStream {inputStream -> inputStream.readObject()}*
 *
 *  5.

 */

/**
 * 1.文件每一行进行读取
 */
def path = "/Users/tianyejun/work/IDEAWorkSpace/StudyGroovy/StudyGroovy.iml"
def file = new File(path)
file.eachLine {
    println it
}
/**
 * 2.读取文件所有内容
 */
println "使用getText()获取文件内容"
println file.getText()

/**
 * 2.读取文件部分内容
 */
println "使用withReader()获取文件内容"
String mid = file.withReader() {
    reader ->
        char[] buffer = new char[100]
        reader.read(buffer)
        return buffer
}
println mid

/**
 * 3.文件的读取并写入文件
 */

def copyFile(String readPath, String writePath) {
    try {
        //首先创建目标文件
        def writerFile = new File(writePath)
        if (!writerFile.exists()) {
            writerFile.createNewFile()
        }
        //开始copy
        new File(readPath).withReader {
            reader ->
                //读取所有文件行数
                def lines = reader.readLines()
                //开始写入文本
                writerFile.withWriter {
                    writer ->
                        lines.each {
                                //写入并添加换行操作
                            line -> writer.append(line).append("\r\n")
                        }
                }
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
}

def targetPath = "/Users/tianyejun/work/IDEAWorkSpace/StudyGroovy/StudyGroovy2.iml"
copyFile(path, targetPath)

/**
 * 4. 向文件中写入对象操作
 */
println "向文件中写入对象开始"

def writeObject(Object obj, String targetPath) {
    try {
        def writerFile = new File(targetPath)
        if (!writerFile.exists()) {
            writerFile.createNewFile()
        }
        writerFile.withObjectOutputStream {
            out -> out.writeObject(obj)
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
}

def person = new Person_1(name: '张三', age: 30)
def objPath = "/Users/tianyejun/work/IDEAWorkSpace/StudyGroovy/StudyGroovy2.so"
writeObject(person, objPath)
println "向文件中写入对象---完成"
println "读取文件中对象---开始"

def readObject(String targetPath) {
    try {
        def readFile = new File(targetPath)
        return readFile.withObjectInputStream {
            inputStream -> inputStream.readObject()
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
}

def object = readObject(objPath) as Person_1
println "读取文件对象结果--> name:${object.name} age：${object.age}"



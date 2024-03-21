package 面向对象_2.class2

class EntryTest {
    public static void main(String[] args) {
        println "应用程序正在启动。。。"
        //初始化
        ApplicationManager.init()
        println "应用程序初始化完成"

        def person = PersonManager.createPerson("lisi", 20)
        println "the person name is ${person.name} the person age is ${person.age}"
    }
}

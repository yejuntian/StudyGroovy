package 数据结构_1
/**
 * 闭包三个重要变量this、owner、delegate
 * 总结:
 * 1.在大多数情况下this、owner、delegate它的值是一样的
 * 2.在闭包中定义闭包的时候，this、owner、delegate的值不一样，owner指向闭包对象
 * 3.在闭包中修改改了delegate的值，delegate指向被修改的数值
 *
 * 委托策略
 * Closure.DELEGATE_FIRST 在delegate中找不到对应属性的值会查找owner对象属性指向的值
 */

def clouser = {
    println "clouser闭包 this:${this}"//代表闭包定义处的类
    println "clouser闭包 owner:${owner}"//代表闭包定义处的类或者对象
    println "clouser闭包 delegate:${delegate}"//代表任意对象，有一个默认值，默认值与owner一直
}

//闭包调用
//clouser()
clouser.call()
println "使用内部类，看this、owner、delegate三个变量具体区别"
//定义一个内部类Person
class Person {
    def classClouser = {
        println "classClouser this:${this}"
        println "classClouser owner:${owner}"
        println "classClouser delegate:${delegate}"
    }

    def say() {
        def classClouser = {
            println "method-classClouser this:${this}"
            println "method-classClouser owner:${owner}"
            println "method-classClouser delegate:${delegate}"
        }
        classClouser.call()
    }
}

Person p = new Person()
p.classClouser.call()
p.say()


println "在闭包中定义闭包看三个变量的不同"

def outClouser = {
    def inner = {
        println "innerClouser this:${this}"
        println "innerClouser owner:${owner}"
        println "innerClouser delegate:${delegate}"
    }
    inner.delegate = p //修改默认delegate指向
//    inner.call("hello")
}
//outClouser.call()

println "闭包的委托策略"

class Student {
    String name
    def pretty = {
        return "my name is ${name}"
    }

    public String toString() {
        pretty.call()
    }
}

class Teacher {
    String name
}

Student student = new Student(name: "zhang san")
Teacher teacher = new Teacher(name: "li ming")
//修改delegate
student.pretty.delegate = teacher
//修改委托策略
student.pretty.resolveStrategy = Closure.DELEGATE_FIRST
println student.toString()




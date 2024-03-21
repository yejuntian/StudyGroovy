package 面向对象_2.class1

/**
 * groovy定义的类
 * 1.无论直接.或者get/set最终都是调用的get/set方法
 * 2.使用metaClass可以为类动态的添加属性和方法
 * eg:
 *  1）. 添加属性--》 类名.metaClass.新属性名=新属性值
 *  Person_1.metaClass.sex = "male"
 *  2）.添加方法--》类名.metaClass.新方法名=闭包函数
 *  (1)非静态方法 -->类名.metaClass.static.新方法名=闭包函数
 *      Person_1.metaClass.static.createPerson = {
          String name, int age
          -> return new Person_1(name: name, age: age)
         }
         def person3 = Person_1.createPerson("账务", 10)

   作用：在修改第三方库的时候，特别在修改第三方库动态添加属性和方法，发挥作用
 *
 */
def person = new Person_1(name: "张三", age: 20)
println "姓名name : ${person.name} 年龄age : ${person.age}"
println "对象person调用increaseAge方法：${person.increaseAge(10)}"
println "对象person调用eat方法：${person.eat()}"

println "调用person对象没有的方法：cry（）"
person.cry("cry")

/**
 * 使用metaClass为类动态添加一个属性
 */
println "使用metaClass添加属性:sex"
Person_1.metaClass.sex = "male"
def newPerson = new Person_1(name: '李绍', age: 30)
println "输出metaClass新添加的属性值:${newPerson.sex}"

/**
 * 使用metaClass为类动态添加一个非静态方法
 */
println "使用metaClass添加方法sexToUpperCase()"
Person_1.metaClass.grade = "grade one class"
def methodPerson = new Person_1(name: 'li si', age: 36)
Person_1.metaClass.sexToUpperCase = { String str
    -> return methodPerson.grade.toUpperCase() + " is " + str.toUpperCase()
}
println "输出metaClass新添加的方法返回值:${methodPerson.sexToUpperCase(" good")}"

/**
 * 使用metaClass为类动态添加一个静态方法
 */
Person_1.metaClass.static.createPerson = {
    String name, int age
        -> return new Person_1(name: name, age: age)
}
def person3 = Person_1.createPerson("账务", 10)
println "输出metaClass新添加的静态方法createPerson():"
println "name = ${person3.name} age = ${person3.age}"

package 面向对象_2.class2

import 面向对象_2.class1.Person_1

/**
 * 模拟一个应用管理类
 */
class ApplicationManager {
    static void init() {
        //使应用生命周期全局话
        ExpandoMetaClass.enableGlobally()
        //模拟为第三方库添加方法
        Person_1.metaClass.static.createPerson = {
            String name, int age
                -> return new Person_1(name: name, age: age)
        }
    }
}


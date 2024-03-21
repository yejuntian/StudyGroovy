package 面向对象_2.class1
/**
 * groovy中默认都是public
 * 注意：
 * groovy对象调用不存在的方法时，
 * 先调用methodMissing找不到时再调用invokeMethod
 *
 */
class Person_1 implements DefaultAction_1, Serializable {
    String name
    Integer age

    def increaseAge(Number age) {
        return this.age += age
    }

    @Override
    def eat() {
        return "苹果"
    }

    /**
     * 一个方法找不到时，调用它代替
     * @param name
     * @param args
     * @return
     */
    @Override
    def invokeMethod(String name, Object args) {
        println "invokeMethod的方法名称：${name} 参数：${args}"
    }

    def methodMissing(String name, def args) {
        println "methodMissing的方法名称：${name} 参数：${args}"
    }
}

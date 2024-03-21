package 文件操作_3

import groovy.xml.MarkupBuilder

/**
 * --》xml生成 MarkupBuilder：生成xml文件的核心类
 *  1.创建XmlSlurper对象  XmlSlurper xml = new XmlSlurper()
 *  2.根据java类动态生成xml
 *   下面有例子
 *
 */

/*
    <catalog id='1' clazz ='cateLog'>
        <cd id = 'cd1'>
            <title id = 'title' clazz = 'classTilte1'>empire burlesque</title>
            <country>usa</country>
            <price>1</price>
        </cd>
        <cd id = 'cd2'>
            <title id = 'title2' clazz = 'classTilte2'>hide your heart</title>
            <country>uk</country>
             <price>2</price>
        </cd>
    </catalog>
*/
def sbw = new StringWriter()
MarkupBuilder markupBuilder = new MarkupBuilder(sbw)
//创建xml根节点成功
markupBuilder.catalog(id: '1', clazz: 'cateLog') {
    //创建第二级子节点成功
    cd(id: 'cd1') {
        //创建last子节点
        title(id: 'title', clazz: 'classTitle1', 'empire burlesque') {}
        country('usa') {}
        price('1') {}
    }
}

println "创建的xml为"
println sbw

/**
 * 根据java类动态生成xml
 */
class cataLog {
    //对应xml属性
    String id = '1'
    String clazz = 'cateLog'
    def ca = [
            new Ca(id: 'cd1', title:
                    new Title(id: 'title', clazz: "classTilte1", value: 'empire burlesque'),
                    country: 'usa', price: '1'),
            new Ca(id: 'cd2', title:
                    new Title(id: 'title2', clazz: "classTilte2", value: 'hide your heart'),
                    country: 'uk', price: '2')
    ]

}

class Ca {
    String id
    Title title
    String country
    String price
}

class Title {
    String id
    String clazz
    String value
}

println "使用java类动态生成xml"
def sbw2 = new StringWriter()
MarkupBuilder markupBuilder2 = new MarkupBuilder(sbw2)
def cate = new cataLog()
markupBuilder2.cataLog(id: cate.id, clazz: cate.clazz) {
    //对子节点进行遍历
    cate.ca.each {
        c ->
            ca(id: c.id) {
                //创建根节点
                title(id: c.title.id, clazz: c.title.clazz, c.title.value) {}
                country(c.country) {}
                price(c.price) {}
            }
    }
}

println sbw2












package com;


import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

/**
 * Java JDK 里的 sax 解析方式
 *
 * @author Administrator
 */
public class JavaSax {
    // 定义保存整个解析结果的集合
    static ArrayList<Person> persons;
    // 定义解析标志变量
    static boolean nameTag = false;
    static boolean weightTag = false;
    static boolean heightTag = false;
    static boolean ageTag = false;
    static  boolean addressTag = false;
    static boolean sexTag = false;
    static Person person;


    static class SaxHandler extends DefaultHandler2 {

        Person currentGood = null;

        /**
         * 整个文档开始解析的事件回调
         */
        @Override
        public void startDocument() throws SAXException {
            // TODO Auto-generated method stub
            super.startDocument();
            System.out.println("文档开始解析");

            ////////////////////////////////////////////////////////////////////////////////
            // 当文档开始解析，我们可以给ArrayList<Good> goods; 这个集合 赋值，比如 goods = new ArrayList();
            ////////////////////////////////////////////////////////////////////////////////
            persons =  new ArrayList<>();
        }

        /**
         * 整个文档解析的结束事件回调
         */
        @Override
        public void endDocument() throws SAXException {
            // TODO Auto-generated method stub
            System.out.println();
            System.out.println("文档解析结束");
            System.out.println(persons);
            super.endDocument();
        }

        /**
         * 标签结点开始解析事件
         */
        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            // TODO Auto-generated method stub
            System.out.println();
            System.out.println("开始 解析标签事件");
            System.out.println("qName=" + qName);
            System.out.println("attributes=" + attributes.getValue(0));
            switch (qName){
                case "person":
                    person = new Person();
                    person.setId(attributes.getValue(0));

                case "name":
                    nameTag=true;
                    break;
                case  "age":
                    ageTag=true;
                    break;
                case  "sex":
                    sexTag = true;
                    break;
                case  "address":
                    addressTag = true;
                    break;
                case "weight":
                    weightTag = true;
                    break;
                case "height":
                    heightTag = true;
                    break;
                default:
                    break;
            }

            //////////////////  解题思路     ///////////////////////
            //  if ( qName == good ) {     创建一个 good 对象,赋值给currentGood变量
            //  } else if ( qName == name ) {    	 nameTag = true;
            //  } else if ( qName == price ) {      priceTag = true;
            //  } else if ( qName == author ) {    authorTag = true;
            //  }
            /////////  一个标签中的属性，可以通过遍历 函数 参数attributes获取     ///////
            //   attributes.getLength()
            //   attributes.getQName(index)
            //   attributes.getLocalName(index)
            //   attributes.getValue(qName)
            //   attributes.getValue(index)
            ////////通过上面几个方法的调用，看看返回的值是什么，就可以获取到属性了////////


        }

        /**
         * 标签结点解析结束事件
         */
        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("结束 解析标签事件");
            System.out.println("qName=" + qName);
            if (qName.equals(person)){
                persons.add(person);
                person = null;
            }

            //////////////////  解题思路     ///////////////////////
            //  if ( qName == good ) {    把  currentGood 添加到    ArrayList<Good> goods 的集合中
            //  } else if ( qName == name ) {    	 nameTag = false;
            //  } else if ( qName == price ) {      priceTag = false;
            //  } else if ( qName == author ) {    authorTag = false;
            //  }
            /////////////////////////////////////////


        }

        /**
         * 文本结点解析事件
         */
        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {

            System.out.println("文本结点解析事件");
            System.out.println("文本结点内容 ：(" + new String(ch, start, length) + ")");
            String str = new String(ch, start, length);
            if (nameTag == true){
                person.setName(str);
                nameTag = false;
            }else if (ageTag == true){
                person.setAge(Integer.valueOf(str));
                ageTag = false;
            }else if (addressTag == true){
                person.setAddress(str);
                addressTag = false;
            }else if (sexTag == true){
                person.setSex(str);
                sexTag = false;
            }else if (weightTag == true){
                person.setWeight(Double.valueOf(str));
                weightTag = false;
            }else if (heightTag == true){
                person.setHeight(Double.valueOf(str));
                heightTag = false;
            }
            //////////////////  解题思路     ///////////////////////
            //  if ( nameTag == good ) {  设置name属性值     currentGood.setName()
            //  } else if ( priceTag == name ) {  设置price属性值  	currentGood.setPrice()
            //  } else if ( authorTag == price ) {  设置author属性值       currentGood.setAuthor()
            //  }
            //////////////////////////////////////////////////

        }

    }

    /**
     * @param args
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public static void main(String[] args) throws ParserConfigurationException,
            SAXException, IOException {
        // 通过SAXParserFactory对象创建一个sax解析器对象
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        // xml 的 sax 方式解析
        SaxHandler handler = new SaxHandler();
        saxParser.parse(JavaSax.class.getResourceAsStream("/WEB-INF/person.xml"), handler);

    }
}

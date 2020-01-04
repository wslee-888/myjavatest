package com.liws.io;


import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.jdom2.Attribute;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.junit.Test;
import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class IOStreamXML {
//方式一：java 的 DOM
//方式二：java 的 SAX

    class SAXDemoHandel extends DefaultHandler {
        //遍历xml文件开始标签
        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            System.out.println("sax解析开始");
        }

        //遍历xml文件结束标签
        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
            System.out.println("sax解析结束");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            if (qName.equals("student")) {
                System.out.println("============开始遍历student=============");
                //System.out.println(attributes.getValue("rollno"));
            } else if (!qName.equals("student") && !qName.equals("class")) {
                System.out.print("节点名称:" + qName + "----");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            if (qName.equals("student")) {
                System.out.println(qName + "遍历结束");
                System.out.println("============结束遍历student=============");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            String value = new String(ch, start, length).trim();
            if (!value.equals("")) {
                System.out.println(value);
            }
        }
    }


 //方式三：JDOM

// 方式四：DOM4J



    @Test
    public void domXMLTest() throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Dom生成XML

        Document d1 = builder.newDocument();
        d1.setXmlStandalone(true);
        //d1.setPrefix("哈哈哈");
        d1.setDocumentURI("http://192.168.1.191:8896/Shop?XML");
        Element element1 = d1.createElement("shop");

        element1.setAttribute("xmlns","http://maven.apache.org/POM/4.0.0");
        element1.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
        element1.setAttribute("xsi:schemaLocation","http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd");


//       Attr attr1 = d1.createAttribute("xmlns");
//        element1.setAttributeNode(attr1);
//
//        Attr attr2 = d1.createAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:xmlns");
//        //element1.setAttributeNodeNS(attr2);
//        element1.setAttributeNode(attr2);
//
//        Attr attr3 = d1.createAttributeNS("http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd","schemaLocation");
//        element1.setAttributeNode(attr3);


        Element element2 = d1.createElement("name");
        element2.setTextContent("测试门店");
        element1.appendChild(element2);

        element2 = d1.createElement("status");
        element2.setTextContent("1");
        element1.appendChild(element2);

        element2 = d1.createElement("buildTime");
        element2.setTextContent("2019-12-31 00:00:00");
        element1.appendChild(element2);

        Element element3 = d1.createElement("SAList");
        element1.appendChild(element3);

        Element element5 = d1.createElement("SA");
        element3.appendChild(element5);

        Element element6 = d1.createElement("name");
        element6.setTextContent("老王");
        element5.appendChild(element6);

        element6 = d1.createElement("喜好");
        element6.setTextContent("住你隔壁");
        element5.appendChild(element6);


        element5 = d1.createElement("SA");
        element3.appendChild(element5);

        element6 = d1.createElement("name");
        element6.setTextContent("小李");
        element5.appendChild(element6);


        element6 = d1.createElement("喜好");
        element6.setTextContent("兴趣广泛");
        element5.appendChild(element6);

        d1.appendChild(element1);

        TransformerFactory  tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();

        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.transform(new DOMSource(d1), new StreamResult(new File("C:\\Users\\fcz01\\Desktop\\poi\\Shop.xml")));



        //Dom解析XML
        Document d2 = builder.parse("C:\\Users\\fcz01\\Desktop\\poi\\Shop.xml");
        NodeList sList = d2.getChildNodes();
        //NodeList sList = d2.getElementsByTagName("shop");

         //element(sList);
        for (int i = 0; i <sList.getLength() ; i++) {
            Node node = sList.item(i);
            NodeList childNodes = node.getChildNodes();
            for (int j = 0; j <childNodes.getLength() ; j++) {
                if (childNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
                    System.out.print(childNodes.item(j).getNodeName() + ":");
                    System.out.println(childNodes.item(j).getFirstChild().getNodeValue());

                    NodeList childNodes2 = childNodes.item(j).getChildNodes();
                    for(int k = 0; k < childNodes2.getLength(); k++){
                        if (childNodes2.item(k).getNodeType()==Node.ELEMENT_NODE) {
                            System.out.print(childNodes2.item(k).getNodeName() + ":");
                            System.out.println(childNodes2.item(k).getFirstChild().getNodeValue());



                            NodeList childNodes3 = childNodes2.item(k).getChildNodes();
                            for(int m = 0; m < childNodes3.getLength(); m++){
                                if (childNodes3.item(m).getNodeType()==Node.ELEMENT_NODE) {
                                    System.out.print(childNodes3.item(m).getNodeName() + ":");
                                    System.out.println(childNodes3.item(m).getFirstChild().getNodeValue());
                                }

                            }

                        }

                    }
                }
            }
        }
    }



    @Test
    public void saxXML() throws  Exception{

        SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();

        // 2、通过SAXTransformerFactory创建一个TransformerHandler的对象
        TransformerHandler handler = tff.newTransformerHandler();
        // 3、通过handler创建一个Transformer对象
        Transformer tr = handler.getTransformer();
        // 4、通过Transformer对象对生成的xml文件进行设置
        // 设置编码方式
        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        // 设置是否换行
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        // 5、创建一个Result对象
        File f = new File("C:\\Users\\fcz01\\Desktop\\poi\\bookShop.xml");
        // 判断文件是否存在
        if(!f.exists()){
            f.createNewFile();
        }
        Result result = new StreamResult(new FileOutputStream(f));
        // 6、使RESULT与handler关联
        handler.setResult(result);

        // 打开document
        handler.startDocument();
        AttributesImpl attr = new AttributesImpl();
        attr.addAttribute("","","id","","888888");
        attr.addAttribute("","","src","","测试");

        handler.startElement("","","bookShop",attr);


        attr.clear();
        attr.addAttribute("","","id","","666666");

        handler.startElement("","","book",attr);

        attr.clear();
        handler.startElement("", "", "name", attr);
        handler.characters("三国演义".toCharArray(), 0, "三国演义".length());
        handler.endElement("", "", "name");

        attr.clear();
        handler.startElement("", "", "year", attr);
        handler.characters("2019-12-31 08:58:26".toCharArray(), 0, "2019-12-31 00:00:00".length());
        handler.endElement("", "", "year");


        attr.clear();
        handler.startElement("", "", "author", attr);
        handler.characters("罗贯中".toCharArray(), 0, "罗贯中".length());
        handler.endElement("", "", "author");


        handler.endElement("","","book");


        attr.clear();
        attr.addAttribute("","","id","","999999");

        handler.startElement("","","book",attr);

        attr.clear();
        handler.startElement("", "", "name", attr);
        handler.characters("诗经".toCharArray(), 0, "诗经".length());
        handler.endElement("", "", "name");

        attr.clear();
        handler.startElement("", "", "year", attr);
        handler.characters("2019-12-31 18:28:23".toCharArray(), 0, "2019-12-31 00:00:00".length());
        handler.endElement("", "", "year");


        attr.clear();
        handler.startElement("", "", "author", attr);
        handler.characters("好人".toCharArray(), 0, "好人".length());
        handler.endElement("", "", "author");


        handler.endElement("","","book");


        handler.endElement("","","bookShop");
        handler.endDocument();



        //1.SAXParserFactory实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.获取SAXparser实例
        SAXParser saxParser = factory.newSAXParser();
        //创建Handel对象
        SAXDemoHandel handel = new SAXDemoHandel();
        saxParser.parse("C:\\Users\\fcz01\\Desktop\\poi\\bookShop.xml",handel);
    }


    @Test
    public void jdomXML() throws Exception{

        // 1、生成一个根节点
        org.jdom2.Element rss = new org.jdom2.Element("rss");
        // 2、为节点添加属性
        rss.setAttribute("version", "2.0");
        // 3、生成一个document对象
        org.jdom2.Document document = new org.jdom2.Document(rss);

        org.jdom2.Element channel = new org.jdom2.Element("channel");
        rss.addContent(channel);
        org.jdom2.Element title = new org.jdom2.Element("title");
        title.setText("国内最新新闻");
        channel.addContent(title);

        Format format = Format.getCompactFormat();
        // 设置换行Tab或空格
        format.setIndent("	");
        format.setEncoding("UTF-8");

        // 4、创建XMLOutputter的对象
        XMLOutputter outputer = new XMLOutputter(format);
        // 5、利用outputer将document转换成xml文档
        File file = new File("C:\\Users\\fcz01\\Desktop\\poi\\News.xml");
        outputer.output(document, new FileOutputStream(file));


        //1.创建SAXBuilder对象
        SAXBuilder saxBuilder = new SAXBuilder();
        //2.创建输入流
        InputStream is = new FileInputStream(new File("C:\\Users\\fcz01\\Desktop\\poi\\News.xml"));
        //3.将输入流加载到build中
        org.jdom2.Document doc = saxBuilder.build(is);
        //4.获取根节点
        org.jdom2.Element rootElement = doc.getRootElement();
        //5.获取子节点
        List<org.jdom2.Element> children = rootElement.getChildren();
        for (org.jdom2.Element child : children) {
            System.out.println("通过rollno获取属性值:"+child.getAttribute("rollno"));
            List<Attribute> attributes = child.getAttributes();
            //打印属性
            for (Attribute attr : attributes) {
                System.out.println(attr.getName()+":"+attr.getValue());
            }
            List<org.jdom2.Element> childrenList = child.getChildren();
            System.out.println("======获取子节点-start======");
            for (org.jdom2.Element o : childrenList) {
                System.out.println("节点名:"+o.getName()+"---"+"节点值:"+o.getValue());
            }
            System.out.println("======获取子节点-end======");
        }
    }

    @Test
    public void dom4jXML() throws Exception{

        // 1、创建document对象
        org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
        // 2、创建根节点rss
        org.dom4j.Element rss = document.addElement("rss");
        // 3、向rss节点添加version属性
        rss.addAttribute("version", "2.0");
        // 4、生成子节点及子节点内容
        org.dom4j.Element channel = rss.addElement("channel");
        org.dom4j.Element title = channel.addElement("title");
        title.setText("国内最新新闻");
        // 5、设置生成xml的格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 设置编码格式
        format.setEncoding("UTF-8");


        // 6、生成xml文件
        File file = new File("C:\\Users\\fcz01\\Desktop\\poi\\News2.xml");
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        // 设置是否转义，默认使用转义字符
        writer.setEscapeText(false);
        writer.write(document);
        writer.close();


     //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        org.dom4j.Document doc = reader.read(new File("C:\\Users\\fcz01\\Desktop\\poi\\News2.xml"));
        //3.获取根节点
        org.dom4j.Element rootElement = doc.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()){
            org.dom4j.Element stu = (org.dom4j.Element) iterator.next();
            List<Attribute> attributes = stu.attributes();
            System.out.println("======获取属性值======");
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getValue());
            }
            System.out.println("======遍历子节点======");
            Iterator iterator1 = stu.elementIterator();
            while (iterator1.hasNext()){
                org.dom4j.Element stuChild = (org.dom4j.Element) iterator1.next();
                System.out.println("节点名："+stuChild.getName()+"---节点值："+stuChild.getStringValue());
            }
        }
    }

}

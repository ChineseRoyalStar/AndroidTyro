package com.example.armada.networktest;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ContentHandler extends DefaultHandler {

    private String nodeName;

    private StringBuilder from;

    private StringBuilder to;

    private StringBuilder heading;

    private StringBuilder body;

    @Override
    public void startDocument() throws SAXException {
        from = new StringBuilder();
        to = new StringBuilder();
        heading = new StringBuilder();
        body = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        nodeName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 根据当前的节点名判断将内容添加到哪一个StringBuilder对象中
        if ("from".equals(nodeName)) {
            from.append(ch,start,length);
        }else if ("to".equals(nodeName)) {
            to.append(ch,start,length);
        }else if ("heading".equals(nodeName)) {
            heading.append(ch,start,length);
        }else if ("body".equals(nodeName)) {
            body.append(ch,start,length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("note".equals(nodeName)) {
            // 最后要将StringBuilder清空掉
            from.setLength(0);
            to.setLength(0);
            heading.setLength(0);
            body.setLength(0);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        Log.d("ContentHandler", "from " + from.toString().trim());
        Log.d("ContentHandler", "to " + to.toString().trim());
        Log.d("ContentHandler", "heading " + heading.toString().trim());
        Log.d("ContentHandler", "body " + body.toString().trim());
        super.endDocument();
    }
}

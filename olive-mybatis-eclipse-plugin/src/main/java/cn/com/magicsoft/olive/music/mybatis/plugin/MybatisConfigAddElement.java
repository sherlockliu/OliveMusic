/*     */ package com.yougou.mybatis.plugins;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerConfigurationException;
/*     */ import javax.xml.transform.TransformerException;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.DocumentType;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ 
/*     */ public class MybatisConfigAddElement
/*     */ {
/*     */   public static void appendGeneratorXml(String configFilePath, String confileFilePackagePath, String xmlFileName)
/*     */   {
/*  27 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*  28 */     factory.setValidating(false);
/*     */     try {
/*  30 */       DocumentBuilder builder = factory.newDocumentBuilder();
/*  31 */       Document doc = builder.parse(new File(configFilePath));
/*  32 */       doc.setXmlStandalone(true);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  51 */       NodeList nodeList = doc.getElementsByTagName("mappers");
/*     */       
/*  53 */       if (nodeList.getLength() > 0) {
/*  54 */         if (confileFilePackagePath.length() > 0) {
/*  55 */           confileFilePackagePath = 
/*     */           
/*     */ 
/*  58 */             confileFilePackagePath + "/";
/*     */         }
/*  60 */         xmlFileName = confileFilePackagePath + xmlFileName;
/*     */         
/*  62 */         NodeList mapperList = doc.getElementsByTagName("mapper");
/*  63 */         boolean flag = false;
/*  64 */         for (int i = 0; i < mapperList.getLength(); i++) {
/*  65 */           NamedNodeMap map = mapperList.item(i).getAttributes();
/*  66 */           if (map.getNamedItem("resource").getNodeValue() != null)
/*     */           {
/*     */ 
/*  69 */             if (map.getNamedItem("resource").getNodeValue().equals(xmlFileName)) {
/*  70 */               flag = true;
/*  71 */               break;
/*     */             } }
/*     */         }
/*  74 */         if (flag) {
/*  75 */           return;
/*     */         }
/*     */         
/*  78 */         Node mappersNode = nodeList.item(0);
/*  79 */         Element mapperNode = doc.createElement("mapper");
/*  80 */         mapperNode.setAttribute("resource", xmlFileName);
/*     */         
/*  82 */         mappersNode.appendChild(mapperNode);
/*     */         
/*  84 */         doc.normalizeDocument();
/*  85 */         TransformerFactory tfactory = TransformerFactory.newInstance();
/*  86 */         Transformer transformer = tfactory.newTransformer();
/*  87 */         DOMSource source = new DOMSource(doc);
/*  88 */         StreamResult result = new StreamResult(new File(configFilePath));
/*  89 */         transformer.setOutputProperty("indent", "yes");
/*  90 */         transformer.setOutputProperty(
/*  91 */           "cdata-section-elements", "yes");
/*  92 */         transformer.setOutputProperty(
/*  93 */           "{http://xml.apache.org/xslt}indent-amount", "2");
/*     */         
/*  95 */         transformer.setOutputProperty("doctype-public", doc.getDoctype().getPublicId());
/*  96 */         transformer.setOutputProperty("doctype-system", doc.getDoctype().getSystemId());
/*     */         
/*  98 */         transformer.setOutputProperty("encoding", "UTF-8");
/*  99 */         transformer.transform(source, result);
/*     */       }
/*     */     } catch (ParserConfigurationException e) {
/* 102 */       e.printStackTrace();
/*     */     } catch (SAXException e) {
/* 104 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 106 */       e.printStackTrace();
/*     */     } catch (TransformerConfigurationException e) {
/* 108 */       e.printStackTrace();
/*     */     } catch (TransformerException e) {
/* 110 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }
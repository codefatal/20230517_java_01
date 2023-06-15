package kh.lclass.openapi.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import kh.lclass.openapi.model.vo.MetalMeasuringVo;

public class MetalMeasuringService extends Thread {
	List<MetalMeasuringVo> meMeList = new ArrayList<>();
	
	@Override
	public void run() {
		BufferedReader rd = null;
		HttpURLConnection conn = null;
		try {
			String serviceKey = "t0AUyWBLB4/6G8QnmNB9b9EFoBQkHSVO/L0Rdx6f4FbNjsi/D8jmfiKA6vxXbTS8N4zDjeYUpww2/g3LMoI0yQ==";
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/1480523/MetalMeasuringResultService/MetalService"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+serviceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
			urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*결과형식(XML/JSON)*/
			urlBuilder.append("&" + URLEncoder.encode("date","UTF-8") + "=" + URLEncoder.encode("20230107", "UTF-8")); /*검색조건 날짜 (예시 : 20171208)*/
			urlBuilder.append("&" + URLEncoder.encode("stationcode","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*검색조건 측정소코드*/
			urlBuilder.append("&" + URLEncoder.encode("itemcode","UTF-8") + "=" + URLEncoder.encode("90303", "UTF-8")); /*검색조건 항목코드*/
			urlBuilder.append("&" + URLEncoder.encode("timecode","UTF-8") + "=" + URLEncoder.encode("RH02", "UTF-8")); /*검색조건 시간구분*/
			URL url = new URL(urlBuilder.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			
			// XML parse 통해서 VO 형태에 담기
			Document doc = parseXML(conn.getInputStream());
			
			NodeList descNodes = doc.getElementsByTagName("item");
			
			for(int j=0; j<descNodes.getLength(); j++) {
				MetalMeasuringVo vo = new MetalMeasuringVo();
				
				Node item = descNodes.item(j);
				
				for(Node node = item.getFirstChild();
						node!=null;
						node=node.getNextSibling()
					) {
					if(node.getNodeName().equals("#text")) {
						continue;
					}
					System.out.println(node.getNodeName()+" : "+node.getTextContent());
					switch(node.getNodeName()) {
					case "sdate":
						vo.setSdate(node.getTextContent());
						break;
					case "stationcode":
						vo.setStationcode(node.getTextContent());
						break;
					case "itemcode":
						vo.setItemcode(node.getTextContent());
						break;
					case "timecode":
						vo.setTimecode(node.getTextContent());
						break;
					case "value":
						vo.setValue(node.getTextContent());
						break;
					}
				}
				meMeList.add(vo);
			}
			System.out.println(meMeList);
			
			
//        BufferedReader rd;
//        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        } else {
//            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//        }
//        StringBuilder sb = new StringBuilder();
//        String line;
//        while ((line = rd.readLine()) != null) {
//            sb.append(line);
//        }
//        rd.close();
//			conn.disconnect();
//        System.out.println(sb.toString());
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rd!=null) rd.close();
				if(conn!=null) conn.disconnect();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Document parseXML(InputStream stream) {
		DocumentBuilderFactory objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder objDocumentBuilder = null;
		Document doc = null;

		try {
			objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
			doc = objDocumentBuilder.parse(stream);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) { // Simple API for XML
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
}

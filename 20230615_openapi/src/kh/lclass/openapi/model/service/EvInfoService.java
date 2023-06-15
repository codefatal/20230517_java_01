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

import kh.lclass.openapi.model.vo.EvInfoVo;


public class EvInfoService extends Thread{
	List<EvInfoVo> evInfoList = new ArrayList<>();
	
	@Override
	public void run() {
		int failCnt = 3;  // 3회 재시도시에도 실패되면 더이상 data 읽어오지 않도록 함.
		for(int i=0; i<1; i++) {
			BufferedReader rd = null;
			HttpURLConnection conn = null;
//			StringBuilder sb = null;
			try {
				String serviceKey = "0qgE1MiS1v%2BqHOh5jN4JWnUOzqqL99QjdRnMWUfjNHFJ2G9lRi4%2B%2FjyP2iZ8MXuBsYKXoywkqLhh2O9fchXWyQ%3D%3D";
				StringBuilder urlBuilder = new StringBuilder(
						"http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList"); /* URL */
				urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "="+serviceKey); /* Service Key */
				urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(i+1), "UTF-8")); /* 페이지번호 */
				urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
						+ URLEncoder.encode("5", "UTF-8")); /* 한 페이지 결과 수 */
				//urlBuilder.append("&" + URLEncoder.encode("addr", "UTF-8") + "="+ URLEncoder.encode("전라남도 나주시 빛가람동 120", "UTF-8")); /* 검색대상 충전소주소 */
				//System.out.println(urlBuilder);
				URL url = new URL(urlBuilder.toString());
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/json");
				System.out.println("Response code: " + conn.getResponseCode());
				
//				if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				} else {
//					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//				}
//				sb = new StringBuilder();
//				String line;
//				while ((line = rd.readLine()) != null) {
//					sb.append(line);
//				}
				
				Document doc = parseXML(conn.getInputStream());
				
				NodeList descNodes = doc.getElementsByTagName("item");
				
				for(int j=0; j<descNodes.getLength(); j++) {
					EvInfoVo vo = new EvInfoVo();
					
					Node item = descNodes.item(j);
					
					for(Node node = item.getFirstChild();
							node != null;
							node = node.getNextSibling()
									// 첫번째 자식을 시작으로 마지막까지 다음 형제를 실행
						) {
						System.out.println(node.getNodeName()+" : "+node.getTextContent());
						switch(node.getNodeName()) {
						case "chargeTp":
							vo.setChargeTp(Integer.parseInt(node.getTextContent()));
							break;
						case "cpId":
							vo.setCpId(node.getTextContent());
							break;
						case "cpNm":
							vo.setCpNm(node.getTextContent());
							break;
						case "csNm":
							vo.setCsNm(node.getTextContent());
							break;
						// TODO:
						}
					}
					evInfoList.add(vo);
				}
				System.out.println(evInfoList);
			} catch(IOException e) {
				// 오류발생
				if(failCnt==0) {
					break;
				}
				failCnt--;
				i--;
				e.printStackTrace();
			} finally {
				try {
					if(rd!=null)rd.close();
					if(conn!=null)conn.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
//			System.out.println(sb.toString());
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
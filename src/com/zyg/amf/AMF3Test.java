package com.zyg.amf;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import flex.messaging.io.SerializationContext;
import flex.messaging.io.amf.Amf3Input;

public class AMF3Test {
	public static void main(String[] args) {
		// 序列化
		SerializationContext sercontext = new SerializationContext(); 
		Amf3Input amfinput = new Amf3Input(sercontext);

		try {
			long time1 = System.currentTimeMillis();
			int times = 10;
			//测试性能
			for(int i=0;i<times;i++)
			{
				FileInputStream fos = new FileInputStream("test.amf");
				DataInputStream dos = new DataInputStream(fos);
				amfinput.setInputStream(dos);
				HashMap<?, ?> map = (HashMap<?, ?>) amfinput.readObject();
				
				Iterator<?> iter = map.entrySet().iterator();
				while (iter.hasNext()) {
					@SuppressWarnings("rawtypes")
					Map.Entry entry = (Map.Entry) iter.next();
					Object key = entry.getKey();
					Object val = entry.getValue();
					System.out.println("key="+key+",value="+val);
				}
			}
			System.out.println("\ncost time="+(System.currentTimeMillis() - time1));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

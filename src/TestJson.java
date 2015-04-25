
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.taobao.tmallsearch.result.api.AppCustomModules.ParamEntry;

public class TestJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new LinkedHashMap<String,String>(){
			{
				put("qq","wq");
				put("2","wq");
				put("3","wq");
			}			
		};
		List list = new ArrayList();
		if(map!=null){
			for(Entry<String,String> entry : map.entrySet()){
				ParamEntry pe = new ParamEntry(entry.getKey(), entry.getValue());
				list.add(pe);
			}
		}
		
		System.out.println(JSON.toJSONString(list));
	}

}

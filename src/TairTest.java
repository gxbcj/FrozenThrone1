
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.taobao.diamond.client.Diamond;
import com.taobao.diamond.manager.ManagerListener;
import com.taobao.tair.DataEntry;
import com.taobao.tair.Result;
import com.taobao.tair.TairManager;
import com.taobao.tair.impl.mc.MultiClusterTairManager;
import com.taobao.tmallsearch.common.bucket.BucketAlias;
import com.taobao.tmallsearch.common.logger.Logger;
import com.taobao.tmallsearch.common.logger.LoggerFactory;
import com.taobao.tmallsearch.manager.tair.NewPopularTrend;
import com.taobao.tmallsearch.query.ListProductSearchQuery;
import com.taobao.tmallsearch.query.api.ApiProductSearchQuery;



public class TairTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		 MultiClusterTairManager mcTairManager = new MultiClusterTairManager();
	     mcTairManager.setConfigID("ldbcommon-daily"); //对应diamond上的dataid，从审批结果中获取
	     mcTairManager.setDynamicConfig(true);  //非常重要，不要忘记
	     System.out.println("xxxxxxxxxxxxxxx");
	     mcTairManager.init();
	     System.out.println("***********");
	     
	     
	     Result<DataEntry> keys = mcTairManager.get(1195, "iPhone7");
	     System.out.println("---------");
	     if(keys!=null && keys.isSuccess() && keys.getValue()!= null){
	    	 System.out.println("ppppppppppppp"+JSON.parseObject((String)keys.getValue().getValue(), HashSet.class));
		 }
	     
	     Result<DataEntry> keys2 = mcTairManager.get(1195, "searchKeys");
	     System.out.println("============");
	     if(keys!=null && keys.isSuccess() && keys.getValue()!= null){
	    	 System.out.println("qqqqqqqqqqq"+JSON.parseObject((String)keys.getValue().getValue(), HashSet.class));
	     }
	     
	 
	}

}

package xyz.zhhg.zblog.web.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import xyz.zhhg.zblog.web.pojo.Message;

public interface MessageDao {
	public void leaveMessage(Message message);
	public List<Message> getLMessagesfromMasterId(BigInteger id);
	
	public void deleteMessageFromIdList(List<BigInteger> idList);
	
	public List<Message> getMessageList(Map<String, Object> conditionMap);
}

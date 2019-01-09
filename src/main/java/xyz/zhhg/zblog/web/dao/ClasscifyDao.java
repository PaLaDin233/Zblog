package xyz.zhhg.zblog.web.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.zhhg.zblog.web.pojo.Classcify;

public interface ClasscifyDao {
	public int insertClasscify(Classcify classcify);
	public List<Classcify> getClasscify(@Param("superior")BigInteger superior);
	public int updateClasscify(Classcify classcify);
}

package xyz.zhhg.zblog.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.zhhg.zblog.pojo.Menu;

public interface MenuDao {
	public List<Menu> getMenuBySuperiorId(@Param(value="superiorId")BigInteger superiorId);
}

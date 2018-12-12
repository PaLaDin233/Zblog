package xyz.zhhg.zblog.dao;

import java.math.BigInteger;
import java.util.List;

import xyz.zhhg.zblog.pojo.Menu;

public interface MenuDao {
	public List<Menu> getMenuBySuperiorId(BigInteger superiorId);
}

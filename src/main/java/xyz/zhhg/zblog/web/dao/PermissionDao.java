package xyz.zhhg.zblog.web.dao;

import java.util.List;

public interface PermissionDao {

	List<String> getPermissionByUserName(String username);

}

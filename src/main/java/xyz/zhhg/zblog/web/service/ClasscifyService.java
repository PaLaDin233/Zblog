package xyz.zhhg.zblog.web.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.lang.exception.DeleteException;
import xyz.zhhg.zblog.web.pojo.Classcify;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.baseinterface.Deleteable;
import xyz.zhhg.zblog.web.service.baseinterface.Insertable;
import xyz.zhhg.zblog.web.service.baseinterface.Searchable;
import xyz.zhhg.zblog.web.service.baseinterface.Updateable;

public interface ClasscifyService extends Insertable<Classcify>,Deleteable<BigInteger>,Updateable<Classcify>,Searchable<Classcify>{
	boolean delete(Classcify t)throws DeleteException;

	List<Classcify> getClasscify(User user);
}

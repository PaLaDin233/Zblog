package xyz.zhhg.zblog.web.pojo.form;

import java.math.BigInteger;
import java.util.List;

public class DeleteArticleForm {
	List<BigInteger> idList;

	public List<BigInteger> getIdList() {
		return idList;
	}

	public void setIdList(List<BigInteger> idList) {
		this.idList = idList;
	}

	@Override
	public String toString() {
		return "DeleteArticleForm [idList=" + idList + "]";
	}
	
}	

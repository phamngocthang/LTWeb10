package dao;

import java.util.List;
import java.util.Map;

import entity.Billdetail;

public class DaoBillDetail extends IDAO<Billdetail>{
	@Override
	public List<Billdetail> findAll(String queryString) {
		// TODO Auto-generated method stub
		return super.findAll(queryString);
	}
	
	@Override
	public void nativeQuery(String HQL, Map<String, Object> params) {
		// TODO Auto-generated method stub
		super.nativeQuery(HQL, params);
	}
}

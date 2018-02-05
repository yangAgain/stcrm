package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.DicMapper;
@Service("dicService")
public class DicService<T> extends BaseService<T> {

	@Autowired
	private DicMapper<T> dicMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return dicMapper;
	}

}

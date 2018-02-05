package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.ClassMapper;

@Service("classService")
public class ClassService<T> extends BaseService<T> {

	@Autowired
	private ClassMapper<T> classMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return classMapper;
	}

}

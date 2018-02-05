package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.CreateQuestionMapper;

@Service("createQuestionQuestionQaRelService")
public class CreateQuestionQuestionQaRelService<T> extends BaseService<T> {

	@Autowired
	private CreateQuestionMapper<T> createQuestionMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return createQuestionMapper;
	}

}

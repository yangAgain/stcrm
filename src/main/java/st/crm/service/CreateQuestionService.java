package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.CreateQuestionMapper;
import st.crm.model.CreateQuestionModel;

@Service("createQuestionService")
public class CreateQuestionService<T> extends BaseService<T> {

	@Autowired
	private CreateQuestionMapper<T> createQuestionMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return createQuestionMapper;
	}

	public void updateName(CreateQuestionModel cqm) {
		createQuestionMapper.updateName(cqm);
	}

}

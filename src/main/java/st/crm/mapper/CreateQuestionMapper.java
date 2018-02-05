package st.crm.mapper;

import st.core.mapper.BaseMapper;
import st.crm.model.CreateQuestionModel;

public interface CreateQuestionMapper<T> extends BaseMapper<T> {

	void updateName(CreateQuestionModel cqm);

}

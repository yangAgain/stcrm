package st.crm.mapper;

import java.util.List;

import st.core.mapper.BaseMapper;
import st.crm.model.UserModel;

public interface UserMapper<T> extends BaseMapper<T> {

	List<UserModel> selectAboutQA(UserModel um);

}

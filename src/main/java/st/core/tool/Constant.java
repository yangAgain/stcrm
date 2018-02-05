package st.core.tool;

import java.util.ResourceBundle;

public class Constant {

	protected static final ResourceBundle res1 = ResourceBundle.getBundle("prop");

	public final static Integer STU_CHECK = Integer.parseInt(res1.getString("STU_CHECK"));
	public final static Integer STU_LEAVE = Integer.parseInt(res1.getString("STU_LEAVE"));
	public final static Integer GRADE_STANDARD = Integer.parseInt(res1.getString("GRADE_STANDARD"));
	public final static Integer MENU_TYPE_ONE = Integer.parseInt(res1.getString("MENU_TYPE_ONE"));
	public final static Integer MENT_TYPE_TWO = Integer.parseInt(res1.getString("MENT_TYPE_TWO"));

	public final static Integer SYS_ADMIN_0 = Integer.parseInt(res1.getString("SYS_ADMIN_0"));
	public final static Integer SYS_ADMIN_1 = Integer.parseInt(res1.getString("SYS_ADMIN_1"));;

	// 鐘舵�佹爣蹇�-0=绂佺敤,1=鍙敤
	public final static Integer SYS_STATE_0 = Integer.parseInt(res1.getString("SYS_STATE_0"));
	public final static Integer SYS_STATE_1 = Integer.parseInt(res1.getString("SYS_STATE_1"));

	// 鍒犻櫎鏍囧織-0=鏈垹,1=宸插垹
	public final static Integer SYS_DELETED_0 = Integer.parseInt(res1.getString("SYS_DELETED_0"));
	public final static Integer SYS_DELETED_1 = Integer.parseInt(res1.getString("SYS_DELETED_1"));

	// 鍏宠仈绫诲瀷锛�1=A鐢ㄦ埛B鑿滃崟锛�
	public final static Integer SYS_REL_TYPE1 = Integer.parseInt(res1.getString("SYS_REL_TYPE1"));

	public final static String SYS_SESSION_USER = res1.getString("SYS_SESSION_USER");
	public final static String SYS_SESSION_VALIDATECODE = res1.getString("SYS_SESSION_VALIDATECODE");// 楠岃瘉鐮�
	public final static String SYS_ACTION_SUCCESS = res1.getString("SYS_ACTION_SUCCESS");
	public final static String SYS_ACTION_MSG = res1.getString("SYS_ACTION_MSG");
	public final static String SYS_DEFAULT_PASSWORD = res1.getString("SYS_DEFAULT_PASSWORD");

	public final static String MENU_ID = res1.getString("MENU_ID"); // 绠＄悊鍛樺乏渚ф姌鍙犺彍鍗�

	public final static String SERVER_WEB_TITLE = res1.getString("SERVER_WEB_TITLE");
	public final static String SERVER_USER_ADMIN = res1.getString("SERVER_USER_ADMIN");
	public final static String SERVER_AUTO = res1.getString("SERVER_AUTO");
	public final static String SERVER_msUrl = res1.getString("SERVER_msUrl");
	public final static String SERVER_NAME = res1.getString("SERVER_NAME");
	public final static String SERVER_easyuiUrl = res1.getString("SERVER_easyuiUrl");
	public final static String SERVER_TOMCAT = res1.getString("SERVER_TOMCAT");
}
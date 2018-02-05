package st.core.tool;

import java.math.BigDecimal;

public class FormatMath {

    // 榛樿闄ゆ硶杩愮畻绮惧害
    private static final int DEFAULT_DIV_SCALE = 10;

    /**
     * 鎻愪緵绮剧�?�鐨勫姞娉曡繍绠椼��?
     * 
     * @param v1
     * @param v2
     * @return 涓や釜鍙傛暟鐨勫�?
     */
    public static BigDecimal add(Double v1, Double v2) {
        boolean f1 = v1 == null;
        boolean f2 = v2 == null;
        if (f1 && f2) {
            return null;
        }
        if (f1) {
            return new BigDecimal(Double.toString(v2));
        }
        if (f2) {
            return new BigDecimal(Double.toString(v1));
        }
        return new BigDecimal(Double.toString(v1)).add(new BigDecimal(Double.toString(v2)));
    }

    /**
     * 鎻愪緵绮剧�?�鐨勫姞娉曡繍绠�?
     * 
     * @param v1
     * @param v2
     * @return 涓や釜鍙傛暟鏁板鍔犲拰锛屼互�?�楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal add(String v1, String v2) {
        boolean f1 = FormatEmpty.isEmpty(v1);
        boolean f2 = FormatEmpty.isEmpty(v2);
        if (f1 && f2) {
            return null;
        }
        if (f1) {
            return new BigDecimal(v2);
        }
        if (f2) {
            return new BigDecimal(v1);
        }
        return new BigDecimal(v1).add(new BigDecimal(v2));
    }

    /**
     * 鎻愪緵绮剧�?�鐨勫姞娉曡繍绠�?
     * 
     * @param v1
     * @param v2
     * @return 涓や釜鍙傛暟鏁板鍔犲拰锛屼互�?�楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
        boolean f1 = FormatEmpty.isEmpty(v1);
        boolean f2 = FormatEmpty.isEmpty(v2);
        if (f1 && f2) {
            return null;
        }
        if (f1) {
            return v2;
        }
        if (f2) {
            return v1;
        }
        return v1.add(v2);
    }

    /**
     * 鎻愪緵绮剧�?�鐨勫噺娉曡繍绠椼��?
     * 
     * @param v1
     * @param v2
     * @return 涓や釜鍙傛暟鐨勫�?
     */
    public static BigDecimal subtract(Double v1, Double v2) {
        boolean f1 = v1 == null;
        boolean f2 = v2 == null;
        if (f1 && f2) {
            return null;
        }
        if (f1) {
            return new BigDecimal(Double.toString(v2));
        }
        if (f2) {
            return new BigDecimal(Double.toString(v1));
        }
        return new BigDecimal(Double.toString(v1)).subtract(new BigDecimal(Double.toString(v2)));
    }

    /**
     * 鎻愪緵绮剧�?�鐨勫噺娉曡繍绠�?
     * 
     * @param v1
     * @param v2
     * @return 涓や釜鍙傛暟鏁板宸紝浠ュ瓧绗︿覆鏍煎紡杩斿洖
     */
    public static BigDecimal subtract(String v1, String v2) {
        boolean f1 = FormatEmpty.isEmpty(v1);
        boolean f2 = FormatEmpty.isEmpty(v2);
        if (f1 && f2) {
            return null;
        }
        if (f1) {
            return new BigDecimal(v2);
        }
        if (f2) {
            return new BigDecimal(v1);
        }
        return new BigDecimal(v1).subtract(new BigDecimal(v2));
    }

    /**
     * 鎻愪緵绮剧�?�鐨勫噺娉曡繍绠�?
     * 
     * @param v1
     * @param v2
     * @return 涓や釜鍙傛暟鏁板宸紝浠ュ瓧绗︿覆鏍煎紡杩斿洖
     */
    public static BigDecimal subtract(BigDecimal v1, BigDecimal v2) {
        boolean f1 = FormatEmpty.isEmpty(v1);
        boolean f2 = FormatEmpty.isEmpty(v2);
        if (f1 && f2) {
            return null;
        }
        if (f1) {
            return v2;
        }
        if (f2) {
            return v1;
        }
        return v1.subtract(v2);
    }

    /**
     * 鎻愪緵绮剧�?�鐨勪箻娉曡繍绠椼��?
     * 
     * @param v1
     * @param v2
     * @return 涓や釜鍙傛暟鐨勭Н
     */
    public static BigDecimal multiply(Double v1, Double v2) {
        boolean f1 = v1 == null;
        boolean f2 = v2 == null;
        if (f1 && f2) {
            return null;
        }
        if (f1) {
            return new BigDecimal(Double.toString(v2));
        }
        if (f2) {
            return new BigDecimal(Double.toString(v1));
        }
        return new BigDecimal(Double.toString(v1)).multiply(new BigDecimal(Double.toString(v2)));
    }

    /**
     * 鎻愪緵绮剧�?�鐨勪箻娉曡繍绠�?
     * 
     * @param v1
     * @param v2
     * @return 涓や釜鍙傛暟鐨勬暟�?�︾Н锛屼互�?�楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal multiply(String v1, String v2) {
        boolean f1 = FormatEmpty.isEmpty(v1);
        boolean f2 = FormatEmpty.isEmpty(v2);
        if (f1 && f2) {
            return null;
        }
        if (f1) {
            return new BigDecimal(v2);
        }
        if (f2) {
            return new BigDecimal(v1);
        }
        return new BigDecimal(v1).multiply(new BigDecimal(v2));
    }

    /**
     * 鎻愪緵绮剧�?�鐨勪箻娉曡繍绠�?
     * 
     * @param v1
     * @param v2
     * @return 涓や釜鍙傛暟鐨勬暟�?�︾Н锛屼互�?�楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal multiply(BigDecimal v1, BigDecimal v2) {
        boolean f1 = FormatEmpty.isEmpty(v1);
        boolean f2 = FormatEmpty.isEmpty(v2);
        if (f1 && f2) {
            return null;
        }
        if (f1) {
            return v2;
        }
        if (f2) {
            return v1;
        }
        return v1.multiply(v2);
    }

    /**
     * 鎻愪緵锛堢浉瀵癸級绮剧�?�鐨勯櫎娉曡繍绠楋紝褰撳彂鐢熼櫎涓嶅敖鐨勬儏鍐垫椂锛�?簿纭埌 灏忔暟鐐逛互鍚�10浣嶏紝浠ュ悗鐨勬暟�?�楀洓鑸嶄簲鍏�,鑸嶅叆妯″紡閲囩敤ROUND_HALF_EVEN
     * 
     * @param v1
     * @param v2
     * @return 涓や釜鍙傛暟鐨勫�?
     */
    public static BigDecimal divide(Double v1, Double v2) {
        return divide(v1, v2, DEFAULT_DIV_SCALE);
    }

    /**
     * 鎻愪緵锛堢浉瀵癸級绮剧�?�鐨勯櫎娉曡繍绠椼�傚綋鍙戠敓闄や笉灏界殑鎯呭喌鏃讹紝鐢眘cale鍙傛暟鎸�? 瀹氱簿搴︼紝浠ュ悗鐨勬暟瀛楀洓鑸嶄簲鍏ャ�傝垗鍏ユā寮忛噰鐢≧OUND_HALF_EVEN
     * 
     * @param v1
     * @param v2
     * @param scale
     *            琛ㄧず闇�瑕佺簿纭埌灏忔暟鐐�?�互鍚庡嚑浣嶃��?
     * @return 涓や釜鍙傛暟鐨勫�?
     */
    public static BigDecimal divide(Double v1, Double v2, int scale) {
        return divide(v1, v2, scale, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * 鎻愪緵锛堢浉瀵癸級绮剧�?�鐨勯櫎娉曡繍绠椼�傚綋鍙戠敓闄や笉灏界殑鎯呭喌鏃讹紝鐢眘cale鍙傛暟鎸�? 瀹氱簿搴︼紝浠ュ悗鐨勬暟瀛楀洓鑸嶄簲鍏ャ�傝垗鍏ユā寮忛噰鐢ㄧ敤鎴锋寚瀹氳垗鍏ユā寮�?
     * 
     * @param v1
     * @param v2
     * @param scale
     *            琛ㄧず闇�瑕佺簿纭埌灏忔暟鐐�?�互鍚庡嚑浣�?
     * @param round_mode
     *            琛ㄧず鐢ㄦ埛鎸囧畾鐨勮垗鍏ユā寮�
     * @return 涓や釜鍙傛暟鐨勫�?
     */
    public static BigDecimal divide(Double v1, Double v2, int scale, int round_mode) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        boolean f1 = v1 == null;
        boolean f2 = v2 == null;
        if (f1 && f2) {
            return null;
        }
        if (f1) {
            return new BigDecimal(Double.toString(v2));
        }
        if (f2) {
            return new BigDecimal(Double.toString(v1));
        }
        return new BigDecimal(Double.toString(v1)).divide(new BigDecimal(Double.toString(v2)), scale, round_mode);
    }

    /**
     * 鎻愪緵锛堢浉瀵癸級绮剧�?�鐨勯櫎娉曡繍绠楋紝褰撳彂鐢熼櫎涓嶅敖鐨勬儏鍐垫椂锛�?簿纭埌 灏忔暟鐐逛互鍚�10浣嶏紝浠ュ悗鐨勬暟�?�楀洓鑸嶄簲鍏�,鑸嶅叆妯″紡閲囩敤ROUND_HALF_EVEN
     * 
     * @param v1
     * @param v2
     * @return 涓や釜鍙傛暟鐨勫晢锛屼互瀛楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal divide(String v1, String v2) {
        return divide(v1, v2, DEFAULT_DIV_SCALE);
    }

    /**
     * 鎻愪緵锛堢浉瀵癸級绮剧�?�鐨勯櫎娉曡繍绠椼�傚綋鍙戠敓闄や笉灏界殑鎯呭喌鏃讹紝鐢眘cale鍙傛暟鎸�? 瀹氱簿搴︼紝浠ュ悗鐨勬暟瀛楀洓鑸嶄簲鍏ャ�傝垗鍏ユā寮忛噰鐢≧OUND_HALF_EVEN
     * 
     * @param v1
     * @param v2
     * @param scale
     *            琛ㄧず闇�瑕佺簿纭埌灏忔暟鐐�?�互鍚庡嚑浣�?
     * @return 涓や釜鍙傛暟鐨勫晢锛屼互瀛楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal divide(String v1, String v2, int scale) {
        return divide(v1, v2, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * 鎻愪緵锛堢浉瀵癸級绮剧�?�鐨勯櫎娉曡繍绠椼�傚綋鍙戠敓闄や笉灏界殑鎯呭喌鏃讹紝鐢眘cale鍙傛暟鎸�? 瀹氱簿搴︼紝浠ュ悗鐨勬暟瀛楀洓鑸嶄簲鍏ャ�傝垗鍏ユā寮忛噰鐢ㄧ敤鎴锋寚瀹氳垗鍏ユā寮�?
     * 
     * @param v1
     * @param v2
     * @param scale
     *            琛ㄧず闇�瑕佺簿纭埌灏忔暟鐐�?�互鍚庡嚑浣�?
     * @param round_mode
     *            琛ㄧず鐢ㄦ埛鎸囧畾鐨勮垗鍏ユā寮�
     * @return 涓や釜鍙傛暟鐨勫晢锛屼互瀛楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal divide(String v1, String v2, int scale, int round_mode) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        boolean f1 = FormatEmpty.isEmpty(v1);
        boolean f2 = FormatEmpty.isEmpty(v2);
        if (f1 && f2) {
            return null;
        }
        if (f1) {
            return new BigDecimal(v2);
        }
        if (f2) {
            return new BigDecimal(v1);
        }
        return new BigDecimal(v1).divide(new BigDecimal(v2), scale, round_mode);
    }

    /**
     * 鎻愪緵锛堢浉瀵癸級绮剧�?�鐨勯櫎娉曡繍绠楋紝褰撳彂鐢熼櫎涓嶅敖鐨勬儏鍐垫椂锛�?簿纭埌 灏忔暟鐐逛互鍚�10浣嶏紝浠ュ悗鐨勬暟�?�楀洓鑸嶄簲鍏�,鑸嶅叆妯″紡閲囩敤ROUND_HALF_EVEN
     * 
     * @param v1
     * @param v2
     * @return 涓や釜鍙傛暟鐨勫晢锛屼互瀛楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal divide(BigDecimal v1, BigDecimal v2) {
        return divide(v1, v2, DEFAULT_DIV_SCALE);
    }

    /**
     * 鎻愪緵锛堢浉瀵癸級绮剧�?�鐨勯櫎娉曡繍绠椼�傚綋鍙戠敓闄や笉灏界殑鎯呭喌鏃讹紝鐢眘cale鍙傛暟鎸�? 瀹氱簿搴︼紝浠ュ悗鐨勬暟瀛楀洓鑸嶄簲鍏ャ�傝垗鍏ユā寮忛噰鐢≧OUND_HALF_EVEN
     * 
     * @param v1
     * @param v2
     * @param scale
     *            琛ㄧず闇�瑕佺簿纭埌灏忔暟鐐�?�互鍚庡嚑浣�?
     * @return 涓や釜鍙傛暟鐨勫晢锛屼互瀛楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal divide(BigDecimal v1, BigDecimal v2, int scale) {
        return divide(v1, v2, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * 鎻愪緵锛堢浉瀵癸級绮剧�?�鐨勯櫎娉曡繍绠椼�傚綋鍙戠敓闄や笉灏界殑鎯呭喌鏃讹紝鐢眘cale鍙傛暟鎸�? 瀹氱簿搴︼紝浠ュ悗鐨勬暟瀛楀洓鑸嶄簲鍏ャ�傝垗鍏ユā寮忛噰鐢ㄧ敤鎴锋寚瀹氳垗鍏ユā寮�?
     * 
     * @param v1
     * @param v2
     * @param scale
     *            琛ㄧず闇�瑕佺簿纭埌灏忔暟鐐�?�互鍚庡嚑浣�?
     * @param round_mode
     *            琛ㄧず鐢ㄦ埛鎸囧畾鐨勮垗鍏ユā寮�
     * @return 涓や釜鍙傛暟鐨勫晢锛屼互瀛楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal divide(BigDecimal v1, BigDecimal v2, int scale, int round_mode) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        boolean f1 = FormatEmpty.isEmpty(v1);
        boolean f2 = FormatEmpty.isEmpty(v2);
        if (f1 && f2) {
            return null;
        }
        if (f1) {
            return v2;
        }
        if (f2) {
            return v1;
        }
        return v1.divide(v2, scale, round_mode);
    }

    /**
     * 鎻愪緵绮剧�?�鐨勫皬鏁颁綅鍥涜垗浜斿叆澶勭悊,鑸嶅叆妯″紡閲囩敤ROUND_HALF_EVEN
     * 
     * @param v
     *            闇�瑕佸洓鑸嶄簲鍏ョ殑鏁板瓧
     * @param scale
     *            灏忔暟鐐瑰悗淇濈�?鍑犱�?
     * @return 鍥涜垗浜斿叆鍚庣殑缁撴灉
     */
    public static BigDecimal round(Double v, int scale) {
        return round(v, scale, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * 鎻愪緵绮剧�?�鐨勫皬鏁颁綅鍥涜垗浜斿叆澶勭悊
     * 
     * @param v
     *            闇�瑕佸洓鑸嶄簲鍏ョ殑鏁板瓧
     * @param scale
     *            灏忔暟鐐瑰悗淇濈�?鍑犱�?
     * @param round_mode
     *            鎸囧畾鐨勮垗鍏ユā寮�
     * @return 鍥涜垗浜斿叆鍚庣殑缁撴灉
     */
    public static BigDecimal round(Double v, int scale, int round_mode) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        if (v == null) {
            return null;
        }
        return new BigDecimal(Double.toString(v)).setScale(scale, round_mode);
    }

    /**
     * 鎻愪緵绮剧�?�鐨勫皬鏁颁綅鍥涜垗浜斿叆澶勭悊,鑸嶅叆妯″紡閲囩敤ROUND_HALF_EVEN
     * 
     * @param v
     *            闇�瑕佸洓鑸嶄簲鍏ョ殑鏁板瓧
     * @param scale
     *            灏忔暟鐐瑰悗淇濈�?鍑犱�?
     * @return 鍥涜垗浜斿叆鍚庣殑缁撴灉锛屼互�?�楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal round(String v, int scale) {
        return round(v, scale, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * 鎻愪緵绮剧�?�鐨勫皬鏁颁綅鍥涜垗浜斿叆澶勭悊
     * 
     * @param v
     *            闇�瑕佸洓鑸嶄簲鍏ョ殑鏁板瓧
     * @param scale
     *            灏忔暟鐐瑰悗淇濈�?鍑犱�?
     * @param round_mode
     *            鎸囧畾鐨勮垗鍏ユā寮�
     * @return 鍥涜垗浜斿叆鍚庣殑缁撴灉锛屼互�?�楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal round(String v, int scale, int round_mode) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        if (FormatEmpty.isEmpty(v)) {
            return null;
        }
        return new BigDecimal(v).setScale(scale, round_mode);
    }

    /**
     * 鎻愪緵绮剧�?�鐨勫皬鏁颁綅鍥涜垗浜斿叆澶勭悊,鑸嶅叆妯″紡閲囩敤ROUND_HALF_EVEN
     * 
     * @param v
     *            闇�瑕佸洓鑸嶄簲鍏ョ殑鏁板瓧
     * @param scale
     *            灏忔暟鐐瑰悗淇濈�?鍑犱�?
     * @return 鍥涜垗浜斿叆鍚庣殑缁撴灉锛屼互�?�楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal round(BigDecimal v, int scale) {
        return round(v, scale, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * 鎻愪緵绮剧�?�鐨勫皬鏁颁綅鍥涜垗浜斿叆澶勭悊
     * 
     * @param v
     *            闇�瑕佸洓鑸嶄簲鍏ョ殑鏁板瓧
     * @param scale
     *            灏忔暟鐐瑰悗淇濈�?鍑犱�?
     * @param round_mode
     *            鎸囧畾鐨勮垗鍏ユā寮�
     * @return 鍥涜垗浜斿叆鍚庣殑缁撴灉锛屼互�?�楃涓叉牸寮忚繑鍥�?
     */
    public static BigDecimal round(BigDecimal v, int scale, int round_mode) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        if (FormatEmpty.isEmpty(v)) {
            return null;
        }
        return v.setScale(scale, round_mode);
    }

    public static Double valueDouble(BigDecimal v) {
        return v == null ? null : v.doubleValue();
    }

}

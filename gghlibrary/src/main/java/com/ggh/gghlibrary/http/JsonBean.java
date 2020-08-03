package com.ggh.gghlibrary.http;

/**
 * @Author Create by mcl
 * @Date 2020/3/11
 * @ClassName JsonBean
 * @描述
 */
public class JsonBean<T> {

    /**
     * meta : {"code":200,"msg":"OK"}
     * data : {"id":2,"text":"<p>一、特别提示<br><br>在此特别提醒您（用户）在注册成为共想享用户之前，请认真阅读本《共想享用户服务协议》 （以下简称\u201c协议\u201d），确保您充分理解本协议中各条款。请您审慎阅读并选择接受或不接 受本协议。除非您接受本协议所有条款，否则您无权注册、登录或使用本协议所涉服务。您的注册、登录、使用等行为将视为对本协议的接受，并同意接受本协议各项条款的约束。<br><br>二、账号注册<br><br>1、鉴于共想享账号的绑定注册方式，您同意临共想享上公交在注册时将允许您的手机号码及手机 设备识别码等信息用于注册。\")<br><br>2、在用户注册及使用本服务时，共想享有限公司需要搜集能识别用户身份的个人信息以便共想享有限公司可以在必要时联系用户，或为用户提供更好的使用体验。共想享有限公司搜集的信息包括但不限于用户的姓名、身份证号；<br><br>3、为了确保用户可以正常使用该服务，用户需保证临共想享上公交余额大于五元，当余额低于五元时，共想享将无法生成二维码。<br><br>三、账户安全<br><br>1、用户一旦注册成功，成为共想享的用户，将得到一个用户名和密码，并有权利使用自己的用户名及密码随时登陆共想享。<br><br>四、服务内容<br><br>1、共想享具体服务内容由共想享提供：<br><br>（1）共想享有限公司下属公交车辆位置查询；<br><br>（2）使用临共想享上公交二维码乘坐共想享有限公司下属公交车辆的功能。<br><br>2、共想享有限公司将根据实际情况发布推送各类信息。<br><br>3、所有发给用户的通告及其他消息都可通过 APP 或者用户所提供的联系方式发送。<br><br>五、服务的终止<br><br>1、在下列情况下，共想享有限公司有权终止向用户提供服务：<br><br>1）在用户违反本服务协议相关规定时，共想享有限公司有权终止向该用户提供服务。<br><br>2）用户不得通过程序或人工方式进行对本APP破解及其它危害本APP的操作，若发现用户有该类行为，共想享有限公司将立即终止服务，并有权扣留账户内金额。<br><br>六、免责与赔偿声明<br><br>1、请用户在使用过程中，对自己的账号密码妥善保管，不要告知他人，避免给您带来不必要的损失。<br><br>2、本协议最终解释权归共想享有限公司（简称\u201c共想享\u201d）所有。<br><br>3、本协议从 2017年12月15日起适用<br><\/p>"}
     */

    private Meta meta;
    private T data;
    private T page;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getPage() {
        return page;
    }

    public void setPage(T page) {
        this.page = page;
    }

    class Meta{
        private int code;
        private String msg;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "Meta{" +
                    "code=" + code +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "JsonBean{" +
                "meta=" + meta +
                ", data=" + data +
                ", page=" + page +
                '}';
    }
}

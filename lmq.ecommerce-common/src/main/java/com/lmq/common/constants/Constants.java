package com.lmq.common.constants;

public interface Constants {
	
	// ��Ӧcode
		String HTTP_RES_CODE_NAME = "code";
		// ��Ӧmsg
		String HTTP_RES_CODE_MSG = "msg";
		// ��Ӧdata
		String HTTP_RES_CODE_DATA = "data";
		// ��Ӧ����ɹ�
		String HTTP_RES_CODE_200_VALUE = "success";
		// ϵͳ����
		String HTTP_RES_CODE_500_VALUE = "fial";
		// ��Ӧ����ɹ�code
		Integer HTTP_RES_CODE_200 = 200;
		// ֧��token
		String PAY_FAIL = "fail";
		// ֧���ɹ�
		String PAY_SUCCESS = "success";
		// ϵͳ����
		Integer HTTP_RES_CODE_500 = 500;
		//δ����QQ�˺�
				Integer HTTP_RES_CODE_201 = 201;
		
		// �����ʼ�
		String MSG_EMAIL ="email";
		// ֧��token
		String TOKEN_PAY = "TOKEN_pay";
		// ��Աtoken
				String TOKEN_MEMBER ="TOKEN_MEMBER";
				// �û���Ч�� 90��
				Long TOKEN_MEMBER_TIME =(long) (60*60*24*90);
				int COOKIE_TOKEN_MEMBER_TIME =(60*60*24*90);
				// cookie ��Ա totoken ����
				String COOKIE_MEMBER_TOKEN ="cookie_member_token";
				Long PAY_TOKEN_MEMBER_TIME =(long)  (60 * 15 );

}

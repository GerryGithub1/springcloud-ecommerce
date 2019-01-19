package com.lmq.common.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import freemarker.core.ParseException;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author lmq
 *
 */

@Slf4j
public class DateUtils {

	/** ��-��-�� ʱ:��:�� ��ʾ��ʽ */
	// ��ע:���ʹ�ô�дHH��ʶʹ��24Сʱ��ʾ��ʽ,���ʹ��Сдhh�ͱ�ʾʹ��12Сʱ�Ƹ�ʽ��
	public static String DATE_TO_STRING_DETAIAL_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/** ��-��-�� ��ʾ��ʽ */
	public static String DATE_TO_STRING_SHORT_PATTERN = "yyyy-MM-dd";

	private static SimpleDateFormat simpleDateFormat;

	/**
	 * Date����תΪָ����ʽ��String����
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static String DateToString(Date source, String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(source);
	}

	/**
	 * 
	 * unixʱ���תΪָ����ʽ��String����
	 * 
	 * 
	 * System.currentTimeMillis()��õ����Ǵ�1970��1��1�տ�ʼ�������ĺ�����
	 * unixʱ���:�Ǵ�1970��1��1�գ�UTC/GMT����ҹ����ʼ������������,����������
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static String timeStampToString(long source, String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = new Date(source * 1000);
		return simpleDateFormat.format(date);
	}

	/**
	 * ������ת��Ϊʱ���(unixʱ���,��λ��)
	 * 
	 * @param date
	 * @return
	 */
	public static long dateToTimeStamp(Date date) {
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp.getTime() / 1000;

	}

	/**
	 * 
	 * �ַ���ת��Ϊ��Ӧ����(���ܻᱨ���쳣)
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 * @throws java.text.ParseException
	 */
	public static Date stringToDate(String source, String pattern) throws java.text.ParseException {
		simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		date = simpleDateFormat.parse(source);
		return date;
	}

	/**
	 * ��õ�ǰʱ���Ӧ��ָ����ʽ
	 * 
	 * @param pattern
	 * @return
	 */
	public static String currentFormatDate(String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(new Date());

	}

	/**
	 * ��õ�ǰunixʱ���(��λ��)
	 * 
	 * @return ��ǰunixʱ���
	 */
	public static long currentTimeStamp() {
		return System.currentTimeMillis() / 1000;
	}

	/**
	 * 
	 * @methodDesc: ��������:(��ȡ��ǰϵͳʱ���)
	 * @param: @return
	 */
	public static Timestamp getTimestamp() {
		return new Timestamp(new Date().getTime());
	}
}

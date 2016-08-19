package com.lovecws.spring.activemq.entity;

import java.io.Serializable;

public class PhoneNoticeInfo implements Serializable {

	private static final long serialVersionUID = -2694415728580552043L;

	/** 消息标题 */
	public String noticeTitle;
	/** 消息内容 */
	public String noticeContent;
	/** 接收者 */
	public String receiver;
	/** 接收手机号 */
	public String receiverPhone;

	public PhoneNoticeInfo(String noticeTitle, String noticeContent, String receiver, String receiverPhone) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.receiver = receiver;
		this.receiverPhone = receiverPhone;
	}

	public PhoneNoticeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	@Override
	public String toString() {
		return "PhoneNoticeInfo [noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + ", receiver="
				+ receiver + ", receiverPhone=" + receiverPhone + "]";
	}

}
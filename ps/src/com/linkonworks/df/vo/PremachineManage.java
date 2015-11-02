package com.linkonworks.df.vo;

public class PremachineManage implements java.io.Serializable {
	
	private String machine;		//前置机名称
	private String ipAddress;	//前置机地址
	private Integer port;	//端口号
	private Integer state;	//前置机状态
	private String networkIp;	//外网地址
	private String startDate;	//启用时间
	private String endDate;		//停用时间
	private String id;//唯一标识
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PremachineManage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PremachineManage(String machine, String ipAddress, Integer port,
			Integer state, String networkIp, String startDate, String endDate,String id) {
		super();
		this.machine = machine;
		this.ipAddress = ipAddress;
		this.port = port;
		this.state = state;
		this.networkIp = networkIp;
		this.startDate = startDate;
		this.endDate = endDate;
		this.id=id;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getNetworkIp() {
		return networkIp;
	}
	public void setNetworkIp(String networkIp) {
		this.networkIp = networkIp;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}

package com.entity;

public class Yonghu {
    private Integer id;
	private String yonghuming;	private String mima;	private String xingming;	private String xingbie;	private String lianxishouji;	private String dizhi;	private String jifen;	private String quanxian;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
        this.yonghuming = yonghuming == null ? null : yonghuming.trim();
    }	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
        this.mima = mima == null ? null : mima.trim();
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
    }	public String getLianxishouji() {
        return lianxishouji;
    }
    public void setLianxishouji(String lianxishouji) {
        this.lianxishouji = lianxishouji == null ? null : lianxishouji.trim();
    }	public String getDizhi() {
        return dizhi;
    }
    public void setDizhi(String dizhi) {
        this.dizhi = dizhi == null ? null : dizhi.trim();
    }	public String getJifen() {
        return jifen;
    }
    public void setJifen(String jifen) {
        this.jifen = jifen == null ? null : jifen.trim();
    }	public String getQuanxian() {
        return quanxian;
    }
    public void setQuanxian(String quanxian) {
        this.quanxian = quanxian == null ? null : quanxian.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息

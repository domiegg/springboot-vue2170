package com.entity;

public class Youhuiquan {
    private Integer id;
	private String youhuiquanbianhao;	private String youxiaoriqi;	private String shiyongshuoming;	private String yonghu;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getYouhuiquanbianhao() {
        return youhuiquanbianhao;
    }
    public void setYouhuiquanbianhao(String youhuiquanbianhao) {
        this.youhuiquanbianhao = youhuiquanbianhao == null ? null : youhuiquanbianhao.trim();
    }	public String getYouxiaoriqi() {
        return youxiaoriqi;
    }
    public void setYouxiaoriqi(String youxiaoriqi) {
        this.youxiaoriqi = youxiaoriqi == null ? null : youxiaoriqi.trim();
    }	public String getShiyongshuoming() {
        return shiyongshuoming;
    }
    public void setShiyongshuoming(String shiyongshuoming) {
        this.shiyongshuoming = shiyongshuoming == null ? null : shiyongshuoming.trim();
    }	public String getYonghu() {
        return yonghu;
    }
    public void setYonghu(String yonghu) {
        this.yonghu = yonghu == null ? null : yonghu.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息

package com.entity;

public class Gouwuche {
    private Integer id;
	private String shangpinbianhao;	private String shangpinmingcheng;	private String jiage;	private String goumaishuliang;	private String zongjia;	private String goumairen;	private String issh;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShangpinbianhao() {
        return shangpinbianhao;
    }
    public void setShangpinbianhao(String shangpinbianhao) {
        this.shangpinbianhao = shangpinbianhao == null ? null : shangpinbianhao.trim();
    }	public String getShangpinmingcheng() {
        return shangpinmingcheng;
    }
    public void setShangpinmingcheng(String shangpinmingcheng) {
        this.shangpinmingcheng = shangpinmingcheng == null ? null : shangpinmingcheng.trim();
    }	public String getJiage() {
        return jiage;
    }
    public void setJiage(String jiage) {
        this.jiage = jiage == null ? null : jiage.trim();
    }	public String getGoumaishuliang() {
        return goumaishuliang;
    }
    public void setGoumaishuliang(String goumaishuliang) {
        this.goumaishuliang = goumaishuliang == null ? null : goumaishuliang.trim();
    }	public String getZongjia() {
        return zongjia;
    }
    public void setZongjia(String zongjia) {
        this.zongjia = zongjia == null ? null : zongjia.trim();
    }	public String getGoumairen() {
        return goumairen;
    }
    public void setGoumairen(String goumairen) {
        this.goumairen = goumairen == null ? null : goumairen.trim();
    }	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息

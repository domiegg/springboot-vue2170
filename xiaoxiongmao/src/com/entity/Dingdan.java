package com.entity;

public class Dingdan {
    private Integer id;
	private String dingdanbianhao;
	private String neirong;
	private String goumairen;
	private String zongjine;
	private String lianxishouji;
	private String songhuodizhi;
	private String beizhu;
	private String issh;
	private String iszf;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getDingdanbianhao() {
        return dingdanbianhao;
    }
    public void setDingdanbianhao(String dingdanbianhao) {
        this.dingdanbianhao = dingdanbianhao == null ? null : dingdanbianhao.trim();
    }
	public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }
	public String getGoumairen() {
        return goumairen;
    }
    public void setGoumairen(String goumairen) {
        this.goumairen = goumairen == null ? null : goumairen.trim();
    }
	public String getZongjine() {
        return zongjine;
    }
    public void setZongjine(String zongjine) {
        this.zongjine = zongjine == null ? null : zongjine.trim();
    }
	public String getLianxishouji() {
        return lianxishouji;
    }
    public void setLianxishouji(String lianxishouji) {
        this.lianxishouji = lianxishouji == null ? null : lianxishouji.trim();
    }
	public String getSonghuodizhi() {
        return songhuodizhi;
    }
    public void setSonghuodizhi(String songhuodizhi) {
        this.songhuodizhi = songhuodizhi == null ? null : songhuodizhi.trim();
    }
	public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }
	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }
	public String getIszf() {
        return iszf;
    }
    public void setIszf(String iszf) {
        this.iszf = iszf == null ? null : iszf.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息

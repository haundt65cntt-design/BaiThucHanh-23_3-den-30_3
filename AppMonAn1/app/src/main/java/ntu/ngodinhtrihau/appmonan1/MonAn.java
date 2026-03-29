package ntu.ngodinhtrihau.appmonan1;

public class MonAn {

    private String tenMonAn;
    private int donGia;
    private String moTa;
    private int idAnhMinhHoa;

    public MonAn(String tenMonAn, int donGia, String moTa, int idAnhMinhHoa) {
        this.tenMonAn = tenMonAn;
        this.donGia = donGia;
        this.moTa = moTa;
        this.idAnhMinhHoa = idAnhMinhHoa;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public int getDonGia() {
        return donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public int getIdAnhMinhHoa() {
        return idAnhMinhHoa;
    }
}
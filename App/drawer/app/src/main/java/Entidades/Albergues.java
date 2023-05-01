package Entidades;

public class Albergues {
    private Integer IDAlbergue;
    private String NombreAlb;
    private String LatitudAlb;
    private String LongitudAlb;

    private String HoraAperturaAlb;

    public Albergues() {}

    public Albergues(Integer IDAlbergue, String nombreAlb, String latitudAlb, String longitudAlb, String horaAperturaAlb) {
        this.IDAlbergue = IDAlbergue;
        NombreAlb = nombreAlb;
        LatitudAlb = latitudAlb;
        LongitudAlb = longitudAlb;
        HoraAperturaAlb = horaAperturaAlb;
    }

    public Integer getIDAlbergue() {
        return IDAlbergue;
    }

    public void setIDAlbergue(Integer IDAlbergue) {
        this.IDAlbergue = IDAlbergue;
    }

    public String getNombreAlb() {
        return NombreAlb;
    }

    public void setNombreAlb(String nombreAlb) {
        NombreAlb = nombreAlb;
    }

    public String getLatitudAlb() {
        return LatitudAlb;
    }

    public void setLatitudAlb(String latitudAlb) {
        LatitudAlb = latitudAlb;
    }

    public String getLongitudAlb() {
        return LongitudAlb;
    }

    public void setLongitudAlb(String longitudAlb) {
        LongitudAlb = longitudAlb;
    }

    public String getHoraAperturaAlb() {
        return HoraAperturaAlb;
    }

    public void setHoraAperturaAlb(String horaAperturaAlb) {
        HoraAperturaAlb = horaAperturaAlb;
    }

    @Override
    public String toString() {
        return "Albergues{" +
                "IDAlbergue=" + IDAlbergue +
                ", NombreAlb='" + NombreAlb + '\'' +
                ", LatitudAlb='" + LatitudAlb + '\'' +
                ", LongitudAlb='" + LongitudAlb + '\'' +
                ", HoraAperturaAlb='" + HoraAperturaAlb + '\'' +
                '}';
    }
}
